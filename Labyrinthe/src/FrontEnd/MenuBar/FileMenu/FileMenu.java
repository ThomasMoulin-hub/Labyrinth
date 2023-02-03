package FrontEnd.MenuBar.FileMenu;

import FrontEnd.MainFrame;
import javax.swing.*;

public class FileMenu extends JMenu {
    //declare items of the file menu
    private final QuitMenuItem quitMenuItem;
    private final OpenMenuItem openMenuItem;
    private final SaveMenuItem saveMenuItem;
    private final SaveAsMenuItem saveAsMenuItem;
    private final NewMenuItem newMenuItem;

    public FileMenu(MainFrame mainFrame){
        super("Fichier");
        //add menu items to the file menu
        add(newMenuItem = new NewMenuItem(mainFrame));
        add(openMenuItem = new OpenMenuItem(mainFrame));
        add(saveMenuItem = new SaveMenuItem(mainFrame));
        add(saveAsMenuItem = new SaveAsMenuItem(mainFrame));
        add(quitMenuItem = new QuitMenuItem(mainFrame));

    }
}
