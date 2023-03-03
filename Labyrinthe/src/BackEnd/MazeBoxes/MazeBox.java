package BackEnd.MazeBoxes;
/**
 * This asbstract class represents a maze box that implements the VertexInterface.
 * It has a position (x,y) and a type (E for EmptyBox, W for WallBox, D for DepartureBox and A for ArrivalBox).
 * It also has a color.
 */

import BackEnd.VertexInterface;

import java.awt.*;
import java.util.ArrayList;

public abstract class MazeBox implements VertexInterface {
    private int x; //x-coordinate of the box
    private int y; //y-coordinate of the box
    private char boxType; // type of the box (E for empty, W for wall, D for departure and A for arrival)
    private Color couleur; // color of the box

    /**
     * Constructor for MazeBox class.
     * @param x The x-coordinate of the box.
     * @param y The y-coordinate of the box.
     * @param boxType The type of the box (E for empty, W for wall, D for departure and A for arrival).
     */
    public MazeBox(int x, int y, char boxType){
        this.x = x;
        this.y = y;
        this.boxType = boxType;
    }

    /**
     * Gets the type of the box.
     * @return The type of the box.
     */
    public abstract char getBoxType();

    /**
     * Gets the color of the box.
     * @return The color of the box.
     */
    public abstract Color getCouleur();

    /**
     * Checks if the box is a wall box.
     * @return False (by default, as not all boxes are wall boxes).
     */
    public boolean isWallBox(){return false;}

    /**
     * Checks if the box is a path box.
     * @return False (by default, as not all boxes are path boxes).
     */
    public boolean isPathBox(){return false;}


    /**
     * Gets the position of the box.
     * @return The x and y coordinates of the box as an ArrayList of integers.
     */
    public ArrayList<Integer> getPosition() {
        ArrayList<Integer> pos = new ArrayList<>();
        pos.add(this.x);
        pos.add(this.y);
        return pos;
    }

    @Override
    public String getProperties() {
        return "Box type: " + this.boxType + " | Position: (" + this.x + "," + this.y + ")";
    }
}
