package FrontEnd.WindowPanels;

import BackEnd.KeyBoardController;
import FrontEnd.MainFrame;
import FrontEnd.WindowPanels.ControlPanels.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class WindowPanel extends JPanel{
    private MainFrame mainFrame;
    private ControlPanel controlPanel;
    private ScrollViewPanel scrollView;



    public WindowPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        controlPanel = new ControlPanel(mainFrame);

        scrollView = new ScrollViewPanel(mainFrame,new MazeViewPanel(mainFrame));
        setLayout(new BorderLayout());
        add(scrollView,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyBoardController(mainFrame));

    }
    public void notifyForUpdate(){

        controlPanel.notifyForUpdate();
        scrollView.notifyForUpdate();

    }

}