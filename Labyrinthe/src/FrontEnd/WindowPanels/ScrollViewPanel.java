package FrontEnd.WindowPanels;

/**
 * The ScrollViewPanel class extends JScrollPane and is used to display the maze view panel with scrolling
 */
import javax.swing.*;

public class ScrollViewPanel extends JScrollPane {

    /**
     * The MazeViewPanel object used to display the maze
     */
    private MazeViewPanel mazeViewPanel;

    /**
     * Constructor for the ScrollViewPanel class
     * @param panel the MazeViewPanel object to be displayed
     */
    public ScrollViewPanel(MazeViewPanel panel){

        this.mazeViewPanel = panel;
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setWheelScrollingEnabled(true);
        setViewportView(mazeViewPanel);


    }

    /**
     * Notifies the panel to update
     */
    public void notifyForUpdate(){
        mazeViewPanel.notifyForUpdate();
        revalidate();
        repaint();
    }

    /**
     * Checks if the scroll bars are visible
     * @return true if either the horizontal or vertical scroll bar is visible, false otherwise
     */
    public boolean areScrollBarsOnScreen(){
        return getHorizontalScrollBar().isVisible() || getVerticalScrollBar().isVisible();
    }

    /**
     * Initializes the panel after all components are initialized
     */
    public void initAfterAllIsInit(){
        mazeViewPanel.initAfterAllIsInit();
    }
}
