package FrontEnd.WindowPanel.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class LabyInfosPanel extends JPanel {
    private JLabel nameLabel;
    private JLabel sizeLabel;
    private JLabel departureLabel;
    private JLabel arrivalLabel;

    public LabyInfosPanel(){
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
}
