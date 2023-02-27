package BackEnd;

import FrontEnd.MainFrame;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelControler implements MouseWheelListener {
    private MainFrame mainFrame;
    public MouseWheelControler(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(mainFrame.getModel().getIsControlDown()){
            if(e.getWheelRotation() < 0){
                mainFrame.getModel().zoom();
            }else if(e.getWheelRotation() > 0){
                mainFrame.getModel().deZoom();
            }
        }
    }
}
