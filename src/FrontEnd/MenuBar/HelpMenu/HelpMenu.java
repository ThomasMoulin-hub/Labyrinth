package FrontEnd.MenuBar.HelpMenu;

/**
 * The HelpMenu class represents a menu that contains help options in the main menu bar.
 * It extends the JMenu class from the javax.swing package.
 */
import FrontEnd.MainFrame;

import javax.swing.*;

public class HelpMenu extends JMenu {
    private MainFrame mainFrame;

    /**
     * Constructs a HelpMenu object with a given MainFrame object.
     *
     * @param mainFrame The MainFrame object that contains the menu bar.
     */
    public HelpMenu(MainFrame mainFrame){
        super("Aide");
        add(new HelpMenuItem(mainFrame));
    }
}
