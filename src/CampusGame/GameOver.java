

package CampusGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPanel;


public class GameOver extends JPanel {
    
        JButton restart;
        JButton finalTime;
    
    public GameOver(){
        
        super();
        setBackground(Color.white);
        setLayout(null);
        restart = new JButton("Start Over.");  //button to return to IntroScreen
        add(restart);
        
        restart.setBounds(new Rectangle(450,375,150,35));
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Font f1 = new Font("Serif", Font.BOLD, 16);
        g.setFont(f1);
        g.setColor(Color.BLUE);
        g.drawString("This will be the game over screen. Currently if all three games are visited this panel will be triggered.", 25, 100);
        g.drawString("Eventually this will display final score and time.", 25, 150);
    }
}