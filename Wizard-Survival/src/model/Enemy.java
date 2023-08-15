package model;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Enemy {
    private Image image;
    private int x,y;
    private int height, width;
    private boolean isVisible;
    private int hp = 2;

    private static final int SPEED = 1;

    public Enemy(int x, int y){
        this.x = x;
        this.y = y;

        isVisible = true;
    }

    public void load(){
        ImageIcon src = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("enemy.png")));
        image = src.getImage();

        this.width = 17*5;
        this.height = 20*5;
    }

    public void update(){
        this.y+=SPEED;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public static void setSPEED(int SPEED){
        SPEED = SPEED;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
}
