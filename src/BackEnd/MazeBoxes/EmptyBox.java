package BackEnd.MazeBoxes;
/**
 * Represents an empty box of the maze
 */
import java.awt.*;

public class EmptyBox extends MazeBox{

    /**
     * Constructs an EmptyBox object with specified x and y positions.
     *
     * @param x the x position of the box in the maze.
     * @param y the y position of the box in the maze.
     */
    public EmptyBox(int x, int y){
        super(x,y,'E');
    }

    /**
     * Returns the type of the box as a char ('E' for EmptyBox).
     *
     * @return the type of the box as a char ('E' for EmptyBox).
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
    public Color getCouleur(){return Color.GRAY;}
}
