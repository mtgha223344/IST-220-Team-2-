
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
public class Game2 extends JPanel{
    
    JButton b1;
    
    public Game2()
    {
        super();
        setBackground(Color.YELLOW);
        b1 = new JButton("Game 2 will be here");
        add(b1);
    }
    
        public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Font f1 = new Font("Serif", Font.BOLD, 16);
        g.setFont(f1);
        g.setColor(Color.BLUE);
        g.drawString("This is Game 2's Panel", 25, 100);
    }
}
