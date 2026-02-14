package BackEnd.MazeBoxes;
/**
 * Represents the arrival box of the maze
 */

import java.awt.*;

public class ArrivalBox  extends MazeBox {

    /**
     * Constructs an ArrivalBox object with specified x and y positions.
     *
     * @param x the x position of the box in the maze.
     * @param y the y position of the box in the maze.
     */
    public ArrivalBox(int x, int y){
        super(x,y,'A');
    }

    /**
     * Returns the type of the box as a char ('A' for ArrivalBox).
     *
     * @return the type of the box as a char ('A' for ArrivalBox).
     */
    @Override
    public char getBoxType() {
        return 'A';
    }

    /**
     * Returns the color of the box.
     *
     * @return the color of the box.
     */
    @Override
    public Color getCouleur(){return Color.RED;}
}
