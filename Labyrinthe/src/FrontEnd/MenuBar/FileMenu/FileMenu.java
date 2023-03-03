package FrontEnd.MenuBar.FileMenu;

/**
 * The FileMenu class represents the "File" menu in the menu bar of the application's main frame.
 * It contains menu items related to file operations such as opening, saving, and quitting the application.
 */
import FrontEnd.MainFrame;
import javax.swing.*;

public class FileMenu extends JMenu {
    private final QuitMenuItem quitMenuItem;
    private final OpenMenuItem openMenuItem;
    private final SaveMenuItem saveMenuItem;
    private final SaveAsMenuItem saveAsMenuItem;

    private final NewMenuItem newMenuItem;

    public FileMenu(MainFrame mainFrame){

        /**
         * Constructs a new FileMenu object with the specified mainFrame.
         * @param mainFrame the main frame of the application.
         */
        super("Fichier");
        add(newMenuItem = new NewMenuItem(mainFrame));
        add(openMenuItem = new OpenMenuItem(mainFrame));
        add(saveMenuItem = new SaveMenuItem(mainFrame));
        add(saveAsMenuItem = new SaveAsMenuItem(mainFrame));
        add(quitMenuItem = new QuitMenuItem(mainFrame));
        openMenuItem.setName("Ouvrir");

    }
}
