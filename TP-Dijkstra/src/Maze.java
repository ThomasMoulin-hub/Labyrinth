import java.util.ArrayList;

public class Maze implements GraphInterface {

    private MazeBox[][] labyrinthe;
    private int nbligne;
    private int nbcolone;

    public Maze(char[][] labyrintheBluePrints) {
        labyrinthe = new MazeBox[labyrintheBluePrints.length][labyrintheBluePrints[0].length];
        this.nbligne = labyrinthe.length;
        this.nbcolone = labyrinthe[0].length;
        for(int i = 0; i<nbligne; i++){
            for(int j = 0; j<nbcolone; j++){
                labyrinthe[i][j] = new MazeBox(i,j,labyrintheBluePrints[i][j]);
            }
        }

    }


    public ArrayList<VertexInterface> getAllVertexes() {
        ArrayList<VertexInterface> listeVertex = new ArrayList<>();
        for (int i = 0; i < nbligne; i++) {
            for (int j = 0; j < nbcolone; j++) {
                listeVertex.add(labyrinthe[i][j]);
            }
        }
        return listeVertex;
    }


    public ArrayList<VertexInterface> getNeighbour(VertexInterface noeud) {
        int x = noeud.getPosition().get(0);
        int y = noeud.getPosition().get(1);
        ArrayList<VertexInterface> liste_voisin = new ArrayList<>();
        try{if(labyrinthe[x+1][y].getBoxType() == 'E'){liste_voisin.add(labyrinthe[x+1][y]);}}
        catch (Exception e){}
        try{if(labyrinthe[x][y+1].getBoxType() == 'E'){liste_voisin.add(labyrinthe[x][y+1]);}}
        catch (Exception e){}
        try{if(labyrinthe[x+1][y-1].getBoxType() == 'E'){liste_voisin.add(labyrinthe[x+1][y-1]);}}
        catch (Exception e){}
        try{if(labyrinthe[x][y-1].getBoxType() == 'E'){liste_voisin.add(labyrinthe[x][y-1]);}}
        catch (Exception e){}
        try{if(labyrinthe[x-1][y-1].getBoxType() == 'E'){liste_voisin.add(labyrinthe[x-1][y-1]);}}
        catch (Exception e){}
        try{if(labyrinthe[x-1][y].getBoxType() == 'E'){liste_voisin.add(labyrinthe[x-1][y]);}}
        catch (Exception e){}

        return liste_voisin;
}
}

