package BackEnd.MazeBoxes;
/**
 * Represents a wall box of the maze
 */
import java.awt.*;

public class WallBox extends MazeBox{

    /**
     * Constructs a WallBox object with specified x and y positions.
     *
     * @param x the x position of the box in the maze.
     * @param y the y position of the box in the maze.
     */
    public WallBox(int x, int y){
        super(x,y,'W');
    }

    /**
     * Returns the type of the box as a char ('W' for WallBox).
     *
     * @return the type of the box as a char ('W' for WallBox).
     */
    @Override
    public char getBoxType() {
        return 'W';
    }

    /**
     * Returns the color of the box.
     *
     * @return the color of the box.
     */
    @Override
    public Color getCouleur(){return Color.BLUE;}

    /**
     * Returns true if the box is a wall box.
     *
     * @return true if the box is a wall box.
     */
    @Override
    public boolean isWallBox(){return true;}
}
