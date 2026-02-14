package FrontEnd.WindowPanels.ControlPanels;

/**
 * This class contains a panel with buttons to select the type of box to draw on the maze.
 */

import BackEnd.KeyBoardController;
import BackEnd.Model;
import BackEnd.MouseWheelControler;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoxTypeChoicePanel extends JPanel {
    private MainFrame mainFrame;
    private Model model;

    /**
     * Creates a new panel with buttons to select the type of box to draw on the maze.
     * @param mainFrame
     */
    public BoxTypeChoicePanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.model = mainFrame.getModel();
        setLayout(new GridLayout(2,4));
        Font font = new Font("Serif",Font.PLAIN,24);
        JButton boutonGris = new JButton();
        JButton boutonBleu = new JButton();
        JButton boutonRouge = new JButton();
        JButton boutonVert = new JButton();
        JLabel labelGris = new JLabel("Route");
        labelGris.setFont(font);
        JLabel labelBleu = new JLabel("Mur");
        labelBleu.setFont(font);
        JLabel labelVert = new JLabel("Départ");
        labelVert.setFont(font);
        JLabel labelRouge = new JLabel("Arrivée");
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
                model.setBoxTypeSelected('W', Color.BLUE);
            }
        });
        boutonGris.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setBoxTypeSelected('E',Color.GRAY);
            }
        });
        boutonRouge.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {model.setBoxTypeSelected('A',Color.RED);
            }
        });
        boutonVert.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setBoxTypeSelected('D',Color.GREEN);
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


        setFocusable(true);
        requestFocusInWindow();


    }

    /**
     * Initializes the control panel after all components have been initialized.
     */
    public void initAfterAllIsInit(){
        for(Component comp : getComponents()){
            comp.addKeyListener(new KeyBoardController(mainFrame));
            comp.addMouseWheelListener(new MouseWheelControler(mainFrame));
        }
    }
}
