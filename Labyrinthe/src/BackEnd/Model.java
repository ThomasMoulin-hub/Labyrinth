package BackEnd;

import BackEnd.MazeBoxes.*;
import FrontEnd.MainFrame;
import FrontEnd.WindowPanels.Hexagons.Hexagon;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Model {
    //TODO chercher tous les mainframe .get qui sont final genre les panels et tout PAS LES MAZES QUI CHANGENT TOUS LE TEMPS et les init dans InitAfterAlIsInit
    private boolean graphModified = false;
    private final MainFrame mainFrame;
    private Maze maze;
    private final List<ChangeListener> listeners
            = new ArrayList<ChangeListener>();
    private char boxTypeSelected;
    private Color colorSelected;
    private File fichierOuvert;
    private boolean isShortestPathOnScreen = false;
    private ArrayList<VertexInterface> shortestPathList;
    private boolean mazeHasName = true;
    private boolean isControlDown = false;
    private boolean isShiftDown = false;
    private ArrayList<MazeBox> listeDesActions = new ArrayList<>();


    public Model(MainFrame mainFrame){
        this.mainFrame = mainFrame;


    }

    public void zoom(){
        Hexagon.setR(Hexagon.getR() * (1.1));
        stateChanged();
    }
    public void deZoom(){
        Hexagon.setR(Hexagon.getR() * (0.9));
        stateChanged();
    }
    public void addObserver(ChangeListener listener) {
        listeners.add(listener);}

    public void setBoxTypeSelected(char type, Color couleur){
        this.boxTypeSelected = type;
        this.colorSelected = couleur;
    }
    public void setIsControlDown(boolean valueCtrl){this.isControlDown = valueCtrl;}
    public void setIsShiftDown(boolean valueShift){this.isShiftDown = valueShift;}
    public Color getColorSelected(){return this.colorSelected;}
    public boolean getIsControlDown(){return isControlDown;}
    public boolean getIsShiftDown(){return isShiftDown;}
    public void setMazeName(String name){

        graphModified = true;
        mazeHasName = true;
        maze.setName(name);
    }

    public void setFichierOuvert(File fichierOuvert) {
        this.fichierOuvert = fichierOuvert;
    }

    public Maze getMaze(){return maze;}
    public void setShortestPathList(ArrayList<VertexInterface> list){this.shortestPathList = list;}
    public void setMaze(ArrayList<String> labyrintheBluePrints) throws Exception {this.maze = new Maze(labyrintheBluePrints);}

    public void stateChanged() {
        ChangeEvent evt = new ChangeEvent(this) ;

        for (ChangeListener listener : listeners) {
            listener.stateChanged(evt);
        }
    }



    public void quit(){
        if(graphModified){
            if(askIfWantToSave()=="cancel"){
            return;
            }
        }
        mainFrame.dispose();
    }

    public void newMaze(){
        if(graphModified){
            if(askIfWantToSave().equals("cancel")){
                return; //si retourne cancel on abandonne l'action de créer un nouveau maze
            }

        }
        JTextField longueurVerticale = new JTextField();
        JTextField longueurHorizontale = new JTextField();
        Object[] options = {"Hauteur :",longueurVerticale,"Largeur :",longueurHorizontale};
        boolean resultIsInt = false;
        while(!resultIsInt){

            if(JOptionPane.showConfirmDialog(mainFrame,options,"Taille du labyrinthe (en nombre de cases)",JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION){
                return;
            }
            try{
                this.maze = new Maze(Integer.valueOf(longueurVerticale.getText()),Integer.valueOf(longueurHorizontale.getText()));
                resultIsInt= true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(mainFrame,"Veuillez entrer des entiers positifs !");
            }

        }
        mazeHasName = false;
        graphModified = false;
        isShortestPathOnScreen = false;
        listeDesActions = new ArrayList<>();
        stateChanged();
    }

    public void setBox(int x, int y){
        if(isShortestPathOnScreen){
            for(VertexInterface pathBox : shortestPathList){
                int xP = pathBox.getPosition().get(0);
                int yP = pathBox.getPosition().get(1);
                maze.getLabyrinthe()[xP][yP] = new EmptyBox(xP,yP);
            }
            isShortestPathOnScreen = false;
        }
        listeDesActions.add(maze.getLabyrinthe()[x][y]);
        switch(boxTypeSelected){

            case 'E':
                maze.getLabyrinthe()[x][y] = new EmptyBox(x,y);
                graphModified = true;
                break;
            case 'W':
                maze.getLabyrinthe()[x][y] = new WallBox(x,y);
                graphModified = true;
                break;
            case 'D':
                DepartureBox dbox = new DepartureBox(x,y);
                if(maze.getDepartureBox() != null){
                    DepartureBox departureBox = maze.getDepartureBox();
                    int xD = departureBox.getPosition().get(0);
                    int yD = departureBox.getPosition().get(1);
                    maze.getLabyrinthe()[xD][yD] = new EmptyBox(xD,yD);
                }
                maze.getLabyrinthe()[x][y] = dbox;
                maze.setDepartureBox(dbox);
                graphModified = true;
                break;

            case 'A':
                ArrivalBox abox = new ArrivalBox(x,y);
                if(maze.getArrivalBox() != null){
                    ArrivalBox arrivalBox = maze.getArrivalBox();
                    int xA = arrivalBox.getPosition().get(0);
                    int yA = arrivalBox.getPosition().get(1);
                    maze.getLabyrinthe()[xA][yA] = new EmptyBox(xA,yA);
                }

                maze.getLabyrinthe()[x][y] = abox;
                maze.setArrivalBox(abox);
                graphModified = true;
                break;
        }
        maze.checkIfStillArrivalOrDeparture();
        stateChanged();
    }

    public String askFileName(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("src/Sauvegardes"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Nom du labyrinthe (.txt)","txt");
        chooser.setFileFilter(filter);
        int result = chooser.showSaveDialog(mainFrame);
        switch(result){
            case JFileChooser.APPROVE_OPTION:
                String path = chooser.getSelectedFile().getAbsolutePath();
                if(!path.contains(".txt")){
                    path += ".txt";
                }
                return path;
            default:
                return "cancel";
        }

    }

    public void enregistrerSous(){
        if(maze == null){
            return;
        }
        boolean done = false;
        while(!done){
            try{
                String value = askFileName();
                switch(value){
                    case "cancel":
                        return;
                    default:
                        String [] name= value.split("\\\\",0);
                        setMazeName(name[name.length-1]);
                        save(new File(value));
                        stateChanged();

                        done = true;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(mainFrame,"Le nom du fichier n'est pas valide ! " + e.getMessage());
            }

        }
        graphModified = false;

    }

    public void enregistrer(){
        if(maze == null){
            return;
        }
        if(!mazeHasName){
            enregistrerSous();
        }else{
            try{
                save(fichierOuvert);
            }catch(Exception e){

                //rien car si le fichier a été ouvert on considère que son nom est valide
            }

        }
        graphModified = false;
    }

    private void save(File file) throws Exception{
        if(fichierOuvert != file){
            file.createNewFile();
            fichierOuvert = file;
        }
        PrintWriter writer = new PrintWriter(fichierOuvert);
        MazeBox[][] boxes = maze.getLabyrinthe();
        for(MazeBox[] ligne : boxes){
            String chaine = "";
            for(MazeBox box : ligne){
                chaine += box.getBoxType();
            }
            writer.println(chaine);
        }
        writer.close();
    }
    public void retablir(){
        if(listeDesActions.size() > 0){
            MazeBox  boite= listeDesActions.remove(listeDesActions.size()-1);
            maze.getLabyrinthe()[boite.getPosition().get(0)][boite.getPosition().get(1)] = boite;
        }
        stateChanged();
    }

    public String askIfWantToSave(){
        Object[] possibilities = {"Oui","Non"};
        switch(JOptionPane.showOptionDialog(mainFrame,"Voulez-vous sauvegarder ?","Savegarder",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,possibilities,possibilities[0])){
            case -1:
                return "cancel";
            case 0:
                enregistrer();
                return"";
            case 1:
                return"";
        }
        return"";
    }


    public void plusCourtChemin() {

        try {
            if(maze == null){
                JOptionPane.showMessageDialog(mainFrame, "Il n'a pas de labyrinthe !");

            } else if (maze.getArrivalBox() == null) {
                JOptionPane.showMessageDialog(mainFrame, "Il manque l'arrivée !");
            } else if (maze.getDepartureBox() == null) {
                JOptionPane.showMessageDialog(mainFrame, "Il manque le départ !");
            } else {
                Dijkstra dijkstra = new Dijkstra();
                ArrayList<VertexInterface> listeVertexPlusCourtChemin = dijkstra.dijkstra(maze, maze.getDepartureBox(), maze.getArrivalBox());
                setShortestPathList(listeVertexPlusCourtChemin);

                if(listeVertexPlusCourtChemin.size() == 0){JOptionPane.showMessageDialog(mainFrame,"Le départ et l'arrviée sont adjacents !");}
                for (VertexInterface boxPlusCourtChemin : listeVertexPlusCourtChemin) {
                    int x = boxPlusCourtChemin.getPosition().get(0);
                    int y = boxPlusCourtChemin.getPosition().get(1);
                    maze.getLabyrinthe()[x][y] = new PathBox(x,y);
                }
                stateChanged();
                isShortestPathOnScreen = true;
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(mainFrame, "Il n'y a pas de chemin entre le départ et l'arrivée !");

        }

    }


    public void open(){

        if(graphModified){
            if(askIfWantToSave().equals("cancel")){
                return; //si retourne cancel on abandonne l'action d'ouvrir un maze
            }
        }
        boolean fichierCorrect = false;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Labyrinthe (.txt)","txt");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("src/Sauvegardes"));

        while(!fichierCorrect){
            try {
                if(chooser.showOpenDialog(mainFrame) != JFileChooser.APPROVE_OPTION){
                    return;
                }
                File file = chooser.getSelectedFile();

                setFichierOuvert(file);
                ArrayList<String> labyrinthBluePrints = new ArrayList<>();
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    labyrinthBluePrints.add(scanner.nextLine());
                }
                scanner.close();

                labyrinthBluePrints.add(chooser.getSelectedFile().getName());
                setMaze(labyrinthBluePrints);
                fichierCorrect = true;

                }catch(Exception e){
                    JOptionPane.showMessageDialog(mainFrame,"Le fichier n'est pas valide ! " + e.getMessage());

                }

            }
        mazeHasName = true;
        graphModified = false;
        isShortestPathOnScreen = false;
        listeDesActions = new ArrayList<>();

        stateChanged();
    }
}
