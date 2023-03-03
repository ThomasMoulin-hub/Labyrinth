package FrontEnd.WindowPanels;

/**
 * A JPanel representing the main window panel of the maze game. It contains a ControlPanel and a ScrollViewPanel.
 * This panel is responsible for displaying the maze and handling user inputs through the KeyBoardController.
 */
import BackEnd.KeyBoardController;
import FrontEnd.MainFrame;
import FrontEnd.WindowPanels.ControlPanels.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class WindowPanel extends JPanel{
    private ControlPanel controlPanel;
    private ScrollViewPanel scrollView;
    private MazeViewPanel mazeViewPanel;

    /**
     * Constructor of the WindowPanel class. It creates a MazeViewPanel, a ScrollViewPanel and a ControlPanel.
     * The layout is set to BorderLayout and the MazeViewPanel is added to the CENTER position and the ControlPanel
     * to the SOUTH position of the panel. The panel is made focusable and the KeyBoardController is added as a key listener.
     * @param mainFrame the parent MainFrame of the window panel
     */
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

    /**
     * Notifies the controlPanel and the scrollView to update their states.
     */
    public void notifyForUpdate(){

        controlPanel.notifyForUpdate();
        scrollView.notifyForUpdate();

    }

    /**
     * Initializes the controlPanel and the scrollView after all the components are initialized.
     */
    public void initAfterAllIsInit(){
        controlPanel.initAfterAllIsInit();
        scrollView.initAfterAllIsInit();
    }

}