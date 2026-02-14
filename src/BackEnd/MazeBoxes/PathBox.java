package BackEnd.MazeBoxes;
/**
 * Represents a path box of the maze
 */

import java.awt.*;

public class PathBox extends MazeBox{

    /**
     * Constructs a PathBox object with specified x and y positions.
     *
     * @param x the x position of the box in the maze.
     * @param y the y position of the box in the maze.
     */
    public PathBox(int x, int y){
        super(x,y,'P');
    }

    /**
     * Returns the type of the box considered as en EmptyBox when saving as a char ('P' for EmptyBox).
     *
     * @return the type of the box as a char ('E' for Emptybox).
     */
    @Override
    public char getBoxType() {
        return 'E';
    }

    /**
     * Returns the color of the box.
     *
     * @return the color of the box.
     */
    @Override
    public Color getCouleur(){return Color.YELLOW;}

    /**
     * Returns true if the box is a PathBox.
     *
     * @return true if the box is a PathBox.
     */
    @Override
    public boolean isPathBox(){return true;}

}
