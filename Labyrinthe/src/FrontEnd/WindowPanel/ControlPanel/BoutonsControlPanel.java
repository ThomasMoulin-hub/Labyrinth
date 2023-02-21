package FrontEnd.WindowPanel.ControlPanel;

import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoutonsControlPanel extends JPanel {
    private MainFrame mainFrame;
    private JButton boutonPlusCourtChemin;
    private JButton boutonSauvegarder;
    private JButton boutonOuvrir;
    public BoutonsControlPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        Font font = new Font("Serif",Font.PLAIN,24);

        setLayout(new BorderLayout());
        boutonOuvrir = new JButton(new ImageIcon("src.FrontEnd.WindowPanel.ControlPanel.open.png"));

        boutonSauvegarder = new JButton("Sauvegarder");
        boutonSauvegarder.setFont(font);
        boutonPlusCourtChemin = new JButton("Afficher le plus court chemin");
        boutonPlusCourtChemin.setFont(font);

        boutonOuvrir.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getModel().open();
            }
        });
        add(boutonOuvrir, BorderLayout.EAST);
        add(boutonSauvegarder, BorderLayout.WEST);
        add(boutonPlusCourtChemin,BorderLayout.NORTH);


    }
}
