package FrontEnd.WindowPanels;

/**

 * This class represents a panel used to display a maze as a grid of hexagons.
 * It extends JPanel and implements methods for painting and updating the maze view.
 * It also includes listeners for mouse and keyboard input to interact with the maze.
 */
import BackEnd.KeyBoardController;
import BackEnd.Model;
import BackEnd.MouseWheelControler;
import BackEnd.VertexInterface;
import FrontEnd.MainFrame;
import FrontEnd.WindowPanels.Hexagons.Hexagon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;


public class MazeViewPanel extends JPanel {
    private MainFrame mainFrame;

    private ArrayList<Hexagon> liste_hex = new ArrayList<>();
    private Model model;

    /**
     * Constructor for MazeViewPanel that sets the MainFrame and request focus for the panel
     * @param mainFrame the MainFrame that contains the maze view panel
     */
    public MazeViewPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        setFocusable(true);
        requestFocusInWindow();


    }

    /**
     * Initializes the MazeViewPanel after all the components are initialized.
     * Initializes the model, adds mouse and keyboard listeners, and sets the preferred size of the panel.
     */
    public void initAfterAllIsInit(){
        this.model = mainFrame.getModel();
        addMouseListener( new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                for(Hexagon hex : liste_hex){
                    if(hex.contains(e.getX(),e.getY())){
                        hex.setCouleur(model.getColorSelected());
                        model.setBox(hex.getY(),hex.getX());
                    }
                }
                setFocusable(true);
                requestFocusInWindow();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                for(Hexagon hex : liste_hex){
                    if(hex.contains(e.getX(),e.getY())){
                        hex.setCouleur(model.getColorSelected());
                        model.setBox(hex.getY(),hex.getX());
                    }
                }
                setFocusable(true);
                requestFocusInWindow();
            }
        });

        addMouseWheelListener(new MouseWheelControler(mainFrame));
        addKeyListener(new KeyBoardController(mainFrame));
    }

    /**
     * Paints the maze view panel by iterating through the list of hexagons and drawing them on the panel.
     * @param g the graphics object used to paint the panel
     */
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        for(Hexagon hex : liste_hex){
            g.setColor(hex.getCouleur());
            g.fillPolygon(hex);
            g.setColor(Color.BLACK);
            g.drawPolygon(hex);
        }

    }

    /**
     * Sets the list of hexagons to be displayed in the maze view panel.
     * @param liste the list of hexagons
     */
    public void setListe_hex(ArrayList<Hexagon> liste){
        this.liste_hex = liste;
    }

    /**
     * Notifies the MazeViewPanel that the maze has been updated and repaints the panel with the new maze view.
     */
    public void notifyForUpdate(){
        ArrayList<Hexagon> liste = new ArrayList<>();
        for(VertexInterface box : model.getMaze().getAllVertexes()){
            liste.add(new Hexagon(box.getPosition().get(1), box.getPosition().get(0),box.getCouleur()));
        }

        setListe_hex(liste);

        setPreferredSize(new Dimension((int) (Hexagon.getLargeur() * (model.getMaze().getNbcolone() + 0.5)),(int) (Hexagon.getHauteur() * (model.getMaze().getNbligne() -1) + 2*Hexagon.getR())));
        revalidate();
        repaint();

    }


}

