package game;

import javax.swing.*;

public class Container extends JFrame {

    Container(){
        setTitle("Wizard Survival");
        setResizable(false);
        setSize(1920,1080);
        setDefaultCloseOperation(Container.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Container c = new Container();
    }
}
