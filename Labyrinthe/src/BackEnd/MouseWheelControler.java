package BackEnd;

import FrontEnd.MainFrame;
import FrontEnd.WindowPanels.Hexagons.Hexagon;

import javax.swing.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelControler implements MouseWheelListener {

    private Model model;
    private JScrollPane pane;
    public MouseWheelControler(MainFrame mainFrame){
        this.model = mainFrame.getModel();
        this.pane = (JScrollPane) mainFrame.getContentPane().getComponents()[0];
    }
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
