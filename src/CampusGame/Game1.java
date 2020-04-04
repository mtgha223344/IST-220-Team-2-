
package CampusGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author user
 */
public class Game1 extends JPanel implements ActionListener{
    
    JButton b1, testButton;
    private Character character;
    public Timer timer;
    private int DELAY = 10;
    private int score;

    //score getter
    public int getScore() {
        return score;
    }
    
    public Game1()
    {
        super();
        setBackground(Color.RED);
        b1 = new JButton("Game 1 will be here");
        add(b1);
        
        testButton = new JButton("Press here for score");
        add(b1);
        add(testButton);
        
        testButton.setBounds(new Rectangle(450, 375, 150, 35));
        
        addKeyListener(new TAdapter());
        setFocusable(true);
  
        character = new Character();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        setBackground(Color.white);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
        requestFocusInWindow();
        
        Font f1 = new Font("Serif", Font.BOLD, 20);
        g.setFont(f1);
        g.setColor(Color.BLUE);
        g.drawString("Main Map", 50, 100);
        g.drawString("This is Game 1's Panel", 25, 100);
    }
    
    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(character.getImage(), character.getX(), 
            character.getY(), this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == testButton)
        {
            score++;
            //System.out.println(score);
        }
        step();
    }
    
    private void step() {
        
        character.move();
        repaint();
    }    

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            character.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            character.keyPressed(e);
        }
    }
    
}
