package FrontEnd.WindowPanels.ControlPanels;

import BackEnd.KeyBoardController;
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private MainFrame mainFrame;
    private BoxTypeChoicePanel boxChoicePanel;
    private BoutonsControlPanel boutonsControlPanel;
    private LabyInfosPanel labyInfosPanel;
    public ControlPanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

        boxChoicePanel = new BoxTypeChoicePanel(mainFrame);
        boutonsControlPanel = new BoutonsControlPanel(mainFrame);
        labyInfosPanel = new LabyInfosPanel(mainFrame);
        add(boutonsControlPanel,BorderLayout.EAST);
        add(boxChoicePanel,BorderLayout.CENTER);
        add(labyInfosPanel,BorderLayout.WEST);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyBoardController(mainFrame));
    }
    public void notifyForUpdate(){
        labyInfosPanel.notifyForUpdate();

    }
    public void initAfterAllIsInit(){
        boxChoicePanel.initAfterAllIsInit();
        boutonsControlPanel.initAfterAllIsInit();
        labyInfosPanel.initAfterAllIsInit();
    }
}
