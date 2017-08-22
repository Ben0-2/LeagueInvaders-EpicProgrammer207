import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	RocketShip rocketShip = new RocketShip(250, 700, 50, 50);
    ObjectManager objectManager = new ObjectManager();
	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
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
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == END_STATE) {
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

	}

	void updateGameState() {
		objectManager.update();
	    objectManager.manageEnemies();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.RED);
		// g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.drawString("League Invaders", 100, 400);

	}

	void drawGameState(Graphics g) {
objectManager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		// g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.drawString("Game Over!", 80, 400);
	}
}
