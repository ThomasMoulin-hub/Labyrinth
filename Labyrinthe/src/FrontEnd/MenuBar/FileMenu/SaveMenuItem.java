package FrontEnd.MenuBar.FileMenu;

import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveMenuItem extends JMenuItem {
    private final MainFrame mainFrame;

    public SaveMenuItem(MainFrame mainFrame){
        super("Enregistrer");
        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {mainFrame.getModel().save();}
        });
        this.mainFrame = mainFrame;
        setText("Enregistrer");
    }

}
