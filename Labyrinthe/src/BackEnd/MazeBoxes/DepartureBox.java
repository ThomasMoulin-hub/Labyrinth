package BackEnd.MazeBoxes;

import java.awt.*;

public class DepartureBox extends MazeBox{
    public DepartureBox(int x, int y){
        super(x,y,'D');
    }
    @Override
    public char getBoxType() {
        return 'D';
    }

    @Override
    public Color getCouleur(){return Color.GREEN;}
}
