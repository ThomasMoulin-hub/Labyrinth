package FrontEnd.WindowPanels.Hexagons;

import FrontEnd.WindowPanels.MazeViewPanel;

import java.awt.*;

public class Hexagon extends Polygon {
    private static double R = 70;
    private static MazeViewPanel mazeViewPanel; //TODO utiliser la hauteur et la largeur pour centrer les hexagones, et savoir lequel doit etre centré en fonction du zoom
    private Color couleur;
    private static double r = (R*Math.cos(Math.PI / 6));
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
    public static double getR(){return R;}
    public static void setR(double Rin){
        if(Rin < 1){
            R = 1;
        }else if(Rin > 500){
            R = 500;
        }else{
            R = Rin;
        }
        r = (R*Math.cos(Math.PI / 6));
    }
    public static double getHauteur(){
        return r * Math.sqrt(3);
    }
    public static double getLargeur(){
        return 2*r;
    }

    public void setCouleur(Color couleur){this.couleur = couleur;}

    public Color getCouleur(){return this.couleur;}
    public int getX(){return x;}
    public int getY(){return y;}



}
