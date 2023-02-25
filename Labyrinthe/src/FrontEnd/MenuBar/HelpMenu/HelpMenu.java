package FrontEnd.MenuBar.HelpMenu;

import FrontEnd.MainFrame;

import javax.swing.*;

public class HelpMenu extends JMenu {
    private MainFrame mainFrame;
    //declare items of the help menu

    public HelpMenu(MainFrame mainFrame){
        super("Aide");
        add(new HelpMenuItem(mainFrame));
    }
}
