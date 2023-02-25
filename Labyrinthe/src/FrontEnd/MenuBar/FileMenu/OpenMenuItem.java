package FrontEnd.MenuBar.FileMenu;

import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OpenMenuItem extends JMenuItem {
    private final MainFrame mainFrame;

    public OpenMenuItem(MainFrame mainFrame){
        super();
        this.mainFrame = mainFrame;
        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {mainFrame.getModel().open();}
        });
        setText("Ouvrir");
    }


}
