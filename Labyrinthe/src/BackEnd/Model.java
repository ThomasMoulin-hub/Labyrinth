package BackEnd;

import BackEnd.MazeBoxes.*;
import FrontEnd.MainFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Model {
    private boolean graphModified = false;

    private final MainFrame mainFrame;
    private Maze maze;
    private final List<ChangeListener> listeners
            = new ArrayList<ChangeListener>();
    private char boxTypeSelected;
    private Color colorSelected;
    private File fichierOuvert; //TODO pour garder le nom du fichier quand on change le maze ou qu'on change le nom du fichier pour pouvoir renomer quand on change de nom sur un meme maze
    private boolean isShortestPathOnScreen = false;
    private ArrayList<VertexInterface> shortestPathList;
    private boolean mazeHasName = true;





    public Model(MainFrame mainFrame){
        this.mainFrame = mainFrame;

    }

    public void addObserver(ChangeListener listener) {
        listeners.add(listener);}

    public void setBoxTypeSelected(char type, Color couleur){
        this.boxTypeSelected = type;
        this.colorSelected = couleur;
    }
    public char getBoxTypeSelected(){return this.boxTypeSelected;}
    public Color getColorSelected(){return this.colorSelected;}
    public void setMazeName(String name){
        //TODO coder le changement du nom du labyrinthe
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
        if(graphModified){save();}
        mainFrame.dispose();
    }

    public void newMaze(){
        if(graphModified){
            if(save().equals("cancel")){
                return; //si save retourne cancel on abandonne l'action de créer un nouveau maze
            }

        }
        this.maze = new Maze();
        mazeHasName = false;
        stateChanged();
    }

    public void setBoxType(int x,int y){
        graphModified = true;
        if(isShortestPathOnScreen){
            for(VertexInterface pathBox : shortestPathList){
                int xP = pathBox.getPosition().get(0);
                int yP = pathBox.getPosition().get(1);
                maze.getLabyrinthe()[xP][yP] = new EmptyBox(xP,yP);
            }
        }
        switch(boxTypeSelected){
            case 'E':
                maze.getLabyrinthe()[x][y] = new EmptyBox(x,y);
                break;
            case 'W':
                maze.getLabyrinthe()[x][y] = new WallBox(x,y);
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
                break;
        }
        maze.checkIfStillArrivalOrDeparture();
        stateChanged();
    }

    public String save(){

        Object[] option = {"Oui", "Non"};
        int result = JOptionPane.showOptionDialog(mainFrame, "Voulez-vous sauvegarder ?","N'oubliez-pas de sauvegarder",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,null,option,option[0]);
        switch(result) {
            case 0:
                if (!mazeHasName) {
                    String nom = "";
                    boolean reussi = false;
                    while (nom.length() == 0 | !reussi) {
                        nom = (String) JOptionPane.showInputDialog(mainFrame, "Nom du labyrinthe :", "Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
                        nom += ".txt";
                        try {
                            File newfile = new File("src\\Sauvegardes\\" + nom);
                            reussi = newfile.createNewFile();
                        }catch(IOException e){JOptionPane.showMessageDialog(mainFrame,e.getMessage());}
                    }
                    mazeHasName = true;
                }else{
                    fichierOuvert.renameTo(new File(fichierOuvert.getParent()+"\\"+maze.getName()));
                }
                //TODO écrire le maze dans le fichier
                return "";
            case -1:
                return "cancel";
            default:
                return"";
        }

    }

    public void plusCourtChemin() {
        try {
            if (maze.getArrivalBox() == null) {
                JOptionPane.showMessageDialog(mainFrame, "Il manque l'arrivée !");
            } else if (maze.getDepartureBox() == null) {
                JOptionPane.showMessageDialog(mainFrame, "Il manque le départ !");
            } else {
                Dijkstra dijkstra = new Dijkstra();
                ArrayList<VertexInterface> listeVertexPlusCourtChemin = dijkstra.dijkstra(maze, maze.getDepartureBox(), maze.getArrivalBox());
                setShortestPathList(listeVertexPlusCourtChemin);
                for (VertexInterface boxPlusCourtChemin : listeVertexPlusCourtChemin) {
                    int x = boxPlusCourtChemin.getPosition().get(0);
                    int y = boxPlusCourtChemin.getPosition().get(1);
                    maze.getLabyrinthe()[x][y] = new PathBox(x,y);
                }
            }
            stateChanged();
            isShortestPathOnScreen = true;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(mainFrame, "Il n'y a pas de labyrinthe !");

        }
    }


    public void open(){
        mazeHasName = false;
        if(graphModified){
            if(save().equals("cancel")){
                return; //si save retourne cancel on abandonne l'action d'ouvrir un maze
            }
        }
        boolean fichierCorrect = false;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Labyrinthe (.txt)","txt");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("src/Sauvegardes"));
        chooser.showOpenDialog(mainFrame);
        File file = new File(chooser.getSelectedFile().toString());
        setFichierOuvert(file);
        while(!fichierCorrect){
            try{

                ArrayList<String> labyrinthBluePrints = new ArrayList<>();
                Scanner scanner = new Scanner(file);

                while(scanner.hasNextLine()){
                    labyrinthBluePrints.add(scanner.nextLine());
                }
                scanner.close();

                labyrinthBluePrints.add(chooser.getSelectedFile().getName());
                setMaze(labyrinthBluePrints);
                fichierCorrect = true;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(mainFrame,"Le fichier n'est pas valide ! " + e.getMessage());
                    chooser.showOpenDialog(mainFrame);
                    //TODO tester ce qu'il se passe si on fait cancel dans le choix du fichier
                }

            }
        stateChanged();
    }
}
