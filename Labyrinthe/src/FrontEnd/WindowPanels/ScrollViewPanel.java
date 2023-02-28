package FrontEnd.WindowPanels;

import FrontEnd.MainFrame;

import javax.swing.*;

public class ScrollViewPanel extends JScrollPane {
    private MazeViewPanel mazeViewPanel;

    public ScrollViewPanel(MainFrame mainFrame, MazeViewPanel panel){

        this.mazeViewPanel = panel;
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setWheelScrollingEnabled(true);
        setViewportView(mazeViewPanel);


    }
    public void notifyForUpdate(){
        mazeViewPanel.notifyForUpdate();
        revalidate();
        repaint();
    }
    public void initAfterAllIsInit(){
        mazeViewPanel.initAfterAllIsInit();
    }
}
