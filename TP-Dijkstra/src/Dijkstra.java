import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
    public HashMap<VertexInterface,VertexInterface> dijkstra(GraphInterface graph, VertexInterface startVertex, VertexInterface endVertex){
        Set<VertexInterface> processedVextexes = new HashSet();
        processedVextexes.add(startVertex);
        VertexInterface pivotVertex = startVertex;
        HashMap<VertexInterface,Integer> minDistance = new HashMap();
        HashMap<VertexInterface,VertexInterface> shortestPaths = new HashMap();

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


        return shortestPaths;
    }
}
