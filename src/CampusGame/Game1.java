package CampusGame;

import java.awt.*;
import static java.awt.Color.white;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Game1 extends JPanel implements MouseListener, KeyListener, ActionListener{
    JButton gameButton1, gameButton2, returnToMainMap;
    int score = 0;
    Timer tim;
    int limit = 0;
    int delay = 0;
    int i = 60;
    int AButtonSize = 100;
    int BButtonSize = 50;
    int CButtonSize = 100;
    int DButtonSize = 50;
    boolean gameStart = false, istheme1Selected = false, istheme2Selected = false, istheme3Selected = false;
    String scoreToString;
    private Image theme1Background, theme2Background, theme3Background;
    
    public Game1(){
        super();
        setBackground(Color.blue);
        setLayout(null);
        gameButton1 = new JButton("click me!");
        add(gameButton1);
        gameButton1.setBackground(white);
        gameButton1.setBounds(new Rectangle (100, 450, AButtonSize,BButtonSize));
        gameButton1.addActionListener(this);
        gameButton1.addMouseListener(this);
        gameButton1.setFocusable(false);
        gameButton2 = new JButton("click me!");
        add(gameButton2);
        gameButton2.setBackground(white);
        gameButton2.setBounds(new Rectangle(100, 450, AButtonSize,DButtonSize));
        gameButton2.addActionListener(this);
        gameButton2.addMouseListener(this);
        gameButton2.setFocusable(false);
        returnToMainMap = new JButton();
        add(returnToMainMap);
        returnToMainMap.setVisible(false);
        setFocusable(true);
        addKeyListener(this);
        delay = 1000;
        tim = new Timer(delay, this);
        
        theme1Background = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/pennStateBackground.JPG"));
        theme2Background = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/computersBackground.JPG"));
        theme3Background = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/sportsBackground.JPG"));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Font f1 = new Font("Serif", Font.BOLD, 20);
        g.setFont(f1);
        g.setColor(Color.red);
        doDrawing(g);
        g.drawString("Game 1", 25, 25);
        g.drawString("Score = " + score, 10, 550);
        g.drawString("Press the ENTER key to to begin", 25, 50);
        g.drawString("You have 60 seconds to click the button as many times as possible", 25, 75);
        
    }
    
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        if (istheme1Selected == true) {
            g.drawImage(theme1Background, 0, 0, null);
            g.drawString("Game 1", 25, 25);
        g.drawString("Score = " + score, 10, 550);
        } else if (istheme2Selected == true) {
            g.drawImage(theme2Background, 0, 0, null);
            g.drawString("Game 1", 25, 25);
        g.drawString("Score = " + score, 10, 550);
        } else if (istheme3Selected == true) {
            g.drawImage(theme3Background, 0, 0, null);
            g.drawString("Game 1", 25, 25);
        g.drawString("Score = " + score, 10, 550);
        } else {
            g.drawImage(theme1Background, 0, 0, null);
           g.drawString("Game 1", 25, 25);
        g.drawString("Score = " + score, 10, 550);
        }
        validate();
        repaint();

    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    
    @Override
    public void mousePressed(MouseEvent me) {
        if (gameStart == true)
        {
            score = score + 1;
            
            CButtonSize = CButtonSize - 2;
            DButtonSize = DButtonSize - 1;
            AButtonSize = AButtonSize - 2;
            BButtonSize = BButtonSize - 1;
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }
    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        int k = ke.getKeyCode();
        if (k == ke.VK_ENTER){
            gameStart = true;
            tim.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
         Object obj = ae.getSource();
         if (obj == tim){
             delay = delay - 10;
             tim.setDelay(delay);
             i = i - 1;
             if (i <= 0){
                 gameButton1.setBounds(new Rectangle(250, 150, 250, 150));
                 gameButton1.setText("Final Score: " + score);
                 gameButton2.setVisible(false);
                 returnToMainMap.setVisible(true);
                 returnToMainMap.setBounds(new Rectangle(275, 310, 200, 100));
                 returnToMainMap.setText("Return to Main Map");
                 repaint();
                 tim.stop();
                 gameStart = false;
                 scoreToString = Integer.toString(score);
                 System.out.println(scoreToString);
             } else {
                 double myRandomNumber = Math.random();
                 int myRandomAValue = (int) (myRandomNumber * 600.00);
                 double myRandomNumber2 = Math.random();
                 int myRandomBValue = (int) (myRandomNumber2 * 250.00);
                 gameButton1.setBounds(new Rectangle(myRandomAValue, myRandomBValue, AButtonSize, BButtonSize));
                 double myRandomNumber3 = Math.random();
                 int myRandomCValue = (int) (myRandomNumber3 * 800.00);
                 double myRandomNumber4 = Math.random();
                 int myRandomDValue = (int) (myRandomNumber4 * 500.00);
                 gameButton2.setBounds(new Rectangle(myRandomCValue, myRandomDValue, CButtonSize, DButtonSize));
             };
         }
    }
   
}

