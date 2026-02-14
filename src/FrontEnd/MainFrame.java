package FrontEnd;

/**
 * This class represents the main frame of the Labyrinthe application.
 * It extends JFrame and implements ChangeListener.
 * The class contains the window panel, model and menu bar for the application.
 */
import BackEnd.KeyBoardController;
import BackEnd.Model;
import FrontEnd.MenuBar.MenuBar;
import FrontEnd.WindowPanels.WindowPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame implements ChangeListener {

    private final WindowPanel windowPanel;
    private Model model = new Model(this);

    /**
     * Constructor for the MainFrame class.
     * Initializes the window panel, model, and menu bar.
     * Sets the default close operation for the frame and adds a window listener to quit the model when closing.
     * Adds a key listener for the keyboard controller.
     * Sets the minimum size of the frame and packs it.
     * Sets the frame to extended state MAXIMIZED_BOTH.
     * Sets the frame visible and initializes the window panel and model.
     */
    public MainFrame(){
        super("Labyrinthe");
        setContentPane(windowPanel = new WindowPanel(this));
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyBoardController(this));
        setJMenuBar(new MenuBar(this));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                model.quit();

            }
        });
        model.addObserver(this);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setMinimumSize(new Dimension((int) screensize.getWidth()/3,(int) (3*screensize.getHeight()/4)));

        pack();


        setExtendedState(JFrame.MAXIMIZED_BOTH);


        setVisible(true);
        windowPanel.initAfterAllIsInit();
        model.initAfterAllIsInit();


    }

    /**
     * Returns the model for the application.
     * @return The model for the application.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Overrides the stateChanged method from ChangeListener.
     * Sets the title of the frame to include the name and size of the maze if it exists.
     * Notifies the window panel for update.
     * @param e The ChangeEvent.
     */
    @Override
    public void stateChanged(ChangeEvent e) {

        if(model.getMaze().getName() != null){
            setTitle("Labyrinthe  -  "+ model.getMaze().getName().replace(".txt","") +" "+ model.getMaze().getTaille());
        }else{setTitle("Labyrinthe");}

        windowPanel.notifyForUpdate();


    }
}
