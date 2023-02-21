package FrontEnd.WindowPanel.ControlPanel;

import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private MainFrame mainFrame;
    private BoxChoicePanel boxChoicePanel;
    private BoutonsControlPanel boutonsControlPanel;
    private LabyInfosPanel labyInfosPanel;
    public ControlPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

        boxChoicePanel = new BoxChoicePanel();
        boutonsControlPanel = new BoutonsControlPanel(mainFrame);
        labyInfosPanel = new LabyInfosPanel();
        add(boutonsControlPanel,BorderLayout.SOUTH);
        add(boxChoicePanel,BorderLayout.CENTER);
        add(labyInfosPanel,BorderLayout.NORTH);
    }
    public void notifyForUpdate(){
        repaint();
    }
}
