package BackEnd;
/**

 * The GraphInterface interface represents an abstract graph, which consists of vertices and edges connecting them.
 * Any implementation of this interface should provide methods to get all vertices and the neighbors of a specific vertex.
 */
import java.util.ArrayList;


public interface GraphInterface {

   /**

    * Returns a list of all vertices in the graph.
    * @return an ArrayList of all vertices in the graph.
    */
   public ArrayList<VertexInterface> getAllVertexes();

   /**

    * Returns a list of all neighboring vertices of a specific vertex.
    * @param noeud the vertex whose neighbors are to be returned.
    * @return an ArrayList of all neighboring vertices of the given vertex.
    */
   public ArrayList<VertexInterface> getNeighbour(VertexInterface noeud);

}
