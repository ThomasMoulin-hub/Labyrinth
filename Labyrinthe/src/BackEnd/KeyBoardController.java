package BackEnd;

import FrontEnd.MainFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoardController extends KeyAdapter {
    //TODO zoom Ctrl+Molette / Ctrl++ / Ctrl+-
    //TODO Ctrl+Z
    private MainFrame mainFrame;
    public KeyBoardController(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_N && e.isControlDown()){
            mainFrame.getModel().newMaze();
        }else if (e.getKeyCode() == KeyEvent.VK_O && e.isControlDown()){
            mainFrame.getModel().open();
        }else if(e.getKeyCode() == KeyEvent.VK_S && e.isControlDown() && e.isShiftDown()){
            mainFrame.getModel().enregistrerSous();
        }else if(e.getKeyCode() == KeyEvent.VK_S && e.isControlDown()){
            mainFrame.getModel().enregistrer();
        }else if(e.getKeyCode() == KeyEvent.VK_EQUALS && e.isControlDown() && e.isShiftDown()){
            mainFrame.getModel().zoom();
        }else if(e.getKeyCode() == KeyEvent.VK_6 && e.isControlDown()){
            mainFrame.getModel().deZoom();
        }
    }

}
