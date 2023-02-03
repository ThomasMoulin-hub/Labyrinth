package FrontEnd.MenuBar.FileMenu;

import FrontEnd.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewMenuItem extends JMenuItem {
    private final MainFrame mainFrame;

    public NewMenuItem(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {mainFrame.getModel().doIfNothingModified("setNewMaze");}
        });
        setText("Nouveau labyrinthe");
    }
}
