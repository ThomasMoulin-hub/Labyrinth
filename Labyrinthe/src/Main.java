import FrontEnd.MainFrame;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        //TODO regarder si dans ce que renvoie Dijkstra shortestPaths contient la valeur du vertex final avec containsValue et sinon dire que le labirynthe n'a pas de solution

        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();
        MainFrame mainFrame =new MainFrame();
        device.setFullScreenWindow(mainFrame);

    }
}
