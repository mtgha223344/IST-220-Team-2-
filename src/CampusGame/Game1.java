
package CampusGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Game1 extends JPanel {
    
    JButton b1;
    
    public Game1()
    {
        super();
        setBackground(Color.RED);
        b1 = new JButton("Game 1 will be here");
        add(b1);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Font f1 = new Font("Serif", Font.BOLD, 16);
        g.setFont(f1);
        g.setColor(Color.BLUE);
        g.drawString("This is Game 1's Panel", 25, 100);
    }
}
