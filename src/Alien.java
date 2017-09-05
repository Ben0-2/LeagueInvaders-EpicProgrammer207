import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	
   
    Alien(int x, int y, int width, int height){
    	super(x, y, width, height);
    	
    }
    void draw(Graphics g) {
    	
    	g.drawImage(GamePanel.alienImg, x, y, width, height, null);
    }
    void update() {
    	super.update();
    	//collisionBox.setBounds(x, y, width, height);
    	y+=5;
       if(y>800){
    	   isAlive = false;
       }
       
    }
}
