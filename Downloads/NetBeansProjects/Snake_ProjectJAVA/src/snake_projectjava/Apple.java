/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_projectjava;

import java.util.Random;
import java.util.TimerTask;

/**
 *
 * @author ishwaryadav
 */
public class Apple extends TimerTask{
    private int x;
    private int y;
    private Snake snake;
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Apple(Snake s) {
        snake = s;
    }
    public Apple() {
       x = 25 * new Random().nextInt(20);
       y = 25 * new Random().nextInt(20);
    }
    // new apple
    public void run() {
        if(snake.getApple() == null) {
            snake.setApple(new Apple());
        }
    }
}
