package CampusGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JRadioButton;

public class Game2 extends JPanel implements ActionListener {
    
    JButton b1, b2, b3, b4, b5, b6, b7;
    JRadioButton b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22;
    int score = 0;
    int count = 60;
    int delay = 1000;
    boolean Sclicked, Pclicked, Vclicked = false;
    String StartGame = "Please Select One of the Question Categories Below!";
    Timer timer1;
    XML_240 x2;
    public Game2()
    {
        super();
        //Frame Layout and Background
        setLayout(null);
        setBackground(Color.WHITE);
        
        Font f1 = new Font("Bookman", Font.BOLD, 16);
        Font f2 = new Font("Bookman", Font.BOLD, 12);
        //JButton 1 (Quit)
        b1 = new JButton("Quit");
        b1.setBounds(10,250, 150, 40); 
        b1.setFont(f1);
        add(b1);
        //JButton 2 (Play)
        b2 = new JButton("Play");
        b2.setBounds(10, 150, 150, 40); 
        b2.setFont(f1);
        b2.addActionListener(this);
        add(b2);
        //JButton 3 (Instructions)
        b3 = new JButton("Instructions");
        b3.setBounds(10,200, 150, 40); 
        b3.setFont(f1);
        b3.addActionListener(this);
        add(b3);
        //JButton 4 (Sports Theme)
        b4 = new JButton("Penn State Football");
        b4.setBounds(250,150, 150, 40); 
        b4.setFont(f2);
        b4.addActionListener(this);
        //JButton 5 (Pennsylvania Theme)
        b5 = new JButton("Pennsylvania");
        b5.setBounds(250,200, 150, 40); 
        b5.setFont(f2);
        b5.addActionListener(this);
        //JButton 6 (Video Games Theme)
        b6 = new JButton("Video Games");
        b6.setBounds(250,250, 150, 40); 
        b6.setFont(f2);
        b6.addActionListener(this);
        //JButton 7 (Question Representation Button)
        b7 = new JButton();
        b7.setBounds(165,150, 150, 40); 
        b7.setFont(f2);
        b7.addActionListener(this);
        //JRadioButton 2 (Question Answer Choice A, Question 1)
        b8 = new JRadioButton();
        b8.setBounds(165,150, 150, 40); 
        b8.setFont(f2);
        b8.addActionListener(this);
        //JRadioButton 3 (Question Answer Choice B, Question 1)
        b9 = new JRadioButton();
        b9.setBounds(165,200, 150, 40); 
        b9.setFont(f2);
        b9.addActionListener(this);
        //JRadioButton 4 (Question Answer Choice C, Question 2)
        b10 = new JRadioButton();
        b10.setBounds(165,250, 150, 40); 
        b10.setFont(f2);
        b10.addActionListener(this);
        //JRadioButton 5 (Question Answer Choice A, Question 2)
        b11 = new JRadioButton();
        b11.setBounds(165,150, 150, 40); 
        b11.setFont(f2);
        b11.addActionListener(this);
        //JRadioButton 6 (Question Answer Choice B, Question 2)
        b12 = new JRadioButton();
        b12.setBounds(165,200, 150, 40); 
        b12.setFont(f2);
        b12.addActionListener(this);
        //JRadioButton 6 (Question Answer Choice C, Question 3)
        b13 = new JRadioButton();
        b13.setBounds(165,250, 150, 40); 
        b13.setFont(f2);
        b13.addActionListener(this);
        //JRadioButton 6 (Question Answer Choice A, Question 3)
        b14 = new JRadioButton();
        b14.setBounds(165,150, 150, 40); 
        b14.setFont(f2);
        b14.addActionListener(this);
        //JRadioButton 6 (Question Answer Choice B, Question 3)
        b15 = new JRadioButton();
        b15.setBounds(165,200, 150, 40);
        b15.setFont(f2);
        b15.addActionListener(this);
        //JRadioButton 6 (Question Answer Choice C, Question 4)
        b16 = new JRadioButton();
        b16.setBounds(165,250, 150, 40); 
        b16.setFont(f2);
        b16.addActionListener(this);
        //JRadioButton 6 (Question Answer Choice A, Question 4)
        b17 = new JRadioButton();
        b17.setBounds(165,150, 150, 40); 
        b17.setFont(f2);
        b17.addActionListener(this);
        //JRadioButton 6 (Question Answer Choice B, Question 4)
        b18 = new JRadioButton();
        b18.setBounds(165,200, 150, 40);
        b18.setFont(f2);
        b18.addActionListener(this);
        //JRadioButton 6 (Question Answer Choice C, Question 5)
        b19 = new JRadioButton();
        b19.setBounds(165,250, 150, 40);
        b19.setFont(f2);
        b19.addActionListener(this);
        //JRadioButton 6 (Question Answer Choice A, Question 5)
        b20 = new JRadioButton();
        b20.setBounds(165,150, 150, 40); 
        b20.setFont(f2);
        b20.addActionListener(this);
        //JRadioButton 3 (Question Answer Choice B, Question 5)
        b21 = new JRadioButton();
        b21.setBounds(165,200, 150, 40);
        b21.setFont(f2);
        b21.addActionListener(this);
        //JRadioButton 6 (Question Answer Choice C, Question 5)
        b22 = new JRadioButton();
        b22.setBounds(165,250, 150, 40);
        b22.setFont(f2);
        b22.addActionListener(this);
        //Timer
        timer1 = new Timer(delay, this);
         x2 = new XML_240();//Creates XML_240 object to read and write XML files
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        
        //Check if timer ticks while count is not equal to 0
        if (obj == timer1 && count != 0) {
            count--;}//Reduce count if timer ticks
        //Check if b3 (Instructions) button is clicked
        if (obj == b3) {}
        //Check if b2 (Play) button is clicked
        if (obj == b2) {
        remove(b1);
        remove(b2);
        remove(b3);
        add(b4);
        add(b5);
        add(b6);
        validate(); 
        repaint(); }
        //Check if b4 (Sports Theme) button is clicked
        if (obj == b4) {
            timer1.start();
            Sclicked = true;
            remove(b4);
            remove(b5);
            remove(b6);
            x2.openReaderXML("Game2SportsQuestionBank.xml");
            b7.setBackground(Color.WHITE);
            b7.setBorderPainted(false);
            b7.setBounds(150,100, 370, 40);
            b7.setText((String) x2.ReadObject());
            b8.setText((String) x2.ReadObject());
            b9.setText((String) x2.ReadObject());
            b10.setText((String) x2.ReadObject());
            add(b7);
            add(b8);
            add(b9);
            add(b10);
            validate();
            repaint();}
            //Correct Answer (B) Sports Question 1
            if(obj == b9 && Sclicked == true){
                Font f3 = new Font("Bookman", Font.BOLD, 10);
                score++;
                b7.setBounds(10,100, 600, 40);
                b7.setFont(f3);
                b7.setText((String) x2.ReadObject());
                b11.setText((String) x2.ReadObject());
                b12.setText((String) x2.ReadObject());
                b13.setText((String) x2.ReadObject());
                add(b11);
                add(b12);
                add(b13);
                remove(b8);
                remove(b9);
                remove(b10);
                validate();
                repaint();}
            //Wrong Answer (A) Sports Question 1 
            if(obj == b8 && Sclicked == true){
                Font f3 = new Font("Bookman", Font.BOLD, 10);
                b7.setBounds(10,100, 600, 40);
                b7.setFont(f3);
                b7.setText((String) x2.ReadObject());
                b11.setText((String) x2.ReadObject());
                b12.setText((String) x2.ReadObject());
                b13.setText((String) x2.ReadObject());
                add(b11);
                add(b12);
                add(b13);
                remove(b8);
                remove(b9);
                remove(b10);
                validate();
                repaint();}
            //Wrong Answer (C) Sports Question 1
            if(obj == b10 && Sclicked == true){
                Font f3 = new Font("Bookman", Font.BOLD, 10);
                b7.setFont(f3);
                b7.setBounds(10,100, 600, 40);
                b7.setText((String) x2.ReadObject());
                b11.setText((String) x2.ReadObject());
                b12.setText((String) x2.ReadObject());
                b13.setText((String) x2.ReadObject());
                add(b11);
                add(b12);
                add(b13);
                remove(b8);
                remove(b9);
                remove(b10);
                validate();
                repaint();}
            //Correct Answer (B) Sports Question 2
             if(obj == b12 && Sclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b14.setText((String) x2.ReadObject());
                b15.setText((String) x2.ReadObject());
                add(b14);
                add(b15);
                remove(b11);
                remove(b12);
                remove(b13);
                validate();
                repaint();}
            //Wrong Answer (A) Sports Question 2
            if(obj == b11 && Sclicked == true){
                b7.setText((String) x2.ReadObject());
                b14.setText((String) x2.ReadObject());
                b15.setText((String) x2.ReadObject());
                add(b14);
                add(b15);
                remove(b11);
                remove(b12);
                remove(b13);
                validate();
                repaint();}
            //Wrong Answer (C) Sports Question 2
            if(obj == b13 && Sclicked == true){
                b7.setText((String) x2.ReadObject());
                b14.setText((String) x2.ReadObject());
                b15.setText((String) x2.ReadObject());
                add(b14);
                add(b15);
                remove(b11);
                remove(b12);
                remove(b13);
                validate();
                repaint();}
            //Correct Answer (B) Sports Question 3
             if(obj == b15 && Sclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b16.setText((String) x2.ReadObject());
                b17.setText((String) x2.ReadObject());
                b18.setText((String) x2.ReadObject());
                add(b16);
                add(b17);
                add(b18);
                remove(b14);
                remove(b15);
                validate();
                repaint();}
             //Wrong Answer (A) Sports Question 3
            if(obj == b14 && Sclicked == true){
                b7.setText((String) x2.ReadObject());
                b16.setText((String) x2.ReadObject());
                b17.setText((String) x2.ReadObject());
                b18.setText((String) x2.ReadObject());
                add(b16);
                add(b17);
                add(b18);
                remove(b14);
                remove(b15);
                validate();
                repaint();}
             //Correct Answer (C) Sports Question 4
             if(obj == b18 && Sclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b19.setText((String) x2.ReadObject());
                b20.setText((String) x2.ReadObject());
                b21.setText((String) x2.ReadObject());
                add(b19);
                add(b20);
                add(b21);
                remove(b16);
                remove(b17);
                remove(b18);
                validate();
                repaint();}
             //Wrong Answer (A) Sports Question 4
            if(obj == b16 && Sclicked == true){
                b7.setText((String) x2.ReadObject());
                b19.setText((String) x2.ReadObject());
                b20.setText((String) x2.ReadObject());
                b21.setText((String) x2.ReadObject());
                add(b19);
                add(b20);
                add(b21);
                remove(b16);
                remove(b17);
                remove(b18);
                validate();
                repaint();}
              //Wrong Answer (B) Sports Question 4
            if(obj == b17 && Sclicked == true){
                b7.setText((String) x2.ReadObject());
                b19.setText((String) x2.ReadObject());
                b20.setText((String) x2.ReadObject());
                b21.setText((String) x2.ReadObject());
                add(b19);
                add(b20);
                add(b21);
                remove(b16);
                remove(b17);
                remove(b18);
                validate();
                repaint(); }
             //Correct Answer (A) Sports Question 5
             if(obj == b19 && Sclicked == true){
                score++;
                remove(b19);
                remove(b20);
                remove(b21);
                b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
                b7.setBounds(250, 150, 250, 150); 
                b1.setBounds(10,250, 150, 40);
                add(b1);
                x2.closeReaderXML();
                validate();
                repaint(); 
                }
             //Wrong Answer (B) Sports Question 5
            if(obj == b20 && Sclicked == true){
                remove(b19);
                remove(b20);
                remove(b21);
                b7.setBounds(250, 150, 250, 150); 
                b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
                b1.setBounds(10,250, 150, 40);
                add(b1);
                x2.closeReaderXML();
                validate();
                repaint();
            }
            //Wrong Answer (C) Sports Question 5
            if(obj == b21 && Sclicked == true){
                remove(b19);
                remove(b20);
                remove(b21);
                b7.setBounds(250, 150, 250, 150); 
                b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!" );
                b1.setBounds(10,250, 150, 40);
                add(b1);
                x2.closeReaderXML();
                validate();
                repaint();
            }
        //Check if b5 (PA Theme) button is clicked
        if (obj == b5) {
         timer1.start();
            Pclicked = true;
            x2.openReaderXML("Game2PAQuestionBank.xml");
            b7.setBackground(Color.WHITE);
            b7.setBorderPainted(false);
            b7.setBounds(150,100, 370, 40);
            b7.setText((String) x2.ReadObject());
            b8.setText((String) x2.ReadObject());
            b9.setText((String) x2.ReadObject());
            b10.setText((String) x2.ReadObject());
            remove(b4);
            remove(b5);
            remove(b6);
            add(b7);
            add(b8);
            add(b9);
            add(b10);
            validate();
            repaint();} 
            //Correct Answer (A) Pennsylvania Question 1
            if(obj == b8 && Pclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b11.setText((String) x2.ReadObject());
                b12.setText((String) x2.ReadObject());
                b13.setText((String) x2.ReadObject());
                add(b11);
                add(b12);
                add(b13);
                remove(b8);
                remove(b9);
                remove(b10);
                validate();
                repaint();}
            //Wrong Answer (B) Pennsylvania Question 1
            if(obj == b9 && Pclicked == true){
                b7.setText((String) x2.ReadObject());
                b11.setText((String) x2.ReadObject());
                b12.setText((String) x2.ReadObject());
                b13.setText((String) x2.ReadObject());
                add(b11);
                add(b12);
                add(b13);
                remove(b8);
                remove(b9);
                remove(b10);
                validate();
                repaint();}
            //Wrong Answer (C) Pennsylvania Question 1
             if(obj == b10 && Pclicked == true){
                b7.setText((String) x2.ReadObject());
                b11.setText((String) x2.ReadObject());
                b12.setText((String) x2.ReadObject());
                b13.setText((String) x2.ReadObject());
                add(b11);
                add(b12);
                add(b13);
                remove(b8);
                remove(b9);
                remove(b10);
                validate();
                repaint();}
             //Correct Answer (C) Pennsylvania Question 2
            if(obj == b13 && Pclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b14.setText((String) x2.ReadObject());
                b15.setText((String) x2.ReadObject());
                b16.setText((String) x2.ReadObject());
                add(b14);
                add(b15);
                add(b16);
                remove(b11);
                remove(b12);
                remove(b13);
                validate();
                repaint();}
            //Wrong Answer (A) Pennsylvania Question 2
             if(obj == b11 && Pclicked == true){
                b7.setText((String) x2.ReadObject());
                b14.setText((String) x2.ReadObject());
                b15.setText((String) x2.ReadObject());
                b16.setText((String) x2.ReadObject());
                add(b14);
                add(b15);
                add(b16);
                remove(b11);
                remove(b12);
                remove(b13);
                validate();
                repaint();}
             //Wrong Answer (B) Pennsylvania Question 2
            if(obj == b12 && Pclicked == true){
                b7.setText((String) x2.ReadObject());
                b14.setText((String) x2.ReadObject());
                b15.setText((String) x2.ReadObject());
                b16.setText((String) x2.ReadObject());
                add(b14);
                add(b15);
                add(b16);
                remove(b11);
                remove(b12);
                remove(b13);
                validate();
                repaint();}
             //Correct Answer (B) Pennsylvania Question 3
             if(obj == b15 && Pclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b17.setText((String) x2.ReadObject());
                b18.setText((String) x2.ReadObject());
                b19.setText((String) x2.ReadObject());
                add(b17);
                add(b18);
                add(b19);
                remove(b14);
                remove(b15);
                remove(b16);
                validate();
                repaint();}
            //Wrong Answer (A) Pennsylvania Question 3
            if(obj == b14 && Pclicked == true){
                b7.setText((String) x2.ReadObject());
                b17.setText((String) x2.ReadObject());
                b18.setText((String) x2.ReadObject());
                b19.setText((String) x2.ReadObject());
                add(b17);
                add(b18);
                add(b19);
                remove(b14);
                remove(b15);
                remove(b16);
                validate();
                repaint();}
            //Wrong Answer (C) Pennsylvania Question 3
            if(obj == b16 && Pclicked == true){
                b7.setText((String) x2.ReadObject());
                b17.setText((String) x2.ReadObject());
                b18.setText((String) x2.ReadObject());
                b19.setText((String) x2.ReadObject());
                add(b17);
                add(b18);
                add(b19);
                remove(b14);
                remove(b15);
                remove(b16);
                validate();
                repaint();}
             //Correct Answer (C) Pennsylvania Question 4
             if(obj == b19 && Pclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b20.setText((String) x2.ReadObject());
                b21.setText((String) x2.ReadObject());
                b22.setText((String) x2.ReadObject());
                add(b20);
                add(b21);
                add(b22);
                remove(b17);
                remove(b18);
                remove(b19);
                validate();
                repaint();}
            //Wrong Answer (A) Pennsylvania Question 4
            if(obj == b17 && Pclicked == true){
                b7.setText((String) x2.ReadObject());
                b20.setText((String) x2.ReadObject());
                b21.setText((String) x2.ReadObject());
                b22.setText((String) x2.ReadObject());
                add(b20);
                add(b21);
                add(b22);
                remove(b17);
                remove(b18);
                remove(b19);
                validate();
                repaint();}
         //Wrong Answer (B) Pennsylvania Question 4
            if(obj == b18 && Pclicked == true){
                b7.setText((String) x2.ReadObject());
                b20.setText((String) x2.ReadObject());
                b21.setText((String) x2.ReadObject());
                b22.setText((String) x2.ReadObject());
                add(b20);
                add(b21);
                add(b22);
                remove(b17);
                remove(b18);
                remove(b19);
                validate();
                repaint();}
            //Correct Answer (C) Pennsylvania Question 5
            if(obj == b22 && Sclicked == true){
                score++;
                remove(b20);
                remove(b21);
                remove(b22);
                b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
                b7.setBounds(200, 150, 300, 100); 
                b1.setBounds(10,250, 150, 40);
                add(b1);
                validate();
                repaint();
            x2.closeReaderXML();}
            //Wrong Answer (A) Pennsylvania Question 5
            if(obj == b20 && Sclicked == true){
                remove(b20);
                remove(b21);
                remove(b22);
                b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
                b7.setBounds(200, 150, 300, 100); 
                b1.setBounds(10,250, 150, 40);
                add(b1);
                validate();
                repaint();
            x2.closeReaderXML();}
            //Wrong Answer (B) Pennsylvania Question 5
            if(obj == b21 && Sclicked == true){
                remove(b20);
                remove(b21);
                remove(b22);
                b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
                b7.setBounds(200, 150, 300, 100); 
                b1.setBounds(10,250, 150, 40);
                add(b1);
                validate();
                repaint();
            x2.closeReaderXML();}
        //Check if b6 (Video Games Theme) button is clicked
        if (obj == b6) {
         timer1.start();
         Vclicked = true;
            remove(b4);
            remove(b5);
            remove(b6);
            validate();
            repaint();
            x2.openReaderXML("Game2VideoGameQuestionBank.xml");
            b7.setBackground(Color.WHITE);
            b7.setBorderPainted(false);
            b7.setBounds(150,100, 370, 40);
            b7.setText((String) x2.ReadObject());
            b8.setText((String) x2.ReadObject());
            b9.setText((String) x2.ReadObject());
            b10.setText((String) x2.ReadObject());
            remove(b4);
            remove(b5);
            remove(b6);
            add(b7);
            add(b8);
            add(b9);
            add(b10);
            validate();
            repaint();} 
            //Correct Answer (B) Video Games Question 1
            if(obj == b9 && Vclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b11.setText((String) x2.ReadObject());
                b12.setText((String) x2.ReadObject());
                b13.setText((String) x2.ReadObject());
                add(b11);
                add(b12);
                add(b13);
                remove(b8);
                remove(b9);
                remove(b10);
                validate();
                repaint();}
            //Wrong Answer (A) Video Games Question 1
            if(obj == b8 && Vclicked == true){
                b7.setText((String) x2.ReadObject());
                b11.setText((String) x2.ReadObject());
                b12.setText((String) x2.ReadObject());
                b13.setText((String) x2.ReadObject());
                add(b11);
                add(b12);
                add(b13);
                remove(b8);
                remove(b9);
                remove(b10);
                validate();
                repaint();}
            //Wrong Answer (C) Video Games Question 1
            if(obj == b10 && Vclicked == true){
                b7.setText((String) x2.ReadObject());
                b11.setText((String) x2.ReadObject());
                b12.setText((String) x2.ReadObject());
                b13.setText((String) x2.ReadObject());
                add(b11);
                add(b12);
                add(b13);
                remove(b8);
                remove(b9);
                remove(b10);
                validate();
                repaint();}
            //Correct Answer (C) Video Games Question 2
            if(obj == b13 && Vclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b14.setText((String) x2.ReadObject());
                b15.setText((String) x2.ReadObject());
                b16.setText((String) x2.ReadObject());
                add(b14);
                add(b15);
                add(b16);
                remove(b11);
                remove(b12);
                remove(b13);
                validate();
                repaint();}
            //Wrong Answer (A) Video Games Question 2
            if(obj == b12 && Vclicked == true){
                b7.setText((String) x2.ReadObject());
                b14.setText((String) x2.ReadObject());
                b15.setText((String) x2.ReadObject());
                b16.setText((String) x2.ReadObject());
                add(b14);
                add(b15);
                add(b16);
                remove(b11);
                remove(b12);
                remove(b13);
                validate();
                repaint();}
            //Wrong Answer (B) Video Games Question 2
            if(obj == b11 && Vclicked == true){
                b7.setText((String) x2.ReadObject());
                b14.setText((String) x2.ReadObject());
                b15.setText((String) x2.ReadObject());
                b16.setText((String) x2.ReadObject());
                add(b14);
                add(b15);
                add(b16);
                remove(b11);
                remove(b12);
                remove(b13);
                validate();
                repaint();}
              //Correct Answer (B) Video Games Question 3
            if(obj == b15 && Vclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b17.setText((String) x2.ReadObject());
                b18.setText((String) x2.ReadObject());
                add(b17);
                add(b18);
                remove(b14);
                remove(b15);
                remove(b16);
                validate();
                repaint();}
             //Wrong Answer (A) Video Games Question 3
            if(obj == b14 && Vclicked == true){
                b7.setText((String) x2.ReadObject());
                b17.setText((String) x2.ReadObject());
                b18.setText((String) x2.ReadObject());
                add(b17);
                add(b18);
                remove(b14);
                remove(b15);
                remove(b16);
                validate();
                repaint();}
              //Wrong Answer (C) Video Games Question 3
            if(obj == b16 && Vclicked == true){
                b7.setText((String) x2.ReadObject());
                b17.setText((String) x2.ReadObject());
                b18.setText((String) x2.ReadObject());
                add(b17);
                add(b18);
                remove(b14);
                remove(b15);
                remove(b16);
                validate();
                repaint();}
              //Correct Answer (A) Video Games Question 4
            if(obj == b17 && Vclicked == true){
                score++;
                b7.setText((String) x2.ReadObject());
                b19.setText((String) x2.ReadObject());
                b20.setText((String) x2.ReadObject());
                b21.setText((String) x2.ReadObject());
                add(b19);
                add(b20);
                add(b21);
                remove(b17);
                remove(b18);
                validate();
                repaint();}
             //Wrong Answer (B) Video Games Question 4
            if(obj == b18 && Vclicked == true){
                b7.setText((String) x2.ReadObject());
                b19.setText((String) x2.ReadObject());
                b20.setText((String) x2.ReadObject());
                b21.setText((String) x2.ReadObject());
                add(b19);
                add(b20);
                add(b21);
                remove(b17);
                remove(b18);
                validate();
                repaint();}
             //Correct Answer (C) Video Games Question 5
            if(obj == b21 && Vclicked == true){
                score++;
                remove(b19);
                remove(b20);
                remove(b21);
                b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
                b7.setBounds(250, 150, 200, 100); 
                b1.setBounds(10,250, 150, 40);
                add(b1);
                validate();
                repaint();
            x2.closeReaderXML();}
            //Wrong Answer (A) Video Games Question 5
            if(obj == b19 && Vclicked == true){
                remove(b19);
                remove(b20);
                remove(b21);
                b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
                b7.setBounds(250, 150, 200, 100); 
                b1.setBounds(10,250, 150, 40);
                add(b1);
                validate();
                repaint();
            x2.closeReaderXML();}
            //Wrong Answer (B) Video Games Question 5
            if(obj == b20 && Vclicked == true){
                remove(b19);
                remove(b20);
                remove(b21);
                b7.setText("-----GAME OVER-----" + " You Scored: " + score + " points!");
                b7.setBounds(250, 150, 200, 100); 
                b1.setBounds(10,250, 150, 40);
                add(b1);
                validate();
                repaint();
            x2.closeReaderXML();}}
      public void paintComponent(Graphics g){
        super.paintComponent(g);
        Font f2 = new Font("Serif", Font.BOLD, 16);
        g.setFont(f2);
        g.setColor(Color.BLACK);  
    }  }


