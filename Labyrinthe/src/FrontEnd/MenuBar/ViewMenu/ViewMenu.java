package FrontEnd.MenuBar.ViewMenu;

import FrontEnd.MainFrame;

import javax.swing.*;

public class ViewMenu extends JMenu {
    //declare items of the view menu

    public ViewMenu(MainFrame mainFrame){
        super("Affichage");
        add(new DefaultZoomMenuItem(mainFrame));
        //add items in the view menu
    }
}
