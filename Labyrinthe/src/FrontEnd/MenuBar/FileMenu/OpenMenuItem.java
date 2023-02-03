package FrontEnd.MenuBar.FileMenu;

import FrontEnd.MainFrame;

import javax.swing.*;

public class OpenMenuItem extends JMenuItem {
    private final MainFrame mainFrame;

    public OpenMenuItem(MainFrame mainFrame){
        super("Ouvrir");

        this.mainFrame = mainFrame;
    }
}
