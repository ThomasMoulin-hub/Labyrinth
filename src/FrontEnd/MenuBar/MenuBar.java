package FrontEnd.MenuBar;

/**
 * This class represents the menu bar that contains several menus for the main frame.
 * It contains the following menus: FileMenu, EditMenu, ViewMenu, and HelpMenu.
 */
import FrontEnd.MainFrame;
import FrontEnd.MenuBar.FileMenu.FileMenu;
import FrontEnd.MenuBar.EditMenu.EditMenu;
import FrontEnd.MenuBar.HelpMenu.HelpMenu;
import FrontEnd.MenuBar.ViewMenu.ViewMenu;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    private final FileMenu fileMenu;
    private final EditMenu editMenu;
    private final ViewMenu viewMenu;
    private final HelpMenu helpMenu;

    /**
     * Constructs a new MenuBar object with the specified mainFrame.
     * It initializes and adds the FileMenu, EditMenu, ViewMenu, and HelpMenu to the bar.
     *
     * @param mainFrame the main frame of the application
     */
    public MenuBar(MainFrame mainFrame){
        super();
        add(fileMenu = new FileMenu(mainFrame));
        add(editMenu = new EditMenu(mainFrame));
        add(viewMenu = new ViewMenu(mainFrame));
        add(helpMenu = new HelpMenu(mainFrame));
    }
}
