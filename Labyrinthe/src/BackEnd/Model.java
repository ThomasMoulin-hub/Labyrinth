package BackEnd;

/**

 This class represents the model in the MVC architecture of the Maze solving application.
 It contains all the methods and attributes related to the model such as the maze,
 the selected box type, the selected color and more.
 */
import BackEnd.MazeBoxes.*;
import FrontEnd.MainFrame;
import FrontEnd.WindowPanels.Hexagons.Hexagon;
import FrontEnd.WindowPanels.ScrollViewPanel;

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

    /**
     * This attribute is used to know if the graph has been modified since the last save.
     */
    private boolean graphModified = false;

    /**
     * The MainFrame of the application.
     */
    private final MainFrame mainFrame;

    /**
     * The scroll view panel of the application.
     */
    private ScrollViewPanel scrollViewPanel;

    /**
     * The maze that is currently being edited.
     */
    private Maze maze;

    /**
     * The list of listeners that are listening to the model.
     */
    private final List<ChangeListener> listeners = new ArrayList<ChangeListener>();

    /**
     * The selected box type.
     */
    private char boxTypeSelected;

    /**
     * The selected color.
     */
    private Color colorSelected;

    /**
     * The file that is currently opened.
     */
    private File fichierOuvert;

    /**
     * A boolean that is true if the shortest path is currently on screen.
     */
    private boolean isShortestPathOnScreen = false;

    /**
     * A list of vertices that represents the shortest path.
     */
    private ArrayList<VertexInterface> shortestPathList;

    /**
     * A boolean indicating wheter the maze has a name or not.
     */
    private boolean mazeHasName = true;

    /**
     * A boolean indicating wheter the control key is currently pressed or not.
     */
    private boolean isControlDown = false;

    /**
     * A boolean indicating wheter the shift key is currently pressed or not.
     */
    private boolean isShiftDown = false;

    /**
     * A list of MazeBox that represents the actions that have been done.
     */
    private ArrayList<MazeBox> listeDesActions = new ArrayList<>();

    /**
     * Constructor for the Model class.
     * @param mainFrame The MainFrame object which is the parent object of this model object.
     */
    public Model(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    /**
     * This method is used to define the scroll view panel of the application after all interface components have been created.
     */
    public void initAfterAllIsInit(){
        this.scrollViewPanel = (ScrollViewPanel) mainFrame.getContentPane().getComponents()[0];
    }
    /**
     * Adds a ChangeListener to the list of listeners.
     * @param listener The ChangeListener to be added.
     */
    public void addObserver(ChangeListener listener) {
        listeners.add(listener);}
    /**
     * Sets the box type and color that are currently selected.
     * @param type The box type that is currently selected.
     * @param couleur The color that is currently selected.
     */
    public void setBoxTypeSelected(char type, Color couleur){
        this.boxTypeSelected = type;
        this.colorSelected = couleur;
    }
    /**
     * Sets whether the Control key is pressed down or not.
     * @param valueCtrl true if the Control key is pressed down, false otherwise
     */
    public void setIsControlDown(boolean valueCtrl){this.isControlDown = valueCtrl;}
    /**
     * Sets whether the Shift key is pressed down or not.
     * @param valueShift true if the Shift key is pressed down, false otherwise
     */
    public void setIsShiftDown(boolean valueShift){this.isShiftDown = valueShift;}

    /**
     * returns the color selected
     * @return the color selected
     */
    public Color getColorSelected(){return this.colorSelected;}

    /**
     * returns whether the Control key is pressed down or not.
     * @return true if the Control key is pressed down, false otherwise
     */
    public boolean getIsControlDown(){return isControlDown;}
    /**
     * returns whether the Shift key is pressed down or not.
     * @return true if the Shift key is pressed down, false otherwise
     */
    public boolean getIsShiftDown(){return isShiftDown;}

    /**
     * Sets the name of the maze.
     * @param name the name of the maze.
     */
    public void setMazeName(String name){

        graphModified = true;
        mazeHasName = true;
        maze.setName(name);
    }

    /**
     * Sets the opened file.
     * @param fichierOuvert the opened file.
     */
    public void setFichierOuvert(File fichierOuvert) {
        this.fichierOuvert = fichierOuvert;
    }
    /**
     * Sets the maze based on the given blue prints.
     * @param labyrintheBluePrints the blue prints of the maze.
     * @throws Exception if the blue prints are invalid.
     */
    public void setMaze(ArrayList<String> labyrintheBluePrints) throws Exception {this.maze = new Maze(labyrintheBluePrints);}

    /**
     * Returns the maze.
     * @return the maze.
     */
    public Maze getMaze(){return maze;}

    /**
     * Sets the shortest path list.
     * @param list the shortest path list.
     */
    public void setShortestPathList(ArrayList<VertexInterface> list){this.shortestPathList = list;}


    /**
     * Notifies the listeners that the model has changed.
     */
    public void stateChanged() {
        ChangeEvent evt = new ChangeEvent(this) ;

        for (ChangeListener listener : listeners) {
            listener.stateChanged(evt);
        }
    }

    /**
     * Quits the application.
     */
    public void quit(){

        if(graphModified){
            if(askIfWantToSave()=="cancel"){
            return;
            }
        }
        mainFrame.dispose();
    }

    /**
     * Creates a new maze with the dimensions entrered by the user.
     * If the current maze has been modified, the user is asked if he wants to save it.
     */
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

    /**
     * Sets a new box of the given porisition and updates the model.
     * If the shortest path is currently displayed, it is removed.
     * @param x The vertical position of the box.
     * @param y The horizontal position of the box.
     */
    public void setBox(int x, int y){
        if(isShortestPathOnScreen){ //If the shortest path is currently displayed, we remove it
            for(VertexInterface pathBox : shortestPathList){
                int xP = pathBox.getPosition().get(0);
                int yP = pathBox.getPosition().get(1);
                maze.getLabyrinthe()[xP][yP] = new EmptyBox(xP,yP);
            }
            isShortestPathOnScreen = false;
        }
        if(listeDesActions.size() == 0){
            listeDesActions.add(maze.getLabyrinthe()[x][y]);
        }else if(!listeDesActions.get(listeDesActions.size()-1).getProperties().equals(maze.getLabyrinthe()[x][y].getProperties())){
            listeDesActions.add(maze.getLabyrinthe()[x][y]);
        }

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
                if(maze.getDepartureBox() != null){ //If there is already a departure box, we remove it
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
                if(maze.getArrivalBox() != null){ //If there is already an arrival box, we remove it
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
        maze.checkIfStillArrivalOrDeparture(); //Checks if the departure and arrival boxes are still in the maze, sometimes they can be removed by the user by setting an emptybox or a wallbox on top of them.
        stateChanged();
    }

    /**
     * Opens a JFileChooser to prompt the user to choose a file name for saving the maze
     * The method sets a default directory and a filter to only show .txt files.
     * If the user chooses a file name and clicks on "Save", the method returns the absolute path of the file.
     * If hte user clicks on "Cancel", the method returns "cancel".
     * @return The absolute path of the file or "cancel" if the user clicked on "Cancel".
     */
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

    /**
     * Saves the maze to a file.
     * If the maze has no name, the user is prompted to choose a name.
     * If the user cancels the action, the method returns without saving the maze.
     * if the maze has a name, the method saves the maze to the file with the name of the maze.
     */
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

    /**
     * Prompts the user to choose a name for the maze.
     * If the user cancels the action, the method returns without saving the maze.
     * If the user selects a file name, the method saves the maze to the file, sets the maze name to the file name, and updates the GUI to reflect the change.
     */
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

    /**
     * Saves the maze to the given file.
     * @param file the file to save the maze to.
     * @throws Exception if an error occurs while saving the maze.
     */
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

    /**
     * Reverts the last action done by the user, if there are any actions to revert.
     */
    public void retablir(){
        if(listeDesActions.size() > 0){
            MazeBox  boite= listeDesActions.remove(listeDesActions.size()-1);
            maze.getLabyrinthe()[boite.getPosition().get(0)][boite.getPosition().get(1)] = boite;
        }
        stateChanged();
    }

    /**
     * Increases the size of the hexagons in the maze by a factor of 1.1.
     */
    public void zoom(){
        Hexagon.setR(Hexagon.getR() * (1.1));
        stateChanged();
    }

    /**
     * Decreases the size of the hexagons in the maze by a factor of 0.9.
     */
    public void deZoom(){
        Hexagon.setR(Hexagon.getR() * (0.9));
        stateChanged();
    }

    /**
     * Sets the default zoom level by gradually decreasing the size of the hexagons until the scroll bars are no longer visible.
     * If there is no maze, the method returns without doing anything.
     */
    public void setDefaulZoom(){

        if(maze == null){return;}
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            /**
             * Decreases the size of the hexagons until the scroll bars are no longer visible and the hexagon size is larger than 1.
             * @return null
             * @throws Exception if an error occurs while decreasing the size of the hexagons.
             */
            @Override
            protected Void doInBackground() throws Exception {
                while(scrollViewPanel.areScrollBarsOnScreen() && Hexagon.getR() >1){
                    deZoom();
                    Thread.sleep(100);
                }
                return null;
            }
        };
        worker.execute();
    }

    /**
     * Asks the user if he wants to save the maze.
     * @return a string representing the user's choice, can be "cancel" if the user clicks on "Cancel".
     */
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

    /**
     * Calculates the shortest path between the departure and the arrival using Dijkstra's algorithm and displays it.
     * If there is no maze, the method displays a message.
     * If there is no arrival, the method displays a message.
     * If there is no departure, the method displays a message.
     * If the departure and the arrival are adjacent, the method displays a message.
     */
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

    /**
     * Opens a file chooser dialog to allow the user to choose a maze to open.
     * If the maze has been modified, the user is asked if he wants to save it.
     * If the user clicks on "Cancel", the method returns without doing anything.
     * If the user clicks on "Yes", the method saves the maze and then opens the file chooser dialog.
     * If the user clicks on "No", the method opens the file chooser dialog.
     * If the file is invalid, the method displays a message and opens the file chooser dialog again.
     */
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
