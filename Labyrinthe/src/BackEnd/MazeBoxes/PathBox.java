package BackEnd.MazeBoxes;

import java.awt.*;

public class PathBox extends MazeBox{
    public PathBox(int x, int y){
        super(x,y,'P');
    }

    @Override
    public char getBoxType() {
        return 'E';
    } //Retourne E car quand on sauvegarde le maze on compte cette box comme une EmptyBox

    @Override
    public Color getCouleur(){return Color.YELLOW;}

    @Override
    public boolean isPathBox(){return true;}
}
