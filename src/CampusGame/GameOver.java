

package CampusGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;


public class GameOver extends JPanel {
    
        JButton restart;
        JButton finalTime;
        private Image background;
        String informedTimerHours, informedTimerMinutes, informedTimerSeconds, informedGameScore;
    
    public GameOver(){
        
        super();
        setLayout(null);
        
        background = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/GameOverBackground.JPG"));
        
        restart = new JButton("Play Again?");  //button to return to IntroScreen
        add(restart);
        
        finalTime = new JButton();
        
        restart.setBounds(new Rectangle(550,475,150,35));
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.white);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {

    Graphics2D g2d = (Graphics2D) g;
        
    g.drawImage(background, 0, 0, this);
    requestFocusInWindow();
    Font f1 = new Font("Serif", Font.BOLD, 16);
    g.setFont(f1);
    g.setColor(Color.WHITE);
    g.drawString("Your final score was " + informedGameScore, 50, 450);
    g.drawString("Your final time was " + informedTimerHours + ":" + informedTimerMinutes + ":" + informedTimerSeconds, 50, 500);


    }
}