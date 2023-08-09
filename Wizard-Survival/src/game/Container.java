package game;

import game.model.Level;

import javax.swing.*;

public class Container extends JFrame {

    Container(){
        add(new Level());
        setTitle("Wizard Survival");
        this.setResizable(false);
        setSize(1920,1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Container.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Container c = new Container();
    }
}
