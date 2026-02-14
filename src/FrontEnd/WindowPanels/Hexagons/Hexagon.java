package FrontEnd.WindowPanels.Hexagons;

/**
 * Represents a Hexagon shape with a defined size, position, and color.
 */
import java.awt.*;

public class Hexagon extends Polygon {

    // The radius of the circumscribed circle of the hexagon
    private static double R = 70;

    // The color of the hexagon
    private Color couleur;

    // The radius of the inscribed circle of the hexagon
    private static double r = (R*Math.cos(Math.PI / 6));

    // The x-coordinate of the center of the hexagon
    private int x;

    // The y-coordinate of the center of the hexagon
    private int y;

    /**
     * Creates a new Hexagon with the specified center coordinates and color.
     * @param x the x-coordinate of the center of the hexagon
     * @param y the y-coordinate of the center of the hexagon
     * @param couleur the color of the hexagon
     */
    public Hexagon(int x, int y, Color couleur){
        
        this.x = x;
        this.y = y;
        this.couleur= couleur;
        for(int i = 0; i<6 ; i++){
            addPoint((int) (r*(2*x+1+(y%2)) + R*Math.cos(i*Math.PI/3 + Math.PI / 6)),(int) (r*Math.sqrt(3)*y + R*(1+Math.sin(i*Math.PI/3 + Math.PI/6))));
        }

    }

    /**
     * Returns the radius of the circumscribed circle of the hexagon.
     * @return the radius of the circumscribed circle of the hexagon
     */
    public static double getR(){return R;}

    /**
     * Sets the radius of the circumscribed circle of the hexagon.
     * @param Rin the new radius of the circumscribed circle of the hexagon
     */
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

    /**
     * Returns the height of the hexagon.
     * @return the height of the hexagon
     */
    public static double getHauteur(){
        return r * Math.sqrt(3);
    }

    /**
     * Returns the width of the hexagon.
     * @return the width of the hexagon
     */
    public static double getLargeur(){
        return 2*r;
    }

    /**
     * Sets the color of the hexagon.
     * @param couleur the new color of the hexagon
     */
    public void setCouleur(Color couleur){this.couleur = couleur;}

    /**
     * Returns the color of the hexagon.
     * @return the color of the hexagon
     */
    public Color getCouleur(){return this.couleur;}

    /**
     * Returns the x-coordinate of the center of the hexagon.
     * @return the x-coordinate of the center of the hexagon
     */
    public int getX(){return x;}
    /**
     * Returns the y-coordinate of the center of the hexagon.
     * @return the y-coordinate of the center of the hexagon
     */
    public int getY(){return y;}



}
