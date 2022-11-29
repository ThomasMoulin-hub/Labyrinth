import java.util.ArrayList;

public class MazeBox implements VertexInterface{
    private int x;
    private int y;

    public MazeBox(int x, int y){
        this.x = x;
        this.y = y;
    }


    public ArrayList<Integer> getPosition() {
        ArrayList<Integer> pos = new ArrayList<>();
        pos.add(this.x);
        pos.add(this.y);
        return pos;
    }
}
