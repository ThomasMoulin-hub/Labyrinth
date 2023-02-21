package FrontEnd.WindowPanel;

import java.awt.*;

class Hexagon extends Polygon {
    private static float R = 70;
    private static MazeViewPanel mazeViewPanel; //TODO utiliser la hauteur et la largeur pour centrer les hexagones, et savoir lequel doit etre centré en fonction du zoom
    private Color couleur;
    private static float r = (float) (R*Math.cos(Math.PI / 6));
    private int x;
    private int y;
    public Hexagon(int x, int y, char boxType){
        
        this.x = x;
        this.y = y;
        switch (boxType){
            case 'A':
                this.couleur = Color.RED;
                break;

            case 'D':
                this.couleur = Color.GREEN;
                break;

            case 'W':
                this.couleur = Color.BLUE;
                break;

            default:
                this.couleur = Color.GRAY;
                break;
        }
        for(int i = 0; i<6 ; i++){
            addPoint((int) (r*(2*x+1+(y%2)) + R*Math.cos(i*Math.PI/3 + Math.PI / 6)),(int) (r*Math.sqrt(3)*y + R*(1+Math.sin(i*Math.PI/3 + Math.PI/6))));
        }

    }
    public void setR(float R){
        this.R = R;
    }
    public void setMazeViewPanel(MazeViewPanel mazeViewPanel){
        this.mazeViewPanel = mazeViewPanel;
    }
    public Color getCouleur(){return this.couleur;}



}
