package FrontEnd.MenuBar.FileMenu;

/**
 * The SaveAsMenuItem class extends the JMenuItem class and provides a menu item for the "File" menu in the MainFrame.
 * It allows the user to save the current file with a new name.
 */
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveAsMenuItem extends JMenuItem {
    private final MainFrame mainFrame;

    /**
     * Constructs a SaveAsMenuItem object with a MainFrame parameter.
     * @param mainFrame The MainFrame object associated with this menu item.
     */
    public SaveAsMenuItem(MainFrame mainFrame){
        super("Enregistrer sous");

        setAction(new AbstractAction() {

            /**
             * Action performed when the "Enregistrer sous" menu item is clicked.
             * Calls the enregistrerSous() method in the associated MainFrame's Model.
             * @param e The ActionEvent object associated with this menu item.
             */
            @Override
            public void actionPerformed(ActionEvent e) {mainFrame.getModel().enregistrerSous();}
        });
        this.mainFrame = mainFrame;
        setText("Enregistrer Sous");
    }
}
