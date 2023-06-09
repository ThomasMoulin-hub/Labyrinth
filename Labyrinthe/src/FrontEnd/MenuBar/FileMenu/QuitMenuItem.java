package FrontEnd.MenuBar.FileMenu;

/**
 * QuitMenuItem is a JMenuItem used to quit the application
 */
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;




public class QuitMenuItem extends JMenuItem {


    /**
     * Constructor for QuitMenuItem
     * @param mainFrame the main frame of the application
     */
     public QuitMenuItem(MainFrame mainFrame){
         super();
         setAction(new AbstractAction() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 mainFrame.getModel().quit();
             }
         });
         setText("Quitter");
     }



}
