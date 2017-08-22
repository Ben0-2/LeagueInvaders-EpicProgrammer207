import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
int x;
int y;
int width;
int speed = 10;
int height;
boolean isAlive = true;
Projectile(int x, int y, int width, int height){
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
}
void draw(Graphics g) {
	
	g.setColor(Color.RED);
	g.fillRect(x, y, width, height);

}
void update() {
	y-=speed;
	if(y<=0) {
		isAlive = false;
	}
}
}
