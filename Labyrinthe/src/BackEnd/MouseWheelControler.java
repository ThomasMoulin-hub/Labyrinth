package BackEnd;

import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelControler implements MouseWheelListener {
    private MainFrame mainFrame;
    private JScrollPane pane;
    public MouseWheelControler(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.pane = (JScrollPane) mainFrame.getContentPane().getComponents()[0];
    }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        if(mainFrame.getModel().getIsControlDown()){
            if(e.getWheelRotation() < 0){
                mainFrame.getModel().zoom();
            }else if(e.getWheelRotation() > 0){
                mainFrame.getModel().deZoom();
            }
        }else if(mainFrame.getModel().getIsShiftDown()){
            pane.getHorizontalScrollBar().setValue(pane.getHorizontalScrollBar().getValue()+e.getWheelRotation());

        }else{
            pane.getVerticalScrollBar().setValue(pane.getVerticalScrollBar().getValue()+e.getWheelRotation());

        }
    }
}
