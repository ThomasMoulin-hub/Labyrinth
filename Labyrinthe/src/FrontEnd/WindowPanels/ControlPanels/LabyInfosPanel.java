package FrontEnd.WindowPanels.ControlPanels;

import BackEnd.Maze;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LabyInfosPanel extends JPanel {
    private MainFrame mainFrame;
    private JLabel nameLabel;
    private JLabel sizeLabel;
    private JLabel departureLabel;
    private JLabel arrivalLabel;

    public LabyInfosPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        Font font = new Font("Serif",Font.PLAIN,24);
        setLayout(new GridLayout(2,2));
        nameLabel = new JLabel("Nom : ");
        nameLabel.setFont(font);
        sizeLabel = new JLabel("Taille : ");
        sizeLabel.setFont(font);
        departureLabel = new JLabel("Départ : (X,Y)");
        departureLabel.setFont(font);
        arrivalLabel = new JLabel("Arrivée : (X,Y)");
        arrivalLabel.setFont(font);
        add(nameLabel);
        add(departureLabel);
        add(sizeLabel);
        add(arrivalLabel);
    }
    public void notifyForUpdate(){
        Maze maze = mainFrame.getModel().getMaze();
        if(maze.getName() != null){

            nameLabel.setText("Nom : "+ maze.getName());
        }else{nameLabel.setText("Nom :");}

        sizeLabel.setText("Taille : " + maze.getTaille());

        if(maze.getArrivalBox() != null){
            arrivalLabel.setText("Arrivée : ("+maze.getArrivalBox().getPosition().get(0)+","+maze.getArrivalBox().getPosition().get(1)+")");
        }else{arrivalLabel.setText("Arrivée : (X,Y)");}

        if(maze.getDepartureBox() != null){
            departureLabel.setText("Départ : ("+maze.getDepartureBox().getPosition().get(0)+","+maze.getDepartureBox().getPosition().get(1)+")");
        }else{departureLabel.setText("Départ : (X,Y)");}
        repaint();
    }


}

