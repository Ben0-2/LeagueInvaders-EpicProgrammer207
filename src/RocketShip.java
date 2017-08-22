import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject{
int x;
int y;
int speed = 15;
int width;
int height;
RocketShip(int x, int y, int width, int height){
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
}

void draw(Graphics g) {
	
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);

}
void update() {
	
}
}
