import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    Timer timer;
	JLabel label;
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
    final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	RocketShip rocketShip = new RocketShip(250, 700, 50, 50);
    ObjectManager objectManager = new ObjectManager();
	public GamePanel() {
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

		label = new JLabel("SCORE: 0");
		
		label.setBounds(100, 100, 50, 50);
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 36);
	    objectManager.addObject(rocketShip);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("What is up Jake Paulers");
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} 
			 else if (currentState == END_STATE) {
				currentState = MENU_STATE;
			}
		}
        if(e.getKeyCode()==KeyEvent.VK_LEFT) {
       	rocketShip.x-=rocketShip.speed;
        }
	    if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
	    	rocketShip.x+=rocketShip.speed;  
	    }
	    if(rocketShip.x>=500||rocketShip.x<=0) {
	    	rocketShip.x=250;
	    }
	    if(e.getKeyCode()==KeyEvent.VK_SPACE) {
	    	objectManager.addObject(new Projectile(rocketShip.x+25, rocketShip.y, 10, 10));

	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	void updateMenuState() {
		objectManager.reset();
		objectManager.setScore(0);
		 rocketShip = new RocketShip(250, 700, 50, 50);
	        objectManager.addObject(rocketShip);
	}

	void updateGameState() {
		objectManager.update();
	    objectManager.manageEnemies();
	    objectManager.checkCollision();
		
	    if(!rocketShip.isAlive){
	    	System.out.println("Rrcketsherp is derd");
	    	currentState = END_STATE;
	        
	        
	       
	        
	    }

	}

	void updateEndState() {
		
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0,0,LeagueInvaders.width,LeagueInvaders.height);
		g.setColor(Color.RED);
		// g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		
		g.drawString("League Invaders", 100, 400);

	}

	void drawGameState(Graphics g) {
g.setColor(Color.BLACK);
g.fillRect(0,0,LeagueInvaders.width,LeagueInvaders.height);
objectManager.draw(g);


	}

	void drawEndState(Graphics g) {
	g.setColor(Color.white);
		g.setColor(Color.BLACK);
		// g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.drawString("Game Over! " + "SCORE: " + Integer.toString(objectManager.getScore()), 80, 400);
		
		repaint();
	}
}
