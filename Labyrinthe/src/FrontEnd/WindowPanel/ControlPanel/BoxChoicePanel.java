package FrontEnd.WindowPanel.ControlPanel;

import javax.swing.*;
import java.awt.*;

public class BoxChoicePanel extends JPanel {
    public BoxChoicePanel(){
        setLayout(new GridLayout(4,2));
        Font font = new Font("Serif",Font.PLAIN,24);
        JButton boutonGris = new JButton();
        JButton boutonBleu = new JButton();
        JButton boutonRouge = new JButton();
        JButton boutonVert = new JButton();
        JLabel labelGris = new JLabel("Empty Box");
        labelGris.setFont(font);
        JLabel labelBleu = new JLabel("Wall Box");
        labelBleu.setFont(font);
        JLabel labelVert = new JLabel("Departure Box");
        labelVert.setFont(font);
        JLabel labelRouge = new JLabel("Arrival Box");
        labelRouge.setFont(font);

        boutonGris.setPreferredSize(new Dimension(30,30));
        boutonBleu.setPreferredSize(new Dimension(30,30));
        boutonRouge.setPreferredSize(new Dimension(30,30));
        boutonVert.setPreferredSize(new Dimension(30,30));


        boutonBleu.setBackground(Color.BLUE);
        boutonGris.setBackground(Color.GRAY);
        boutonRouge.setBackground(Color.RED);
        boutonVert.setBackground(Color.GREEN);

        add(boutonGris);
        add(labelGris);
        add(boutonBleu);
        add(labelBleu);
        add(boutonVert);
        add(labelVert);
        add(boutonRouge);
        add(labelRouge);
    }
}
