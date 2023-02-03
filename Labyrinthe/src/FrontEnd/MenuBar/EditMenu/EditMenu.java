package FrontEnd.MenuBar.EditMenu;

import FrontEnd.MainFrame;
import javax.swing.*;

public class EditMenu extends JMenu {
    //declare items of the edit menu
    private final UndoMenuItem undoMenuItem;
    public EditMenu(MainFrame mainFrame){
        super("Édition");
        //add menu items in the edit menu
        add(undoMenuItem = new UndoMenuItem(mainFrame));

    }
}
