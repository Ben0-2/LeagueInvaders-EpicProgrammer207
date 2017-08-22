import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	int x;
	int y;
	int width;
	int height;
    boolean isAlive = true;
    Alien(int x, int y, int width, int height){
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    }
    void draw(Graphics g) {
    	
    	g.setColor(Color.YELLOW);
    	g.fillRect(x, y, width, height);

    }
    void update() {
    	y+=1;
    }
}
