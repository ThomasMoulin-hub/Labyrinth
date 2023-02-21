package FrontEnd.MenuBar.FileMenu;

import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;




public class QuitMenuItem extends JMenuItem {
    private final MainFrame mainFrame;
     public QuitMenuItem(MainFrame mainFrame){
         super();
         setAction(new AbstractAction() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 mainFrame.getModel().quit();
             }
         });
         setText("Quitter");
         this.mainFrame = mainFrame;
     }



}
