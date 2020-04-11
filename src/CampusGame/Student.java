/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CampusGame;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Student extends Character {
    
    private int dx;
    private int dy;
    private int x = 40;
    private int y = 60;
    private int width;
    private int height;
    private Image image;
    
    //https://stackoverflow.com/questions/33398294/what-happens-if-you-call-an-overridden-method-using-super-in-a-constructor
    
    public Student() {
        
        ImageIcon ii = new ImageIcon(getClass().getResource("/resources/Student.JPG"));
        image = ii.getImage(); 
        System.out.println("Student image called");
        
        width = image.getWidth(null);
        height = image.getHeight(null);
    }
    
   
    
}
