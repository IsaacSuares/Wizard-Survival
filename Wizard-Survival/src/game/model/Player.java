package game.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private int x,y;
    private int dx, dy;
    private Image image;
    private int height, width;
    private List<Fire> fire;
    private boolean isVisible;

    public Player(){
        this.x = 100;
        this.y = 100;
        //define onde o player nasce

        isVisible = true;
        fire = new ArrayList<Fire>();
    }

    public void load(){
        ImageIcon src = new ImageIcon("res\\char.png");
        image = src.getImage();

        height = (int)(84*1.5);
        width = (int) (62*1.5);
    }

    public void update(){
        x += dx;
        y += dy;
    }

    public void basicFire(){
        this.fire.add(new Fire(x+(width/7), y));//posição de onde sai o tiro, em relação ao player
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,width-40,height-50);
    }

    public void keyPressed(KeyEvent key){
        int code = key.getKeyCode();

        if(code == KeyEvent.VK_F){
            basicFire();
        }

        if(code == KeyEvent.VK_UP){
            dy = -4;
        }

        if(code == KeyEvent.VK_DOWN){
            dy = 4;
        }

        if(code == KeyEvent.VK_LEFT){
            dx = -4;
        }

        if(code == KeyEvent.VK_RIGHT){
            dx = 4;
        }
    }

    public void keyReleased(KeyEvent key){
        int code = key.getKeyCode();

        if(code == KeyEvent.VK_UP){
            dy = 0;
        }

        if(code == KeyEvent.VK_DOWN){
            dy = 0;
        }

        if(code == KeyEvent.VK_LEFT){
            dx = 0;
        }

        if(code == KeyEvent.VK_RIGHT){
            dx = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Image getImage() {
        return image;
    }

    public List<Fire> getFire() {
        return fire;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
