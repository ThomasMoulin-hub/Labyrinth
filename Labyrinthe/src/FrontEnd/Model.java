package FrontEnd;

import BackEnd.Maze;

import javax.swing.event.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private boolean graphModified = false;
    private final MainFrame mainFrame;
    private Maze maze;
    private final List<ChangeListener> listeners
            = new ArrayList<ChangeListener>() ;




    public Model(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void addObserver(ChangeListener listener) {
        listeners.add(listener);}

    public void stateChanged() {
        ChangeEvent evt = new ChangeEvent(this) ;

        for (ChangeListener listener : listeners) {
            listener.stateChanged(evt);
        }
    }

    public void doIfNothingModified(String str){
        if(!graphModified){
            switch(str){
                case "quitApp":
                    mainFrame.dispose();
                case "setNewMaze":
                    this.maze = new Maze();

            }

        }
        else{saveIfModified();
            switch(str){
                case "quitApp":
                    mainFrame.dispose();
                case "setNewMaze":
                    this.maze = new Maze();}
    }stateChanged();
    }


    public void saveIfModified(){
        //TODO faire une pop up qui fait que le programme attend tant que la réponse n'a pas été donnnée si on veut sauvegarder ou on s'en fiche

    }
}
