package FrontEnd.MenuBar.ViewMenu;

/**
 * This class represents a menu item for setting the default zoom level in the view menu of the application.
 */
import BackEnd.Model;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DefaultZoomMenuItem extends JMenuItem {

    /**
     * The model associated with the main frame of the application.
     */
    private Model model;

    /**
     * Constructs a new DefaultZoomMenuItem object with the specified main frame.
     * @param mainFrame the main frame of the application.
     */
    public DefaultZoomMenuItem(MainFrame mainFrame){
        this.model = mainFrame.getModel();
        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setDefaulZoom();
            }
        });
        setText("Zoom par défaut");
    }
}
