package BackEnd;

import FrontEnd.MainFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Model {
    private boolean graphModified = false;
    private final MainFrame mainFrame;
    private Maze maze;
    private final List<ChangeListener> listeners
            = new ArrayList<ChangeListener>();




    public Model(MainFrame mainFrame){

        this.mainFrame = mainFrame;

    }
    //TODO avant de lancer dijskstra il faut vérifier qu'il y une et une seul case de départ et d'arrivée
    public void addObserver(ChangeListener listener) {
        listeners.add(listener);}

    public void stateChanged() {
        ChangeEvent evt = new ChangeEvent(this) ;

        for (ChangeListener listener : listeners) {
            listener.stateChanged(evt);
        }
    }

    public void quit(){
        if(!graphModified){
            mainFrame.dispose();
        }else{
            saveIfModified();
            mainFrame.dispose();
        }
        stateChanged();
    }

    public void newMaze(){
        if(!graphModified){
            this.maze = new Maze();
        }else {
            saveIfModified();
            this.maze = new Maze();
        }
        stateChanged();
    }

    public Maze getMaze(){return maze;}
    public void setMaze(ArrayList<String> labyrintheBluePrints){this.maze = new Maze(labyrintheBluePrints);}
    public void saveIfModified(){
        //TODO faire une pop up qui fait que le programme attend tant que la réponse n'a pas été donnnée si on veut sauvegarder ou on s'en fiche
        //TODO et qui ecrit ou remplace le fichier txt du labyrinthe

    }
    public void open(){

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Labyrinthe (.txt)","txt");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new File("src/Sauvegardes"));
        chooser.showOpenDialog(mainFrame);
        //TODO lire le fichier choisi et le mettre dans la variable maze du model
        File file = new File(chooser.getSelectedFile().toString());
        try{
            ArrayList<String> labyrinthBluePrints = new ArrayList<>();
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                labyrinthBluePrints.add(scanner.nextLine());
            }
            scanner.close();
            setMaze(labyrinthBluePrints);

            }

        catch(Exception e){e.getStackTrace();//TODO Fait une popup qui dit que c'est pas un bon fichier et faire recommencer}

    }
    stateChanged();
}}
