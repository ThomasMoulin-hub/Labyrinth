import java.security.spec.ECField;
import java.util.ArrayList;

public class Maze implements GraphInterface {

    private MazeBox[][] labyrithe;
    private int nbligne;
    private int nbcolone;

    public Maze(MazeBox[][] labyrithe) {
        this.labyrithe = labyrithe;
        this.nbligne = labyrithe.length;
        this.nbcolone = labyrithe[0].length;
    }


    public ArrayList<VertexInterface> getAllVertexes() {
        ArrayList<VertexInterface> listeVertex = new ArrayList<>();
        for (int i = 0; i < nbligne; i++) {
            for (int j = 0; j < nbcolone; j++) {
                listeVertex.add(labyrithe[i][j]);
            }
        }
        return listeVertex;
    }


    public ArrayList<VertexInterface> getNeighbour(VertexInterface noeud) {
        int x = noeud.getPosition().get(0);
        int y = noeud.getPosition().get(1);
        ArrayList<VertexInterface> liste_voisin = new ArrayList<>();
        try{liste_voisin.add(labyrithe[x+1][y]);}
        catch (Exception e){}
        try{liste_voisin.add(labyrithe[x][y+1]);}
        catch (Exception e){}
        try{liste_voisin.add(labyrithe[x+1][y-1]);}
        catch (Exception e){}
        try{liste_voisin.add(labyrithe[x][y-1]);}
        catch (Exception e){}
        try{liste_voisin.add(labyrithe[x-1][y-1]);}
        catch (Exception e){}
        try{liste_voisin.add(labyrithe[x-1][y]);}
        catch (Exception e){}

        return liste_voisin;
}
}

