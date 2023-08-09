package game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Level extends JPanel implements ActionListener {

    private Image background;
    private Player player;
    private Timer timer;
    private List<Enemy> enemy;

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
        startEnemies();
    }

    public void startEnemies(){
        int coord[] = new int[40];//numero de inimigos
        enemy = new ArrayList<Enemy>();

        for(int i = 0; i < coord.length; i++){
            int x = (int)(Math.random()*-1650+1600);
            int y = (int)(Math.random()*-4500+10);
            enemy.add(new Enemy(x,y));
        }
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

        for (int i = 0; i < enemy.size(); i++){
            Enemy in = enemy.get(i);
            in.load();
            graphics2D.drawImage(in.getImage(), in.getX(), in.getY(), in.getWidth(), in.getHeight(), this);
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

        for (int i = 0; i < enemy.size(); i++){
            Enemy in = enemy.get(i);
            if (in.isVisible()){
                in.update();
            }else {
                enemy.remove(i);
            }
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
