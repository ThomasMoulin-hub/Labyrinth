package FrontEnd.WindowPanels.ControlPanels;

import BackEnd.KeyBoardController;
import BackEnd.Maze;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LabyInfosPanel extends JPanel {
    private MainFrame mainFrame;

    private JLabel departureLabel;
    private JLabel arrivalLabel;

    public LabyInfosPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
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
        addKeyListener(new KeyBoardController(mainFrame));
    }
    public void notifyForUpdate(){
        Maze maze = mainFrame.getModel().getMaze();

        if(maze.getArrivalBox() != null){
            arrivalLabel.setText("Arrivée : ("+maze.getArrivalBox().getPosition().get(0)+","+maze.getArrivalBox().getPosition().get(1)+")  ");
        }else{arrivalLabel.setText("Arrivée : (X,Y)  ");}

        if(maze.getDepartureBox() != null){
            departureLabel.setText("Départ : ("+maze.getDepartureBox().getPosition().get(0)+","+maze.getDepartureBox().getPosition().get(1)+")  ");
        }else{departureLabel.setText("Départ : (X,Y)  ");}
        repaint();
    }


}

