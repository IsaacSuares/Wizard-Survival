package main.java.game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Level extends JPanel implements ActionListener {

    private Image background;
    private Player player;
    private Timer timer;
    private List<main.java.game.model.Enemy> enemy;
    private boolean inGame;


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
        inGame = true;
        startEnemies();
    }

    public void startEnemies(){
        int coord[] = new int[40];//numero de inimigos
        enemy = new ArrayList<main.java.game.model.Enemy>();

        for(int i = 0; i < coord.length; i++){
            int x = (int)(Math.random()*-1650+1600);
            int y = (int)(Math.random()*-4500+10);
            enemy.add(new main.java.game.model.Enemy(x,y));
        }
    }

    public void paint(Graphics g){
        Graphics2D graphics2D = (Graphics2D) g;
        if(inGame == true){
            graphics2D.drawImage(background, 0, 0, null);
            graphics2D.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);

            List<Fire> fire = player.getFire();
            for(int i = 0; i < fire.size(); i++){
                Fire m = fire.get(i);
                m.load();
                graphics2D.drawImage(m.getImage(), m.getX(), m.getY(), m.getWidth(), m.getHeight(),this);
            }

            for (int i = 0; i < enemy.size(); i++){
                main.java.game.model.Enemy in = enemy.get(i);
                in.load();
                graphics2D.drawImage(in.getImage(), in.getX(), in.getY(), in.getWidth(), in.getHeight(), this);
            }
        }else {
            ImageIcon endGame = new ImageIcon("res\\go.png");
            graphics2D.drawImage(endGame.getImage(),0,0,null);
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
            main.java.game.model.Enemy in = enemy.get(i);
            if (in.isVisible()){
                in.update();
            }else {
                enemy.remove(i);
            }
        }
        collisionCheck();
        repaint();
    }

    public void collisionCheck(){
        Rectangle playerShape = player.getBounds();
        Rectangle enemyShape;
        Rectangle fireShape;

        for (int i = 0; i < enemy.size(); i++) {
            main.java.game.model.Enemy tempEnemy = enemy.get(i);
            enemyShape = tempEnemy.getBounds();
            if(playerShape.intersects(enemyShape)){
                player.setVisible(false);
                tempEnemy.setVisible(false);
                inGame = false;
            }
        }//colisão do inimigo com o player

        List<Fire> fire = player.getFire();
        for (int i = 0; i < fire.size(); i++) {
            Fire tempFire = fire.get(i);
            fireShape = tempFire.getBounds();
            for (int j = 0; j < enemy.size(); j++) {
                main.java.game.model.Enemy tempEnemy = enemy.get(j);
                enemyShape = tempEnemy.getBounds();
                if(fireShape.intersects(enemyShape)){
                    tempEnemy.setVisible(false);
                    tempFire.setVisible(false);

                }
                
            }
        }

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
