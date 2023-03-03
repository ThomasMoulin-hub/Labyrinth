package FrontEnd.MenuBar.EditMenu;

/**

 * EditMenu is a class that extends JMenu and represents the "Edit" menu in a graphical user interface.
 * This menu contains the "Undo" menu item.
 */
import FrontEnd.MainFrame;
import javax.swing.*;

public class EditMenu extends JMenu {

    private final UndoMenuItem undoMenuItem;

    /**
     * Constructs an EditMenu object with a specified MainFrame object.
     *
     * @param mainFrame The MainFrame object associated with the EditMenu.
     */
    public EditMenu(MainFrame mainFrame){
        super("Édition");

        add(undoMenuItem = new UndoMenuItem(mainFrame));

    }
}
