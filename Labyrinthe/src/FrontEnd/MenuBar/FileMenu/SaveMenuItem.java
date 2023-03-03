package FrontEnd.MenuBar.FileMenu;

import FrontEnd.MainFrame;

/**
 * The SaveMenuItem class extends the JMenuItem class and represents a menu item
 * that allows the user to save the current file in the application.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveMenuItem extends JMenuItem {
    private final MainFrame mainFrame;

    /**
     * Constructor for the SaveMenuItem class.
     * @param mainFrame the MainFrame instance of the application
     */
    public SaveMenuItem(MainFrame mainFrame){
        super("Enregistrer");
        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {mainFrame.getModel().enregistrer();}
        });
        this.mainFrame = mainFrame;
        setText("Enregistrer");
    }

}
