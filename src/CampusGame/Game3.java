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
import java.awt.Image;
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

    JButton b1, b2;
    GamePieces gp1, gp2, gp3, gp4, gp5;
    Bomb bomb1, bomb2, bomb3, bomb4, bomb5, bomb6, bomb7, bomb8;
    private Character character;
    private Student student;
    private NittanyLion nitannyLion;
    private Professor professor;
    public Timer timer, tim;
    boolean inst, rules, gameOn = false, test = true, isTheme1Selected = false, isTheme2Selected = false, isTheme3Selected = false, isMascotSelected = false, isStudentSelected = false, isProfessorSelected = false;
    private int delay = 10, delay2 = 0;
    protected int score = 0;
    private int limit = 0;
    private int i = 30;
    private final Image defaultBackground, computersBackground, sportsBackground;

    public Game3()
    {
        super();
        addGameComponents();

        defaultBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/pennStateBackground.JPG"));
        computersBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/computersBackground.JPG"));
        sportsBackground = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/resources/sportsBackground.JPG"));
    }

    private void addGameComponents()
    {
        setLayout(null);
        setBackground(Color.BLACK);
        b1 = new JButton("Return to Main Map");
        b2 = new JButton();
        gp1 = new GamePieces();
        gp2 = new GamePieces();
        gp3 = new GamePieces();
        gp4 = new GamePieces();
        gp5 = new GamePieces();
        bomb1 = new Bomb(125);
        bomb2 = new Bomb(210);
        bomb3 = new Bomb(295);
        bomb4 = new Bomb(380);
        bomb5 = new Bomb(465);
        bomb6 = new Bomb(550);
        bomb7 = new Bomb(635);
        bomb8 = new Bomb(720);

        b1.setBounds(new Rectangle(600, 500, 150, 35));
        b2.setBounds(new Rectangle(600, 150, 150, 35));

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
        add(bomb4);
        add(bomb5);
        add(bomb6);
        add(bomb7);
        add(bomb8);

        b2.setVisible(false);
        addKeyListener(new TAdapter());
        setFocusable(true);

        SetUpCharacter();

        timer = new Timer(delay, this);
        timer.start();

        delay2 = 1000;
        tim = new Timer(delay2, this);
    }

    public void SetUpCharacter()
    {
        professor = new Professor();
        student = new Student();
        nitannyLion = new NittanyLion();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
        requestFocusInWindow();

        Font f1 = new Font("Gothic", Font.BOLD, 16);
        g.setFont(f1);
        g.setColor(Color.RED);
        g.drawString("score = " + score, 475, 20);
        g.drawString("Press Enter to begin game", 475, 35);
        g.drawString("Game lasts for 30 seconds", 475, 50);
        g.drawString("Use the arrow keys to move character", 475, 65);
        g.drawString("Eat as many white dots to score points", 475, 80);
        g.drawString("Watch out for the Red Bombs!", 475, 95);

    }

    private void doDrawing(Graphics g)
    {

        Graphics2D g2d = (Graphics2D) g;

        if (isTheme1Selected == true)
        {

            g.drawImage(defaultBackground, 0, 0, null);
            if (isStudentSelected == true)
            {
                g2d.drawImage(student.getImage(), student.getX(), student.getY(), this);
            } else if (isMascotSelected == true)
            {
                g2d.drawImage(nitannyLion.getImage(), nitannyLion.getX(), nitannyLion.getY(), this);
            } else if (isProfessorSelected == true)
            {
                g2d.drawImage(professor.getImage(), professor.getX(), professor.getY(), this);

            }
        } else if (isTheme2Selected == true)
        {
            g.drawImage(computersBackground, 0, 0, null);

            if (isStudentSelected == true)
            {
                g2d.drawImage(student.getImage(), student.getX(), student.getY(), this);
            } else if (isMascotSelected == true)
            {
                g2d.drawImage(nitannyLion.getImage(), nitannyLion.getX(), nitannyLion.getY(), this);
            } else if (isProfessorSelected == true)
            {
                g2d.drawImage(professor.getImage(), professor.getX(), professor.getY(), this);

            }
        } else if (isTheme3Selected == true)
        {
            g.drawImage(sportsBackground, 0, 0, null);

            if (isStudentSelected == true)
            {
                g2d.drawImage(student.getImage(), student.getX(), student.getY(), this);
            } else if (isMascotSelected == true)
            {
                g2d.drawImage(nitannyLion.getImage(), nitannyLion.getX(), nitannyLion.getY(), this);
            } else if (isProfessorSelected == true)
            {
                g2d.drawImage(professor.getImage(), professor.getX(), professor.getY(), this);

            }
        } else
        {
            g.drawImage(defaultBackground, 0, 0, null);
            g2d.drawImage(nitannyLion.getImage(), nitannyLion.getX(), nitannyLion.getY(), this);
        }
        validate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();

        if (obj == tim)
        {
            step();
            i = i - 1;
            gp1.setGamePieces();
            gp2.setGamePieces();
            gp3.setGamePieces();
            gp4.setGamePieces();
            gp5.setGamePieces();
            bomb1.createBomb();
            bomb2.createBomb();
            bomb3.createBomb();
            bomb4.createBomb();
            bomb5.createBomb();
            bomb6.createBomb();
            bomb7.createBomb();
            bomb8.createBomb();
        }

        if (i == limit)
        {
            tim.stop();
            gameOn = false;
            b1.setVisible(true);
            b2.setVisible(true);
            b2.setBounds(300, 200, 200, 50);
            b2.setText("Game Over --- Score " + score);
        }
        step();
    }

    private void step()
    {

        if (isStudentSelected == true)
        {
            student.move();
        } else if (isProfessorSelected == true)
        {
            professor.move();
        } else if (isMascotSelected == true)
        {
            nitannyLion.move();
        }
        checkCollisions();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e)
        {
            if (isStudentSelected == true)
            {
                student.keyReleased(e);
            } else if (isProfessorSelected == true)
            {
                professor.keyReleased(e);
            } else if (isMascotSelected == true)
            {
                nitannyLion.keyReleased(e);
            }
        }

        @Override
        public void keyPressed(KeyEvent e)
        {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ENTER)
            {
                gameOn = true;
                tim.start();
                b1.setVisible(false);
                b2.setVisible(false);
            }
            if (isStudentSelected == true)
            {
                student.keyPressed(e);
            } else if (isProfessorSelected == true)
            {
                professor.keyPressed(e);
            } else if (isMascotSelected == true)
            {
                nitannyLion.keyPressed(e);
            }
        }
    }

    public void checkCollisions()
    {

        Rectangle rs = student.getBounds();
        Rectangle rn = nitannyLion.getBounds();
        Rectangle rp = professor.getBounds();
        Rectangle r1 = gp1.getBounds();
        Rectangle r2 = gp2.getBounds();
        Rectangle r3 = gp3.getBounds();
        Rectangle r4 = gp4.getBounds();
        Rectangle r5 = gp5.getBounds();
        Rectangle r6 = bomb1.getBounds();
        Rectangle r7 = bomb2.getBounds();
        Rectangle r8 = bomb3.getBounds();
        Rectangle r9 = bomb4.getBounds();
        Rectangle r10 = bomb5.getBounds();
        Rectangle r11 = bomb6.getBounds();
        Rectangle r12 = bomb7.getBounds();
        Rectangle r13 = bomb7.getBounds();

        //check collisions for student
        if (rs.intersects(r1))
        {
            gp1.setGamePieces();
            score = score + 1;
        }
        if (rs.intersects(r2))
        {
            gp2.setGamePieces();
            score = score + 1;
        }
        if (rs.intersects(r3))
        {
            gp3.setGamePieces();
            score = score + 1;
        }
        if (rs.intersects(r4))
        {
            gp4.setGamePieces();
            score = score + 1;
        }
        if (rs.intersects(r5))
        {
            gp5.setGamePieces();
            score = score + 1;
        }
        if (rs.intersects(r6))
        {
            bomb1.Y = 0;
            bomb1.createBomb();
            score = score - 2;
        }
        if (rs.intersects(r7))
        {
            bomb2.Y = 0;
            bomb2.createBomb();
            score = score - 2;
        }
        if (rs.intersects(r8))
        {
            bomb3.Y = 0;
            bomb3.createBomb();
            score = score - 2;
        }
        if (rs.intersects(r9))
        {
            bomb4.Y = 0;
            bomb4.createBomb();
            score = score - 2;
        }
        if (rs.intersects(r10))
        {
            bomb5.Y = 0;
            bomb5.createBomb();
            score = score - 2;
        }
        if (rs.intersects(r11))
        {
            bomb6.Y = 0;
            bomb6.createBomb();
            score = score - 2;
        }
        if (rs.intersects(r12))
        {
            bomb7.Y = 0;
            bomb7.createBomb();
            score = score - 2;
        }
        if (rs.intersects(r13))
        {
            bomb8.Y = 0;
            bomb8.createBomb();
            score = score - 2;
        }
        //check collisions for nittanyLion
        if (rn.intersects(r1))
        {
            gp1.setGamePieces();
            score = score + 1;
        }
        if (rn.intersects(r2))
        {
            gp2.setGamePieces();
            score = score + 1;
        }
        if (rn.intersects(r3))
        {
            gp3.setGamePieces();
            score = score + 1;
        }
        if (rn.intersects(r4))
        {
            gp4.setGamePieces();
            score = score + 1;
        }
        if (rn.intersects(r5))
        {
            gp5.setGamePieces();
            score = score + 1;
        }
        if (rn.intersects(r6))
        {
            bomb1.Y = 0;
            bomb1.createBomb();
            score = score - 2;
        }
        if (rn.intersects(r7))
        {
            bomb2.Y = 0;
            bomb2.createBomb();
            score = score - 2;
        }
        if (rn.intersects(r8))
        {
            bomb3.Y = 0;
            bomb3.createBomb();
            score = score - 2;
        }
        if (rn.intersects(r9))
        {
            bomb4.Y = 0;
            bomb4.createBomb();
            score = score - 2;
        }
        if (rn.intersects(r10))
        {
            bomb5.Y = 0;
            bomb5.createBomb();
            score = score - 2;
        }
        if (rn.intersects(r11))
        {
            bomb6.Y = 0;
            bomb6.createBomb();
            score = score - 2;
        }
        if (rn.intersects(r12))
        {
            bomb7.Y = 0;
            bomb7.createBomb();
            score = score - 2;
        }
        if (rn.intersects(r13))
        {
            bomb8.Y = 0;
            bomb8.createBomb();
            score = score - 2;
        }
        //check collision for professor
        if (rp.intersects(r1))
        {
            gp1.setGamePieces();
            score = score + 1;
        }
        if (rp.intersects(r2))
        {
            gp2.setGamePieces();
            score = score + 1;
        }
        if (rp.intersects(r3))
        {
            gp3.setGamePieces();
            score = score + 1;
        }
        if (rp.intersects(r4))
        {
            gp4.setGamePieces();
            score = score + 1;
        }
        if (rp.intersects(r5))
        {
            gp5.setGamePieces();
            score = score + 1;
        }
        if (rp.intersects(r6))
        {
            bomb1.Y = 0;
            bomb1.createBomb();
            score = score - 2;
        }
        if (rp.intersects(r7))
        {
            bomb2.Y = 0;
            bomb2.createBomb();
            score = score - 2;
        }
        if (rp.intersects(r8))
        {
            bomb3.Y = 0;
            bomb3.createBomb();
            score = score - 2;
        }
        if (rp.intersects(r9))
        {
            bomb4.Y = 0;
            bomb4.createBomb();
            score = score - 2;
        }
        if (rp.intersects(r10))
        {
            bomb5.Y = 0;
            bomb5.createBomb();
            score = score - 2;
        }
        if (rp.intersects(r11))
        {
            bomb6.Y = 0;
            bomb6.createBomb();
            score = score - 2;
        }
        if (rp.intersects(r12))
        {
            bomb7.Y = 0;
            bomb7.createBomb();
            score = score - 2;
        }
        if (rp.intersects(r13))
        {
            bomb8.Y = 0;
            bomb8.createBomb();
            score = score - 2;
        }
    }
}
