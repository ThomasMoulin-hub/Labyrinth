package BackEnd;

import java.util.ArrayList;

public interface ShortestPathsInterface {
    public void setPrevious(VertexInterface pere, VertexInterface fils);

    public VertexInterface getPrevious(VertexInterface pere);

    public ArrayList<VertexInterface> getShortestPathFrom(VertexInterface neoud);//Retourne la liste des noeuds du plus court chemin du point de départ à noeud
}
