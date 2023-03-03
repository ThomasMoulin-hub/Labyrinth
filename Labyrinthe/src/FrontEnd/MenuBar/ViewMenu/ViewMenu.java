package FrontEnd.MenuBar.ViewMenu;

/**
 * The ViewMenu class represents the "Affichage" menu in the menu bar of a MainFrame.
 */
import FrontEnd.MainFrame;

import javax.swing.*;

public class ViewMenu extends JMenu {

    /**
     * Constructs a new ViewMenu with the given MainFrame.
     *
     * @param mainFrame the MainFrame to associate with this ViewMenu
     */
    public ViewMenu(MainFrame mainFrame){
        super("Affichage");
        add(new DefaultZoomMenuItem(mainFrame));
    }
}
