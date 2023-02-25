package BackEnd.MazeBoxes;

import java.awt.*;

public class EmptyBox extends MazeBox{
    public EmptyBox(int x, int y){
        super(x,y,'E');
    }

    @Override
    public char getBoxType() {
        return 'E';
    }

    @Override
    public Color getCouleur(){return Color.GRAY;}
}
