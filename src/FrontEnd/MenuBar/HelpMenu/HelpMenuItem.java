package FrontEnd.MenuBar.HelpMenu;

/**
 * A custom JMenuItem that displays a help message when clicked.
 * The help message contains instructions on how to use the application to generate, modify and solve hexagonal mazes.
 */
import FrontEnd.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HelpMenuItem extends JMenuItem {

    /**
     * A JLabel that contains the help message to be displayed.
     */
    private JLabel label = new JLabel("<html>Ce logiciel vous permet de générer et de modifier des labyrinthes à cases hexagonales dans le but de les résoudre en empruntant le plus court chemin.<br>Vous pouvez modifier le type d'une case en cliquant d'abord sur un des boutons de couleur situés en bas de l'écran puis en cliquant sur la case que vous voulez modifier.<br>Chaque couleur correspond à un type de case qui est noté au dessus de celle-ci.<br>Pour que la résolution fonctionne vous devez placer une et une seule case de départ et d'arrivée. Il ne vous reste plus qu'à appuyer sur : Afficher le plus court chemin !<html>");

    /**
     * Creates a new instance of HelpMenuItem.
     * Sets the text of the JMenuItem to "Manuel d'utilisation" and adds an ActionListener to display the help message.
     * @param mainFrame the main JFrame of the application
     */
    public HelpMenuItem(MainFrame mainFrame){
        label.setFont(new Font("Arial",Font.PLAIN,18));

        // Set the action of the JMenuItem to display the help message as a JOptionPane
        setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainFrame,label,"Manuel d'utilisaton",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setText("Manuel d'utilisation");
    }
}
