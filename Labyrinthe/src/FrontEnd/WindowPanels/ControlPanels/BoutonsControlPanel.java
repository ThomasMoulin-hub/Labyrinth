package FrontEnd.WindowPanels.ControlPanels;

import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoutonsControlPanel extends JPanel {
    private MainFrame mainFrame;
    private JButton boutonPlusCourtChemin;
    private JButton boutonSauvegarder;
    private JButton boutonOuvrir;

    public BoutonsControlPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        Font font = new Font("Serif", Font.PLAIN, 24);

        setLayout(new BorderLayout());
        ImageIcon image = new ImageIcon("téléchargement.jpeg");

        boutonOuvrir = new JButton(image);


        boutonSauvegarder = new JButton();
        boutonSauvegarder.setFont(font);
        boutonPlusCourtChemin = new JButton();
        boutonPlusCourtChemin.setFont(font);

        boutonOuvrir.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getModel().open();
            }
        });
        boutonSauvegarder.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getModel().save();
            }
        });
        boutonPlusCourtChemin.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getModel().plusCourtChemin();
            }
        });
        boutonSauvegarder.setText("Sauvegarder");
        boutonPlusCourtChemin.setText("Affichier le plus court chemin");
        add(boutonOuvrir, BorderLayout.EAST);
        add(boutonSauvegarder, BorderLayout.WEST);
        add(boutonPlusCourtChemin, BorderLayout.NORTH);


    }
}
