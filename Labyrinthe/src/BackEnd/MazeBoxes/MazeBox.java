package BackEnd.MazeBoxes;

import BackEnd.VertexInterface;

import java.awt.*;
import java.util.ArrayList;

public abstract class MazeBox implements VertexInterface {
    private int x;
    private int y;
    private char boxType; // Quatre types de bow E pour emptybox, W pour wallbox, D pour départ et A pour arrivée
    private Color couleur;

    public MazeBox(int x, int y, char boxType){
        this.x = x;
        this.y = y;
        this.boxType = boxType;
    }

    public abstract char getBoxType();
    public abstract Color getCouleur();
    public boolean isWallBox(){return false;}
    public boolean isPathBox(){return false;}
    public void setBoxType(char boxType){this.boxType = boxType;}


    public ArrayList<Integer> getPosition() {
        ArrayList<Integer> pos = new ArrayList<>();
        pos.add(this.x);
        pos.add(this.y);
        return pos;
    }
}
