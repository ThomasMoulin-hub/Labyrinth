package FrontEnd.WindowPanels;

import BackEnd.KeyBoardController;
import BackEnd.VertexInterface;
import FrontEnd.MainFrame;
import FrontEnd.WindowPanels.Hexagons.Hexagon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class MazeViewPanel extends JPanel {
    private MainFrame mainFrame;

    private ArrayList<Hexagon> liste_hex = new ArrayList<>();


    public MazeViewPanel(MainFrame mainFrame) {

        addMouseListener( new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                for(Hexagon hex : liste_hex){
                    if(hex.contains(e.getX(),e.getY())){
                        hex.setCouleur(mainFrame.getModel().getColorSelected());
                        mainFrame.getModel().setBoxType(hex.getY(),hex.getX());
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
                        hex.setCouleur(mainFrame.getModel().getColorSelected());
                        mainFrame.getModel().setBoxType(hex.getY(),hex.getX());
                    }
                }
                setFocusable(true);
                requestFocusInWindow();
            }
        });

        addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(mainFrame.getModel().getIsControlDown()){
                    if(e.getWheelRotation()>0){
                        mainFrame.getModel().zoom();
                    }else if(e.getWheelRotation() < 0){
                        mainFrame.getModel().deZoom();
                    }
                }
            }
        });
        this.mainFrame = mainFrame;
        setFocusable(true);
        requestFocusInWindow();
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
        for(VertexInterface box : mainFrame.getModel().getMaze().getAllVertexes()){
            liste.add(new Hexagon(box.getPosition().get(1), box.getPosition().get(0),box.getCouleur()));
        }
        setListe_hex(liste);
        repaint();
    }


}

