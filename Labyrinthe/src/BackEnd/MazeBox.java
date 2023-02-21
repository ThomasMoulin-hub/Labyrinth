package BackEnd;

import java.util.ArrayList;

public class MazeBox implements VertexInterface{
    private int x;
    private int y;
    private char boxType; // Deux types de bow E pour emptybox, W pour wallbox, D pour départ et A pour arrivée

    public MazeBox(int x, int y, char boxType){
        this.x = x;
        this.y = y;
        this.boxType = boxType;
    }

    public char getBoxType(){
        return this.boxType;
    }


    public ArrayList<Integer> getPosition() {
        ArrayList<Integer> pos = new ArrayList<>();
        pos.add(this.x);
        pos.add(this.y);
        return pos;
    }
}
