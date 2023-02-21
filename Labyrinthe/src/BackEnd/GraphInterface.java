package BackEnd;

import java.util.ArrayList;


public interface GraphInterface {
   public ArrayList<VertexInterface> getAllVertexes();
   public ArrayList<VertexInterface> getNeighbour(VertexInterface noeud);

}
