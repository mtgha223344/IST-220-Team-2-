
package CampusGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Instructions extends JPanel {
    
    JButton inReturn;
    
    public Instructions(){
        
        super();
        setBackground(Color.white);
        setLayout(null);
        inReturn = new JButton("Return to Main Menu");  //button to return to IntroScreen
        add(inReturn);
        
        inReturn.setBounds(new Rectangle(450,375,150,35));
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Font f1 = new Font("Serif", Font.BOLD, 16);
        g.setFont(f1);
        g.setColor(Color.BLUE);
        g.drawString("1. Move your character around a map of Pennsylvania to 5 different campuses", 25, 100);
        g.drawString("2. At each campus, select a challenge - Multiple Choice, Puzzle, or Game", 25, 130);
        g.drawString("3. Collect Points at each location", 25, 160);
        g.drawString("4. After 5 campus visits, the game will be over and your character's score will be shown", 25, 190);
    }
}
