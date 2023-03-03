package BackEnd;

/**
 * Interface representing a vertex in a graph
 */
import java.awt.*;
import java.util.ArrayList;
public interface VertexInterface {

    /**
     * Returns the position of the vertex in the form of an ArrayList containing the x and y coordinates.
     * @return an ArrayList containing the x and y coordinates of the vertex.
     */
    ArrayList<Integer> getPosition();

    /**
     * Returns the type of box associated with the vertex.
     * @return the type of box associated with the vertex.
     */
    public char getBoxType();

    /**
     * Returns the color of the vertex.
     * @return the color of the vertex.
     */
    public Color getCouleur();

    /**
     * Returns the properties of the vertex.
     */
    public String getProperties();

}
