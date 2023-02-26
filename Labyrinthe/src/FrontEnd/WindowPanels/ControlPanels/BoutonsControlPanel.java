package FrontEnd.WindowPanels.ControlPanels;

import BackEnd.KeyBoardController;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BoutonsControlPanel extends JPanel {
    private MainFrame mainFrame;
    private JButton boutonPlusCourtChemin;

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
}
