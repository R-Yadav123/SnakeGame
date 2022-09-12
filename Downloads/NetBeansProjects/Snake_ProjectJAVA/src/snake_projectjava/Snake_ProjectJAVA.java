/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_projectjava;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Snake_ProjectJAVA extends JFrame implements KeyListener, ActionListener {
    Snake snake;
    private int delay = 150;
       public Snake_ProjectJAVA() {

       this.snake = new Snake(this);
       Timer t;
       t = new Timer(delay,this);
       t.start();
       java.util.Timer drawApples = new java.util.Timer();
       Apple st = new Apple(this.snake);
       drawApples.schedule(st,0,3000);
       
       add(this.snake);
       setTitle("Snake GUI Game");
       setSize(525,525);
       this.addKeyListener(this);
       setLocationRelativeTo(null);
       setVisible(true);
       setResizable(false);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
       }
       
       public void keyPressed(KeyEvent e) {
           int code = e.getKeyCode();
           if(code == KeyEvent.VK_LEFT) {
               System.out.println("left key");
               snake.setDirection("left");
           }
           if(code == KeyEvent.VK_RIGHT) {
               System.out.println("right key");
               snake.setDirection("right");
           }
           if(code == KeyEvent.VK_DOWN) {
               System.out.println("down key");
               snake.setDirection("down");
           }
           if(code == KeyEvent.VK_UP) {
               System.out.println("up key");
               snake.setDirection("up");
           }
       }
       public void actionPerformed(ActionEvent e) {
           repaint();
       }
    public static void main(String[] args) {
        EventQueue.invokeLater(Snake_ProjectJAVA::new);
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

   
   
    
}
