package FrontEnd.MenuBar.EditMenu;

import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoMenuItem extends JMenuItem {
    private MainFrame mainFrame;

    public UndoMenuItem(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getModel().retablir();
            }
        });
        setText("Annuler");
    }
}
