package game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Level extends JPanel implements ActionListener {

    private Image background;
    private Player player;
    private Timer timer;

    public Level(){
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon src = new ImageIcon("res\\ground.png");
        background = src.getImage();

        player = new Player();
        player.load();

        addKeyListener(new keyboardAdapter());

        timer = new Timer(5,this);
        timer.start();
    }

    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(background, 0, 0, null);
        graphics2D.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);

        List<Fire> fire = player.getFire();
        for(int i = 0; i < fire.size(); i++){
            Fire m = fire.get(i);
            m.load();
            graphics2D.drawImage(m.getImage(), m.getX(), m.getY(), m.getWidth(), m.getHeight(),this);
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        List<Fire> fire = player.getFire();
        for(int i = 0; i < fire.size(); i++){
            Fire m = fire.get(i);
            if(m.isVisible()) m.update();
            else fire.remove(i);
        }

        repaint();
    }

    private class keyboardAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
        }
    }
}
