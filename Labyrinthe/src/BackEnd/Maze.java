package BackEnd;

import BackEnd.MazeBoxes.*;

import java.util.ArrayList;

public class Maze implements GraphInterface {

    private MazeBox[][] labyrinthe;
    private int nbligne;
    private int nbcolone;
    private DepartureBox departureBox;
    private ArrivalBox arrivalBox;
    private String name;



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
    public MazeBox [][] getLabyrinthe(){return labyrinthe;}
    public DepartureBox getDepartureBox(){return departureBox;}

    public ArrivalBox getArrivalBox() {
        return arrivalBox;
    }

    public void setDepartureBox(DepartureBox departureBox){this.departureBox = departureBox;}
    public void setArrivalBox(ArrivalBox arrivalBox){this.arrivalBox = arrivalBox;}
    public void setName(String name){
        this.name = name;
    }
    public String getName(){return name;}

    public int getNbcolone() {
        return nbcolone;
    }
    public int getNbligne(){
        return nbligne;
    }

    public String getTaille(){
        return "("+ nbligne+"x"+ nbcolone+")";
    }

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

