/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampusGame;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Student extends Character {
    
    
    private int width;
    private int height;
    private Image image;
    
    public Student() {
        
        loadImage();
    }
    
    @Override
    public void loadImage() {
        
        ImageIcon ii = new ImageIcon(getClass().getResource("/resources/Student.JPG"));
        image = ii.getImage(); 
        width = image.getWidth(null);
        height = image.getHeight(null);
    }
    @Override
    public Image getImage() {
        
        return image;
    }
    
    @Override 
    public Rectangle getBounds() {
        return new Rectangle(super.getX(), super.getY(), width, height);
    }
    
    @Override
        public void keyPressed(KeyEvent e) {
        
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT){
           super.dx = -3;
           System.out.println("Student Left");
        }
        
        if (key == KeyEvent.VK_RIGHT) {
            super.dx = 3;
        }
        //Check upward movement speed
        if (key == KeyEvent.VK_UP) {
            super.dy = -3;
        }

        if (key == KeyEvent.VK_DOWN) {
           super.dy =3;
        }
    }
}
