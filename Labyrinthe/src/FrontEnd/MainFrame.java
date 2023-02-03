package FrontEnd;

import FrontEnd.MenuBar.MenuBar;
import FrontEnd.WindowPanel.WindowPanel;

import javax.swing.*;

public class MainFrame extends JFrame {

    private final WindowPanel windowPanel;
    private Model model = new Model(this);
    private final MenuBar menuBar;

    public MainFrame(){
        super("Labyrinthe");

        setJMenuBar(menuBar = new MenuBar(this));
        setContentPane(windowPanel = new WindowPanel(this));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }


}
