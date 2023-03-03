package BackEnd;
/**

 * Dijkstra algorithm implementation to find the shortest path between two vertices in a graph.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
    /**
     * Finds the shortest path between two vertices in a graph.
     * @param graph The graph in which the shortest path is searched.
     * @param startVertex The starting vertex of the path.
     * @param endVertex The ending vertex of the path.
     * @return An ArrayList containing the vertices of the shortest path.
     */

    public ArrayList<VertexInterface> dijkstra(GraphInterface graph, VertexInterface startVertex, VertexInterface endVertex){
        Set<VertexInterface> processedVextexes = new HashSet<>(); //Set of processed vertices
        processedVextexes.add(startVertex);
        VertexInterface pivotVertex = startVertex; //Vertex used to find the shortest path
        HashMap<VertexInterface,Integer> minDistance = new HashMap<>(); //HashMap containing the minimum distance between the startVertex and each vertex
        HashMap<VertexInterface,VertexInterface> shortestPaths = new HashMap<>(); //HashMap containing the shortest path between the startVertex and each vertex

        minDistance.put(startVertex,0);

        for(VertexInterface vertex : graph.getAllVertexes()){
            if(vertex != startVertex) {
                minDistance.put(vertex, Integer.MAX_VALUE);
                }
            }

        while(!processedVextexes.contains(endVertex)){
            for(VertexInterface succVertex : graph.getNeighbour(pivotVertex)){
                if(!processedVextexes.contains(succVertex) && (minDistance.get(pivotVertex) + 1 < minDistance.get(succVertex))){
                    minDistance.replace(succVertex,minDistance.get(pivotVertex) + 1);
                    if(shortestPaths.containsKey(succVertex)){
                        shortestPaths.replace(succVertex,pivotVertex);
                    }
                    else{
                        shortestPaths.put(succVertex,pivotVertex);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            VertexInterface nextpivot = null;
            for(VertexInterface noeud : graph.getAllVertexes()){
                if(!processedVextexes.contains(noeud) && minDistance.get(noeud)<min){
                    min = minDistance.get(noeud);
                    nextpivot = noeud;
                }
            }
            pivotVertex = nextpivot;
            processedVextexes.add(pivotVertex);

        }
        VertexInterface vertex = endVertex; //Build the shortest path from endVertex to startVertex
        ArrayList<VertexInterface> res = new ArrayList<>();
        while(shortestPaths.get(vertex) != null){
            vertex = shortestPaths.get(vertex);
            res.add(vertex);
        }
        res.remove(startVertex);
        return res;
    }
}
