/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampusGame;

import java.awt.Image;
import java.awt.Rectangle;
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
    
}
