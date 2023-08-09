package game.model;

import javax.swing.*;
import java.awt.*;

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
    }

    public void load(){
        ImageIcon src = new ImageIcon("res\\basic-fire.png");
        image = src.getImage();

        this.width = 17*5;
        this.height = 20*5;
    }

    public void update(){
        this.y+=-SPEED;
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
}
