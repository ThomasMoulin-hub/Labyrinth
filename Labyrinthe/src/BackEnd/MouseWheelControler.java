package BackEnd;

/**

 * This class implements the MouseWheelListener interface to control the mouse wheel event.
 * It allows to zoom in/out or scroll horizontally/vertically depending on the user input.
 * The zoom and dezoom actions are performed by calling the zoom() and deZoom() methods respectively from the Model class.
 * Horizontal scrolling is performed when the Shift key is pressed and vertical scrolling is performed otherwise.
 */
import FrontEnd.MainFrame;
import FrontEnd.WindowPanels.Hexagons.Hexagon;

import javax.swing.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelControler implements MouseWheelListener {
    private Model model;
    private JScrollPane pane;

    /**
     * Constructor of the MouseWheelController class.
     * @param mainFrame the main frame of the application.
     */
    public MouseWheelControler(MainFrame mainFrame){
        this.model = mainFrame.getModel();
        this.pane = (JScrollPane) mainFrame.getContentPane().getComponents()[0];
    }

    /**
     * Implementation of the mouseWheelMoved method from the MouseWheelListener interface.
     * Performs the necessary actions depending on the user input.
     * If the control key is pressed, zooms in/out by calling the zoom() or deZoom() method from the Model class.
     * If the shift key is pressed, scrolls horizontally.
     * Otherwise, scrolls vertically.
     * @param e the mouse wheel event.
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        if(model.getIsControlDown()){
            if(e.getWheelRotation() < 0){
                model.zoom();
            }else if(e.getWheelRotation() > 0){
                model.deZoom();
            }
        }else if(model.getIsShiftDown()){
            pane.getHorizontalScrollBar().setValue( (int) (pane.getHorizontalScrollBar().getValue()+e.getWheelRotation()*Hexagon.getR()));

        }else{
            pane.getVerticalScrollBar().setValue((int) (pane.getVerticalScrollBar().getValue()+e.getWheelRotation()*Hexagon.getR()));

        }
    }
}
