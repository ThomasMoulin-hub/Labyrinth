package FrontEnd.MenuBar;

import FrontEnd.MainFrame;
import FrontEnd.MenuBar.FileMenu.FileMenu;
import FrontEnd.MenuBar.EditMenu.EditMenu;
import FrontEnd.MenuBar.HelpMenu.HelpMenu;
import FrontEnd.MenuBar.ViewMenu.ViewMenu;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    //declare menus of the menu bar
    private final FileMenu fileMenu;
    private final EditMenu editMenu;
    private final ViewMenu viewMenu;
    private final HelpMenu helpMenu;

    public MenuBar(MainFrame mainFrame){
        super();
        //add menus to the bar
        add(fileMenu = new FileMenu(mainFrame));
        add(editMenu = new EditMenu(mainFrame));
        add(viewMenu = new ViewMenu(mainFrame));
        add(helpMenu = new HelpMenu(mainFrame));
    }
}
