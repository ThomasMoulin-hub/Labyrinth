package FrontEnd.WindowPanels;

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



    public MazeViewPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        setFocusable(true);
        requestFocusInWindow();


    }
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
    public void setListe_hex(ArrayList<Hexagon> liste){
        this.liste_hex = liste;
    }
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

