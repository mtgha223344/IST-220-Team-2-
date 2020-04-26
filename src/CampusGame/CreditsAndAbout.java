
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
public class CreditsAndAbout extends JPanel {
    
    JButton credReturn;
    
    public CreditsAndAbout(){
        
        super();
        setBackground(Color.BLACK);
        setLayout(null);
        credReturn = new JButton("Return to Main Menu");    //button to return to IntroScreen
        
        add(credReturn);
        credReturn.setBounds(new Rectangle (450,375,150,35));
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Font f1 = new Font("Serif", Font.PLAIN, 20);
        g.setFont(f1);
        g.setColor(Color.WHITE);
        g.drawString("This game created by the members of IST 240 Group 2:", 50, 100);
        g.drawString("Nia Anderson", 50, 130);
        g.drawString("Brandon Gold", 50, 160);
        g.drawString("Bryce Livingston", 50, 190);
        g.drawString("Brandon Pollock", 50, 220);
    }
    
}
