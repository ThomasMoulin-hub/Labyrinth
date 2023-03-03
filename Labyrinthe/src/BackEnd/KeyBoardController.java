package BackEnd;

import FrontEnd.MainFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoardController extends KeyAdapter {
    private Model model;
    public KeyBoardController(MainFrame mainFrame){
        this.model = mainFrame.getModel();
    }

    @Override
    public void keyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_N && e.isControlDown()){
            model.newMaze();
            model.setIsControlDown(false);
            model.setIsShiftDown(false);

        }else if (e.getKeyCode() == KeyEvent.VK_O && e.isControlDown()){
            model.open();
            model.setIsControlDown(false);
            model.setIsShiftDown(false);

        }else if(e.getKeyCode() == KeyEvent.VK_S && e.isControlDown() && e.isShiftDown()){
            model.enregistrerSous();
            model.setIsControlDown(false);
            model.setIsShiftDown(false);

        }else if(e.getKeyCode() == KeyEvent.VK_S && e.isControlDown()){
            model.enregistrer();
            model.setIsControlDown(false);
            model.setIsShiftDown(false);

        }else if(e.getKeyCode() == KeyEvent.VK_EQUALS && e.isControlDown() && e.isShiftDown()){
            model.zoom();
        }else if(e.getKeyCode() == KeyEvent.VK_6 && e.isControlDown()){
            model.deZoom();
        }else if(e.getKeyCode() == KeyEvent.VK_Z && e.isControlDown()){
            model.retablir();
        }else if(e.isControlDown()){
            model.setIsControlDown(true);
        }else if(e.isShiftDown()){
            model.setIsShiftDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        if(model.getIsControlDown()) {
            model.setIsControlDown(false);

        }else if(model.getIsShiftDown()){
            model.setIsShiftDown(false);
        }
    }

}
