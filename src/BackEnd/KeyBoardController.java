package BackEnd;
/**
 * This class extends a key event listener that handles keyboard shortcuts in a maze application.
 */
import FrontEnd.MainFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyBoardController extends KeyAdapter {
    private Model model;

    /**
     * Constructs a KeyBoardController object with the given MainFrame object.
     *
     * @param mainFrame the MainFrame object to associate with this KeyBoardController object.
     */
    public KeyBoardController(MainFrame mainFrame){
        this.model = mainFrame.getModel();
    }

    /**
     * Handles the key pressed event by performing actions based on the key pressed.
     *
     * @param e the KeyEvent object representing the key pressed event.
     */
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

    /**
     * Handles the key released event by resetting the control and shift flags.
     *
     * @param e the KeyEvent object representing the key released event.
     */
    @Override
    public void keyReleased(KeyEvent e){
        if(model.getIsControlDown()) {
            model.setIsControlDown(false);

        }else if(model.getIsShiftDown()){
            model.setIsShiftDown(false);
        }
    }

}
