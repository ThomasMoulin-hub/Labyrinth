package FrontEnd.MenuBar.EditMenu;

import FrontEnd.MainFrame;

import javax.swing.*;

public class UndoMenuItem extends JMenuItem {
    private MainFrame mainFrame;

    public UndoMenuItem(MainFrame mainFrame){
        super("Annuler");
        this.mainFrame = mainFrame;
    }
}
