package BackEnd.MazeBoxes;

import java.awt.*;

public class ArrivalBox  extends MazeBox {
    public ArrivalBox(int x, int y){
        super(x,y,'A');
    }

    @Override
    public char getBoxType() {
        return 'A';
    }

    @Override
    public Color getCouleur(){return Color.RED;}
}
