package FrontEnd.MenuBar.FileMenu;

import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveAsMenuItem extends JMenuItem {
    private final MainFrame mainFrame;

    public SaveAsMenuItem(MainFrame mainFrame){
        super("Enregistrer sous");

        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {mainFrame.getModel().enregistrerSous();}
        });
        this.mainFrame = mainFrame;
        setText("Enregistrer Sous");
    }
}
