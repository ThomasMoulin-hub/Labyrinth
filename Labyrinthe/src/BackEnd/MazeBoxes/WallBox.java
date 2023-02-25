package BackEnd.MazeBoxes;

import java.awt.*;

public class WallBox extends MazeBox{
    public WallBox(int x, int y){
        super(x,y,'W');
    }

    @Override
    public char getBoxType() {
        return 'W';
    }

    @Override
    public Color getCouleur(){return Color.BLUE;}

    @Override
    public boolean isWallBox(){return true;}
}
