package FrontEnd.MenuBar.FileMenu;

/**
 * This class represents a JMenuItem that triggers the creation of a new maze when clicked on.
 */
import FrontEnd.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewMenuItem extends JMenuItem {

    /**
     * MainFrame instance to access the model and create the new maze.
     */


    /**
     * Constructor for the NewMenuItem class.
     * @param mainFrame MainFrame instance to access the model and create the new maze.
     */
    public NewMenuItem(MainFrame mainFrame){
        super();

        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {mainFrame.getModel().newMaze();}
        });
        setText("Nouveau labyrinthe");
    }
}
