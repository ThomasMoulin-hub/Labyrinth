package FrontEnd.MenuBar.EditMenu;

/**
 * The UndoMenuItem class represents a menu item used to undo a previous action.
 * It extends the JMenuItem class and contains a reference to the MainFrame class.
 */
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoMenuItem extends JMenuItem {
    private MainFrame mainFrame;

    /**
     * Constructs an UndoMenuItem object with a reference to the MainFrame object.
     *
     * @param mainFrame a reference to the MainFrame object.
     */
    public UndoMenuItem(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getModel().retablir();
            }
        });
        setText("Annuler");
    }
}
