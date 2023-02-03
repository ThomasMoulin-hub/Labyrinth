package FrontEnd.MenuBar.FileMenu;

import FrontEnd.MainFrame;

import javax.swing.*;

public class SaveMenuItem extends JMenuItem {
    private final MainFrame mainFrame;

    public SaveMenuItem(MainFrame mainFrame){
        super("Enregistrer");

        this.mainFrame = mainFrame;
    }

}
