/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_projectjava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ishwaryadav
 */
public class Snake extends JPanel{
    // r, g, b values for black
    private static final Color color = new Color(0,0,0);
    private static final int start = 100;
    private static final int speed = 25;
    Snake snake;
     public static int width = 25;
     public static int height = 25;
    
    private ArrayList<Rectangle> body;
    private String direction;
    private Snake_ProjectJAVA window;
    
    private Apple apple;
 
    public Snake(snake_projectjava.Snake_ProjectJAVA window) {
        this.window = window;
        this.body = new ArrayList<>();
        body.add(new Rectangle(start,start));
        Rectangle last = this.body.get(0);
        body.add(new Rectangle(last.getX(),last.getY()));
        Rectangle last_2 = this.body.get(1);
        body.add(new Rectangle(last_2.getX(), last_2.getY()));
        // game will start with snake moving with right arrow key
        setDirection("right");
        
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getDirection() {
        return this.direction;
    }
    public void addPart() {
        Rectangle last = this.body.get(this.body.size() - 1);
        switch(this.direction) {
            case "left": this.body.add(new Rectangle(last.getX() - width, last.getY()));
            break;
            case "right": this.body.add(new Rectangle(last.getX() + width,last.getY()));
            break;
            case "up": this.body.add(new Rectangle(last.getX(), last.getY() + width));
            break;
            case "down": this.body.add(new Rectangle(last.getX(), last.getY() - width));
            break;
            
        }
        
       
    }
    Rectangle r2;
     Rectangle r3;
     int score = 0;
     public void loop() {
      if(r3.getX() > 525) 
          r3.setX2(10);
      if(r3.getX() < 0) {
          r3.setX2(500);
      }
      if(r3.getY() < 0) {
          r3.setY2(520);
      }
      if(r3.getY() > 525) {
          r3.setY2(10);
      }
  
    
   }
    public void checkCollision() {
        r3 = this.body.get(0);
        for(int i = 1; i<this.body.size();i++) {
            r2 = this.body.get(i);
        }
        
       
        if(this.apple != null) {
            if(r3.intersects(new Rectangle(this.apple.getX(), this.apple.getY()))) {
                score+=10;
                this.apple = null;
                this.addPart();
            }
        }
        if(r3.getX() > 525 || r3.getX() <  0 || r3.getY() <  0 || r3.getY() > 525) {
           loop();
        } 
          
    }
    
    public void moveSnake() {
        ArrayList<Rectangle> newLst = new ArrayList<>();
        Rectangle first = this.body.get(0);
        Rectangle head = new Rectangle(first.getX(), first.getY());
        //**********************************
        //head.setColor(Color.ORANGE); 
        //**********************************
        switch(this.direction) {
            case "left":head.setX(-speed);
            break;
            case "right":head.setX(speed);
            break;
            case "up":head.setY(-speed);
            break;
            case "down":head.setY(speed);
            break;
        }
         
        
        newLst.add(head);
        for(int i = 1; i<this.body.size();i++) {
            Rectangle previous = this.body.get(i-1);
            Rectangle newRec = new Rectangle(previous.getX(),previous.getY());
            newLst.add(newRec);
                   
        }
       this.body = newLst;
       checkCollision();
    }
    public void drawSnake(Graphics g) {
        moveSnake();
        //moved snake = draw
        //*****************************************
      //********************************************
          Graphics2D g2d = (Graphics2D) g;
        
        if(this.apple != null) {
            g2d.setPaint(Color.red);
            g2d.drawRect(this.apple.getX(), this.apple.getY(), width, height);
            g2d.fillRect(this.apple.getX(), this.apple.getY(), width, height);
            
        }
        g2d.setPaint(Color.blue);
        for(Rectangle rec: this.body) {
            g2d.drawRect(rec.getX(), rec.getY(), width, height);
            g2d.fillRect(rec.getX(), rec.getY(), width, height);
            
        }
    }
    public void setApple(Apple apple) {
        this.apple = apple;
    }
    public Apple getApple() {
        return this.apple;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
       // if(r3.intersects(r2)) {
        g.setColor(Color.white);
        g.drawString("Your score: "+score,20,20);
          //  }
        setBackground(color);
        drawSnake(g);
    }
    

   
}
