package FrontEnd.WindowPanel;

import FrontEnd.MainFrame;
import javax.swing.*;


public class MazeViewPanel extends JPanel {
    private MainFrame mainFrame;

    public MazeViewPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        add(new Hexagon());
    }

}