package FrontEnd.WindowPanels.ControlPanels;

/**
 * A JPanel that displays information about the maze, such as the location of the departure and arrival boxes.
 */
import BackEnd.KeyBoardController;
import BackEnd.Maze;
import BackEnd.Model;
import BackEnd.MouseWheelControler;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LabyInfosPanel extends JPanel {

    /**
     * The MainFrame that this panel is associated with.
     */
    private MainFrame mainFrame;

    /**
     * The model of the maze.
     */
    private Model model;

    /**
     * The label that displays the location of the departure box.
     */
    private JLabel departureLabel;

    /**
     * The label that displays the location of the arrival box.
     */
    private JLabel arrivalLabel;

    /**
     * Constructs a new LabyInfosPanel with the specified MainFrame.
     *
     * @param mainFrame The MainFrame that this panel is associated with.
     */
    public LabyInfosPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.model = mainFrame.getModel();
        Font font = new Font("Serif",Font.PLAIN,24);
        setLayout(new GridLayout(1,2));
        departureLabel = new JLabel("Départ : (X,Y)  ");
        departureLabel.setFont(font);
        arrivalLabel = new JLabel("Arrivée : (X,Y)  ");
        arrivalLabel.setFont(font);
        add(departureLabel);
        add(arrivalLabel);
        setFocusable(true);
        requestFocusInWindow();

    }

    /**
     * Notifies this panel that the model has been updated and the display should be updated.
     */
    public void notifyForUpdate(){
        Maze maze = model.getMaze();

        if(maze.getArrivalBox() != null){
            arrivalLabel.setText("Arrivée : ("+maze.getArrivalBox().getPosition().get(0)+","+maze.getArrivalBox().getPosition().get(1)+")  ");
        }else{arrivalLabel.setText("Arrivée : (X,Y)  ");}

        if(maze.getDepartureBox() != null){
            departureLabel.setText("Départ : ("+maze.getDepartureBox().getPosition().get(0)+","+maze.getDepartureBox().getPosition().get(1)+")  ");
        }else{departureLabel.setText("Départ : (X,Y)  ");}
        repaint();
    }

    /**
     * Initializes this panel after all components have been initialized.
     */
    public void initAfterAllIsInit(){
        addKeyListener(new KeyBoardController(mainFrame));
        addMouseWheelListener(new MouseWheelControler(mainFrame));
    }

}

