package FrontEnd.WindowPanels.ControlPanels;

import BackEnd.KeyBoardController;
import BackEnd.MouseWheelControler;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoxTypeChoicePanel extends JPanel {
    private MainFrame mainFrame;
    public BoxTypeChoicePanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(2,4));
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

        boutonBleu.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getModel().setBoxTypeSelected('W', Color.BLUE);
            }
        });
        boutonGris.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getModel().setBoxTypeSelected('E',Color.GRAY);
            }
        });
        boutonRouge.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {mainFrame.getModel().setBoxTypeSelected('A',Color.RED);
            }
        });
        boutonVert.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getModel().setBoxTypeSelected('D',Color.GREEN);
            }
        });




        add(labelGris);
        add(labelBleu);
        add(labelVert);
        add(labelRouge);
        add(boutonGris);
        add(boutonBleu);
        add(boutonVert);
        add(boutonRouge);

        for(Component comp : getComponents()){
            comp.addKeyListener(new KeyBoardController(mainFrame));
            comp.addMouseWheelListener(new MouseWheelControler(mainFrame));
        }

        setFocusable(true);
        requestFocusInWindow();


    }
}
