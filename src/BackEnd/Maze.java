package BackEnd;
/**

 The Maze class represents a maze. It implements GraphInterface to enable the use of the graph algorithms on this maze.
 A maze consists of a 2D array of MazeBox objects, each representing an individual box in the maze. The MazeBox objects
 can either be of type WallBox, ArrivalBox, DepartureBox, or EmptyBox. The Maze class can be constructed from a file
 containing a string representation of the maze or by specifying the dimensions of the maze. It contains methods for
 returning information about the maze, such as its size and its name. It also contains methods for checking if the
 maze still contains an arrival or departure box, getting all the vertices in the maze, and getting the neighbors of a
 given vertex.
 */
import BackEnd.MazeBoxes.*;

import java.util.ArrayList;

public class Maze implements GraphInterface {

    /**
     * Represents the MazeBox of the maze.
     */
    private MazeBox[][] labyrinthe;

    /**
     * Represents the number of rows in the maze.
     */
    private int nbligne;

    /**
     * Represents the number of columns in the maze.
     */
    private int nbcolone;

    /**
     * Represents the DepartureBox of the maze.
     */
    private DepartureBox departureBox;

    /**
     * Represents the ArrivalBox of the maze.
     */
    private ArrivalBox arrivalBox;

    /**
     * Represents the name of the maze.
     */
    private String name;

    /**
     * Constructs a maze object from an ArrayList of string which represents the blueprint of the maze.
     * The last element of the ArrayList represents the name of the maze.
     * @param labyrintheBluePrints the blueprint of the maze.
     * @throws Exception when there are no elements in the ArrayList, a line is empty,
     * or the maze configuration is incorrect.
     */
    public Maze(ArrayList<String> labyrintheBluePrints) throws Exception {
        if(labyrintheBluePrints.size()==1){throw new Exception("Le fichier est vide !");}
        setName(labyrintheBluePrints.get(labyrintheBluePrints.size()-1));
        labyrinthe = new MazeBox[labyrintheBluePrints.size()-1][labyrintheBluePrints.get(0).length()];
        this.nbligne = labyrinthe.length;
        this.nbcolone = labyrinthe[0].length;
        for(int i =0; i < nbligne; i++){
            if(labyrintheBluePrints.get(i) == "" | labyrintheBluePrints.get(i) == "\n"){
                throw new Exception("Il y a une ligne vide, peut etre un saut de ligne au début ou à la fin du ficher");
            }
            for(int j = 0; j<nbcolone; j++){
                if(labyrintheBluePrints.get(i).charAt(j) != 'E' & labyrintheBluePrints.get(i).charAt(j) != 'A' & labyrintheBluePrints.get(i).charAt(j) != 'D' & labyrintheBluePrints.get(i).charAt(j) != 'W'){
                    throw new Exception("La configuration du labyrinthe n'est pas bonne (E,W,A,D). Il y a peut être des espaces cachés !");
                }else{
                    switch(labyrintheBluePrints.get(i).charAt(j)){
                        case'E':
                            labyrinthe[i][j] = new EmptyBox(i,j);
                            break;
                        case'W':
                            labyrinthe[i][j] = new WallBox(i,j);
                            break;
                        case'D':
                            DepartureBox dbox =new DepartureBox(i,j);
                            labyrinthe[i][j] = dbox;
                            departureBox = dbox;
                            break;
                        case'A':
                            ArrivalBox abox = new ArrivalBox(i,j);
                            labyrinthe[i][j] = abox;
                            arrivalBox = abox;
                            break;

                    }

                }
            }
        }

    }

    /**
     * Constructs a maze object with the specified dimensions.
     * @param tailleX the number of rows in the maze.
     * @param tailleY the number of columns in the maze.
     */
    public Maze(int tailleX,int tailleY){
        //constucteur qui quand on appelle Maze avec rien construit un labyrinthe avec que des cases EmptyBox
        labyrinthe = new MazeBox[tailleX][tailleY];
        this.nbligne = labyrinthe.length;
        this.nbcolone = labyrinthe[0].length;
        for(int i = 0; i<nbligne; i++){
            for(int j = 0; j<nbcolone; j++){
                labyrinthe[i][j] = new EmptyBox(i,j);
            }
        }
    }

    /**
     * Returns the maze's 2D array of MazeBoxes.
     *
     * @return The maze's 2D array of MazeBoxes.
     */
    public MazeBox [][] getLabyrinthe(){return labyrinthe;}

    /**
     * Returns the DepartureBox cell of the maze.
     *
     * @return The DepartureBox cell of the maze.
     */
    public DepartureBox getDepartureBox(){return departureBox;}

    /**
     * Returns the ArrivalBox cell of the maze.
     *
     * @return The ArrivalBox cell of the maze.
     */
    public ArrivalBox getArrivalBox() {
        return arrivalBox;
    }

    /**
     * Sets the DepartureBox cell of the maze to the specified DepartureBox.
     *
     * @param departureBox The DepartureBox to set as the DepartureBox cell of the maze.
     */
    public void setDepartureBox(DepartureBox departureBox){this.departureBox = departureBox;}

    /**
     * Sets the ArrivalBox cell of the maze to the specified ArrivalBox.
     *
     * @param arrivalBox The ArrivalBox to set as the ArrivalBox cell of the maze.
     */
    public void setArrivalBox(ArrivalBox arrivalBox){this.arrivalBox = arrivalBox;}

    /**
     * Sets the name of the maze to the specified name.
     *
     * @param name The name to set for the maze.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns the number of columns in the maze.
     *
     * @return The number of columns in the maze.
     */
    public String getName(){return name;}

    /**

     * Returns the number of columns in the maze.
     * @return the number of columns in the maze
     */
    public int getNbcolone() {
        return nbcolone;
    }

    /**

     * Returns the number of rows in the maze.
     * @return the number of rows in the maze
     */
    public int getNbligne(){
        return nbligne;
    }

    /**
     * Returns a string representing the size of the maze.
     * @return a string representing the size of the maze in the format (rows x columns)
     */
    public String getTaille(){
        return "("+ nbligne+"x"+ nbcolone+")";
    }

    /**
     * Checks if the arrival and departure boxes still exist in the maze, and sets them to null if they don't.
     */
    public void checkIfStillArrivalOrDeparture(){
        if(arrivalBox != null){
            if(labyrinthe[arrivalBox.getPosition().get(0)][arrivalBox.getPosition().get(1)].getBoxType()!='A'){
                arrivalBox = null;
            }
        }
        if(departureBox != null){
            if(labyrinthe[departureBox.getPosition().get(0)][departureBox.getPosition().get(1)].getBoxType()!='D'){
                departureBox = null;
            }
        }

    }

    /**
     * Returns a list of all vertices in the graph.
     *
     * @return an ArrayList containing all vertices in the graph.
     */
    public ArrayList<VertexInterface> getAllVertexes() {
        ArrayList<VertexInterface> listeVertex = new ArrayList<>();
        for (int i = 0; i < nbligne; i++) {
            for (int j = 0; j < nbcolone; j++) {
                listeVertex.add(labyrinthe[i][j]);
            }
        }
        return listeVertex;
    }

    /**
     * Returns a list of all neighbors for a given vertex.
     *
     * @param noeud the vertex whose neighbors are to be returned.
     * @return an ArrayList containing all neighbors of the given vertex.
     */
    public ArrayList<VertexInterface> getNeighbour(VertexInterface noeud) {
        int x = noeud.getPosition().get(0);
        int y = noeud.getPosition().get(1);
        ArrayList<VertexInterface> liste_voisin = new ArrayList<>();

        if(x%2 == 0){
            try{if(!labyrinthe[x+1][y].isWallBox()){liste_voisin.add(labyrinthe[x+1][y]);}}
            catch (Exception e){}
            try{if(!labyrinthe[x][y+1].isWallBox()){liste_voisin.add(labyrinthe[x][y+1]);}}
            catch (Exception e){}
            try{if(!labyrinthe[x+1][y-1].isWallBox()){liste_voisin.add(labyrinthe[x+1][y-1]);}}
            catch (Exception e){}
            try{if(!labyrinthe[x][y-1].isWallBox()){liste_voisin.add(labyrinthe[x][y-1]);}}
            catch (Exception e){}
            try{if(!labyrinthe[x-1][y-1].isWallBox()){liste_voisin.add(labyrinthe[x-1][y-1]);}}
            catch (Exception e){}
            try{if(!labyrinthe[x-1][y].isWallBox()){liste_voisin.add(labyrinthe[x-1][y]);}}
            catch (Exception e){}
        }
        else {
            try{if(!labyrinthe[x+1][y].isWallBox()){liste_voisin.add(labyrinthe[x+1][y]);}}
            catch (Exception e){}
            try{if(!labyrinthe[x][y+1].isWallBox()){liste_voisin.add(labyrinthe[x][y+1]);}}
            catch (Exception e){}
            try{if(!labyrinthe[x+1][y+1].isWallBox()){liste_voisin.add(labyrinthe[x+1][y+1]);}}
            catch (Exception e){}
            try{if(!labyrinthe[x][y-1].isWallBox()){liste_voisin.add(labyrinthe[x][y-1]);}}
            catch (Exception e){}
            try{if(!labyrinthe[x-1][y].isWallBox()){liste_voisin.add(labyrinthe[x-1][y]);}}
            catch (Exception e){}
            try{if(!labyrinthe[x-1][y+1].isWallBox()){liste_voisin.add(labyrinthe[x-1][y+1]);}}
            catch (Exception e){}
        }




        return liste_voisin;
    }
}

