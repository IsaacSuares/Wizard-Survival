import model.Level;

import javax.swing.*;
import java.awt.*;

public class Container extends JFrame {

    private JLabel overlayLabel;
    Container(){

        add(new Level());
        setTitle("Wizard Survival");
        this.setResizable(false);
        setSize(1700,1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Container.EXIT_ON_CLOSE);
        setVisible(true);





    }




    public static void main(String[] args) {
        Container c = new Container();
    }
}
