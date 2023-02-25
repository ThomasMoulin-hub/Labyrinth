package BackEnd.MazeBoxes;

import java.awt.*;

public class PathBox extends MazeBox{
    public PathBox(int x, int y){
        super(x,y,'P');
    }

    @Override
    public char getBoxType() {
        return 'P';
    }

    @Override
    public Color getCouleur(){return Color.YELLOW;}

    @Override
    public boolean isPathBox(){return true;}
}
