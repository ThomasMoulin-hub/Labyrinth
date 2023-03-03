package FrontEnd.MenuBar.FileMenu;

/**
 * Represents the "Open" menu item in the "File" menu of a graphical user interface (GUI) for a maze application.
 * When clicked, it triggers the opening of a maze file.
 */
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OpenMenuItem extends JMenuItem {


    /**
     * Constructs a new "Open" menu item with the given MainFrame as its parent frame.
     * @param mainFrame the MainFrame of the GUI
     */
    public OpenMenuItem(MainFrame mainFrame){
        super();

        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {mainFrame.getModel().open();}
        });
        setText("Ouvrir");
    }


}
