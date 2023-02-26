package FrontEnd.WindowPanels.Hexagons;

import FrontEnd.WindowPanels.MazeViewPanel;

import java.awt.*;

public class Hexagon extends Polygon {
    private static float R = 70;
    private static MazeViewPanel mazeViewPanel; //TODO utiliser la hauteur et la largeur pour centrer les hexagones, et savoir lequel doit etre centré en fonction du zoom
    private Color couleur;
    private static float r = (float) (R*Math.cos(Math.PI / 6));
    private int x;
    private int y;
    public Hexagon(int x, int y, Color couleur){
        
        this.x = x;
        this.y = y;
        this.couleur= couleur;
        for(int i = 0; i<6 ; i++){
            addPoint((int) (r*(2*x+1+(y%2)) + R*Math.cos(i*Math.PI/3 + Math.PI / 6)),(int) (r*Math.sqrt(3)*y + R*(1+Math.sin(i*Math.PI/3 + Math.PI/6))));
        }

    }
    public void setR(float R){
        this.R = R;
    }

    public void setCouleur(Color couleur){this.couleur = couleur;}

    public void setMazeViewPanel(MazeViewPanel mazeViewPanel){
        this.mazeViewPanel = mazeViewPanel;
    }
    public Color getCouleur(){return this.couleur;}
    public int getX(){return x;}
    public int getY(){return y;}



}