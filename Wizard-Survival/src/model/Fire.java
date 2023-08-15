package model;

import sound.SoundEffects;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Fire {
    private Image image;
    private int x,y;
    private int height, width;
    private boolean isVisible;

    private static final int WIDTH = 938;
    private static final int SPEED = 2;

    public Fire(int x, int y){
        this.x = x;
        this.y = y;
        isVisible = true;
        fireSound();
    }

    public void load(){
        ImageIcon src = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("basic-fire.png")));
        image = src.getImage();

        this.width = 17*4;
        this.height = 20*4;
    }

    public void update(){
        this.y+=-SPEED;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void fireSound(){
        SoundEffects se = new SoundEffects();
        se.playFireSound();
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
}
