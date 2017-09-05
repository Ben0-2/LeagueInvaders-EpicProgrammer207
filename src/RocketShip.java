import java.awt.Color;
import java.awt.Graphics;


public class RocketShip extends GameObject{

int speed = 15;


RocketShip(int x, int y, int width, int height){
	super(x, y, width, height);

}

void draw(Graphics g) {
	
	g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

}
void update() {
	super.update();
	
}
}

