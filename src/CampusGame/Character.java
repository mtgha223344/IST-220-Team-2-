package CampusGame;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Character {
    
    int dx;
    int dy;
    int x = 40;
    int y = 60;
    int width;
    int height;
    Image image;

    public Character() {
        
        loadImage();
            
    }

    public void loadImage() {
        
        ImageIcon ii = new ImageIcon(getClass().getResource("/resources/icon.JPG"));
        image = ii.getImage(); 
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void move() {
        
        x += dx;
        y += dy;
    }

    public int getX() {
        
        return x;
    }

    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return width;
    }
    
    public int getHeight() {
        
        return height;
    }    

    public Image getImage() {
        
        return image;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    //default movemement characteristics, overriden in the student and professor class
    public void keyPressed(KeyEvent e) {

        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
}
