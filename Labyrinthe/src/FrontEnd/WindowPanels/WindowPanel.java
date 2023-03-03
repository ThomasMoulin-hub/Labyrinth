package FrontEnd.WindowPanels;

import BackEnd.KeyBoardController;
import FrontEnd.MainFrame;
import FrontEnd.WindowPanels.ControlPanels.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class WindowPanel extends JPanel{
    private ControlPanel controlPanel;
    private ScrollViewPanel scrollView;
    private MazeViewPanel mazeViewPanel;



    public WindowPanel(MainFrame mainFrame){

        mazeViewPanel = new MazeViewPanel(mainFrame);
        scrollView = new ScrollViewPanel(mazeViewPanel);
        controlPanel = new ControlPanel(mainFrame);


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
    public void initAfterAllIsInit(){
        controlPanel.initAfterAllIsInit();
        scrollView.initAfterAllIsInit();
    }

}