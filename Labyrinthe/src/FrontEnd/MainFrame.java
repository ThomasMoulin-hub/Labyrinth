package FrontEnd;

import BackEnd.Model;
import FrontEnd.MenuBar.MenuBar;
import FrontEnd.WindowPanel.WindowPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MainFrame extends JFrame implements ChangeListener {

    private final WindowPanel windowPanel;
    private Model model = new Model(this);
    private final MenuBar menuBar;

    public MainFrame(){
        super("Labyrinthe");
        setJMenuBar(menuBar = new MenuBar(this));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model.addObserver(this);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setMinimumSize(new Dimension((int) screensize.getWidth()/3,(int) (3*screensize.getHeight()/4)));
        setContentPane(windowPanel = new WindowPanel(this));
        pack();


        setExtendedState(JFrame.MAXIMIZED_BOTH);


        setVisible(true);

    }

    public Model getModel() {
        return model;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        windowPanel.notifyForUpdate();
    }
}
