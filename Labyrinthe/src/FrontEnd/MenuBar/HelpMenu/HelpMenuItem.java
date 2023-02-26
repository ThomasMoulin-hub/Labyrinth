package FrontEnd.MenuBar.HelpMenu;

import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HelpMenuItem extends JMenuItem {
    private MainFrame mainFrame;
    public HelpMenuItem(MainFrame mainFrame){
        super();
        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
        //TODO mettre le texte plus gros et corriger le droite vers le bas
                JOptionPane.showMessageDialog(mainFrame,"Ce logiciel vous permet de générer et de modifier des labyrinthes à cases hexagonales dans le but de les résoudre en empruntant le plus court chemin.\nVous pouvez modifier le type d'une case en cliquant d'abord sur un des boutons de couleur situés sur le côté gauche de l'écran puis en cliquant sur la case que vous voulez modifier.\nChaque couleur correspond à un type de case qui est noté à droite de celle-ci.\nPour que la résolution fonctionne vous devez placer une et une seule case de départ et d'arrivée. Il ne vous reste plus qu'à appuyer sur : Afficher le plus court chemin !","Manuel d'utilisaton",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.mainFrame = mainFrame;
        setText("Manuel d'utilisation");
    }
}
