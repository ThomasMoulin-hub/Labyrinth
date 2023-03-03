package BackEnd.MazeBoxes;
/**
 * Represents the departure box of the maze
 */
import java.awt.*;

public class DepartureBox extends MazeBox{

    /**
     * Constructs a DepartureBox object with specified x and y positions.
     *
     * @param x the x position of the box in the maze.
     * @param y the y position of the box in the maze.
     */
    public DepartureBox(int x, int y){
        super(x,y,'D');
    }

    /**
     * Returns the type of the box as a char ('D' for DepartureBox).
     *
     * @return the type of the box as a char ('D' for DepartureBox).
     */
    @Override
    public char getBoxType() {
        return 'D';
    }

    /**
     * Returns the color of the box.
     *
     * @return the color of the box.
     */
    @Override
    public Color getCouleur(){return Color.GREEN;}
}
