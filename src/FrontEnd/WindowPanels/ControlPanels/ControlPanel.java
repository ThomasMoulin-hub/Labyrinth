package FrontEnd.WindowPanels.ControlPanels;

/**
 * ControlPanel class represents the panel containing the control elements of the labyrinth game.
 * It extends JPanel and contains the BoxTypeChoicePanel, BoutonsControlPanel and LabyInfosPanel.
 * It also implements the notifyForUpdate and initAfterAllIsInit methods.
 */
import BackEnd.KeyBoardController;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    /**
     * The BoxTypeChoicePanel instance of the ControlPanel.
     */
    private BoxTypeChoicePanel boxChoicePanel;

    /**
     * The BoutonsControlPanel instance of the ControlPanel.
     */
    private BoutonsControlPanel boutonsControlPanel;

    /**
     * The LabyInfosPanel instance of the ControlPanel.
     */
    private LabyInfosPanel labyInfosPanel;

    /**
     * Constructor of the ControlPanel class.
     * Initializes the MainFrame instance and sets the layout to BorderLayout.
     * Instantiates the BoxTypeChoicePanel, BoutonsControlPanel and LabyInfosPanel.
     * Adds them to the ControlPanel in their respective positions using BorderLayout.
     * Sets the ControlPanel as focusable, requests focus in the window and adds a KeyBoardController as a key listener.
     *
     * @param mainFrame The MainFrame instance.
     */
    public ControlPanel(MainFrame mainFrame){

        setLayout(new BorderLayout());


        boxChoicePanel = new BoxTypeChoicePanel(mainFrame);
        boutonsControlPanel = new BoutonsControlPanel(mainFrame);
        labyInfosPanel = new LabyInfosPanel(mainFrame);
        add(boutonsControlPanel,BorderLayout.EAST);
        add(boxChoicePanel,BorderLayout.CENTER);
        add(labyInfosPanel,BorderLayout.WEST);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyBoardController(mainFrame));
    }

    /**
     * Method to notify the LabyInfosPanel to update.
     * Calls the notifyForUpdate method of the LabyInfosPanel instance.
     */
    public void notifyForUpdate(){
        labyInfosPanel.notifyForUpdate();

    }

    /**
     * Method to initialize all elements after everything is initialized.
     * Calls the initAfterAllIsInit method of the BoxTypeChoicePanel, BoutonsControlPanel and LabyInfosPanel instances.
     */
    public void initAfterAllIsInit(){
        boxChoicePanel.initAfterAllIsInit();
        boutonsControlPanel.initAfterAllIsInit();
        labyInfosPanel.initAfterAllIsInit();
    }
}
