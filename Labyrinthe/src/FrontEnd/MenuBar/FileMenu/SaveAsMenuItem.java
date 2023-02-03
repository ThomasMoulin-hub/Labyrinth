package FrontEnd.MenuBar.FileMenu;

import FrontEnd.MainFrame;

import javax.swing.*;

public class SaveAsMenuItem extends JMenuItem {
    private final MainFrame mainFrame;

    public SaveAsMenuItem(MainFrame mainFrame){
        super("Enregistrer sous");

        this.mainFrame = mainFrame;
    }
}
