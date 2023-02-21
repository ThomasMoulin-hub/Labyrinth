package FrontEnd.WindowPanel;

import FrontEnd.MainFrame;
import FrontEnd.WindowPanel.ControlPanel.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class WindowPanel extends JPanel{
    private MainFrame mainFrame;
    private MazeViewPanel mazeViewPanel;
    private ControlPanel controlPanel;


    public WindowPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        controlPanel = new ControlPanel(mainFrame);
        mazeViewPanel = new MazeViewPanel(mainFrame);

        setLayout(new BorderLayout());
        add(controlPanel,BorderLayout.WEST);
        add(mazeViewPanel,BorderLayout.CENTER);

    }
    public void notifyForUpdate(){
        controlPanel.notifyForUpdate();
        mazeViewPanel.notifyForUpdate();
    }

}