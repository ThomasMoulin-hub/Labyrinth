package FrontEnd.WindowPanels.ControlPanels;

/**
 * This class represents a panel containing a button to trigger the display of the shortest path on the maze.
 * The panel is added to the main frame and listens for key and mouse wheel events to control the maze display.
 */
import BackEnd.KeyBoardController;
import BackEnd.MouseWheelControler;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoutonsControlPanel extends JPanel {
    private MainFrame mainFrame;
    private JButton boutonPlusCourtChemin;

    /**
     * Creates a new control panel containing a button to display the shortest path.
     * @param mainFrame the main frame of the application
     */
    public BoutonsControlPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        Font font = new Font("Serif", Font.PLAIN, 24);

        setLayout(new BorderLayout());

        boutonPlusCourtChemin = new JButton();
        boutonPlusCourtChemin.setFont(font);

        boutonPlusCourtChemin.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getModel().plusCourtChemin();
            }
        });

        boutonPlusCourtChemin.setText("Afficher le plus court chemin");


        add(boutonPlusCourtChemin, BorderLayout.CENTER);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyBoardController(mainFrame));


    }

    /**
     * Initializes the control panel after all components have been initialized.
     */
    public void initAfterAllIsInit(){
        boutonPlusCourtChemin.addMouseWheelListener(new MouseWheelControler(mainFrame));
        boutonPlusCourtChemin.addKeyListener(new KeyBoardController(mainFrame));
    }
}
