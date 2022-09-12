/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_projectjava;

/**
 *
 * @author ishwaryadav
 */
public class Rectangle {
    public static int width = 25;
    public static int height = 25;
    Snake s;
    int x;
    int y;
      
    public Rectangle(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
    
    //collision detection
    int snake_x;
    public boolean intersects(Rectangle r2) {
        return this.x == r2.getX() && this.y == r2.getY(); 
    }
    // methods to access current positions
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX2(int value) {
       x = value; 
    }
    public void setY2(int value) {
       y = value;
    }
    // methods to set and move rectangle objects
    public void setX(int increment) {
        this.x += increment;
    }
    public void setY(int increment) {
        this.y += increment;
    }
    
}
