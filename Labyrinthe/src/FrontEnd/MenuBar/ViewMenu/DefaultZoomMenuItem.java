package FrontEnd.MenuBar.ViewMenu;

import BackEnd.Model;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DefaultZoomMenuItem extends JMenuItem {
    private Model model;

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
