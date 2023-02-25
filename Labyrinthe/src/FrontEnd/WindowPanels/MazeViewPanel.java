package FrontEnd.WindowPanels;

import BackEnd.VertexInterface;
import FrontEnd.MainFrame;
import FrontEnd.WindowPanels.Hexagons.Hexagon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

            }
        });

        this.mainFrame = mainFrame;

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
        liste_hex = liste;
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

