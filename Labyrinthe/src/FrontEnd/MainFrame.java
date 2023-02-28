package FrontEnd;

import BackEnd.KeyBoardController;
import BackEnd.Model;
import FrontEnd.MenuBar.MenuBar;
import FrontEnd.WindowPanels.WindowPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame implements ChangeListener {

    private final WindowPanel windowPanel;
    private Model model = new Model(this);
    private final MenuBar menuBar;


    public MainFrame(){
        super("Labyrinthe");
        setContentPane(windowPanel = new WindowPanel(this));
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyBoardController(this));
        setJMenuBar(menuBar = new MenuBar(this));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                model.quit();

            }
        });
        model.addObserver(this);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setMinimumSize(new Dimension((int) screensize.getWidth()/3,(int) (3*screensize.getHeight()/4)));

        pack();


        setExtendedState(JFrame.MAXIMIZED_BOTH);


        setVisible(true);
        windowPanel.initAfterAllIsInit();


    }

    public Model getModel() {
        return model;
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if(model.getMaze().getName() != null){
            setTitle("Labyrinthe  -  "+ model.getMaze().getName().replace(".txt","") +" "+ model.getMaze().getTaille());
        }else{setTitle("Labyrinthe");}




        windowPanel.notifyForUpdate();


    }
}
