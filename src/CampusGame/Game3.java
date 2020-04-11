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
public class Game3 extends JPanel implements ActionListener {
    //This is a sketch of a Pac-Man like game
    //To finish -- game pieces will move
    //add bomb class to have bombs drop from top of the screen that user will need to avoid

    JButton b1, b2; //g1, g2, g3, g4, g5;
    GamePieces gp1, gp2, gp3, gp4, gp5;
    Bomb bomb1, bomb2, bomb3;
    private Character character;
    public Timer timer, tim;
    boolean gameOn = false;
    private int delay = 10, delay2 = 0;
    protected int score = 0;
    private int limit = 0;
    private int i = 20;

    public Game3()
    {
        super();
        addGameComponents();
    }

    private void addGameComponents()
    {
        setLayout(null);
        setBackground(Color.BLACK);
        b1 = new JButton("Return to Main Map");
        b2 = new JButton("Game 3 Instructions");
        gp1 = new GamePieces();
        gp2 = new GamePieces();
        gp3 = new GamePieces();
        gp4 = new GamePieces();
        gp5 = new GamePieces();
        bomb1 = new Bomb(100);
        bomb2 = new Bomb(250);
        bomb3 = new Bomb(400);

        add(b1);
        add(b2);
        add(gp1);
        add(gp2);
        add(gp3);
        add(gp4);
        add(gp5);
        add(bomb1);
        add(bomb2);
        add(bomb3);

        b1.setBounds(new Rectangle(600, 500, 150, 35));
        b2.setBounds(new Rectangle(600, 80, 175, 35));

        addKeyListener(new TAdapter());
        setFocusable(true);

        character = new Character();

        timer = new Timer(delay, this);
        timer.start();

        delay2 = 1000;
        tim = new Timer(delay2, this);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
        requestFocusInWindow();

        Font f1 = new Font("Gothic", Font.BOLD, 16);
        g.setFont(f1);
        g.setColor(Color.WHITE);

        g.drawString("score = " + score, 475, 20);
        g.drawString("Press Enter to begin game", 475, 35);
        g.drawString("Eat as many white dots to score points.", 475, 50);
        g.drawString("Watch out for the Red Bombs!", 475, 65);
    }

    private void doDrawing(Graphics g)
    {

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(character.getImage(), character.getX(),
                character.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();

        if (obj == tim)
        {
            i = i - 1;
            gp1.setGamePieces();
            gp2.setGamePieces();
            gp3.setGamePieces();
            gp4.setGamePieces();
            gp5.setGamePieces();
            bomb1.createBomb();
            bomb2.createBomb();
            bomb3.createBomb();
        }

        if (i == limit)
        {
            tim.stop();
            gameOn = false;
            b2.setText("Game Over --- Score " + score);
        }
        step();
    }

    private void step()
    {
        character.move();
        checkCollisions();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e)
        {
            character.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            character.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ENTER)
            {
                gameOn = true;
                tim.start();
                
            }
        }
    }

    public void checkCollisions()
    {

        Rectangle rc = character.getBounds();
        Rectangle r1 = gp1.getBounds();
        Rectangle r2 = gp2.getBounds();
        Rectangle r3 = gp3.getBounds();
        Rectangle r4 = gp4.getBounds();
        Rectangle r5 = gp5.getBounds();
        Rectangle r6 = bomb1.getBounds();
        Rectangle r7 = bomb2.getBounds();
        Rectangle r8 = bomb3.getBounds();

        if (rc.intersects(r1))
        {
            remove(gp1);
            gp1.setBounds(0, 0, 0, 0);
            score = score + 1;

        }
        if (rc.intersects(r2))
        {
            remove(gp2);
            gp2.setBounds(0, 0, 0, 0);
            score = score + 1;
        }
        if (rc.intersects(r3))
        {
            remove(gp3);
            gp3.setBounds(0, 0, 0, 0); 
            score = score + 1;
        }
        if (rc.intersects(r4))
        {   
            remove(gp4);
            gp4.setBounds(0, 0, 0, 0);
            score = score + 1;
        }
        if (rc.intersects(r5))
        {
            gp5.setBounds(0, 0, 0, 0);
            remove(gp5);
            score = score + 1;
        }
        if (rc.intersects(r6))
        {
            bomb1.Y = 0;
            bomb1.createBomb();
            score = score - 2;
        }
        if (rc.intersects(r7))
        {
            bomb2.Y = 0;
            bomb2.createBomb();
            score = score - 2;
        }
        if (rc.intersects(r8))
        {
            bomb3.Y = 0;
            bomb3.createBomb();
            score = score - 2;
        }
    }
}
