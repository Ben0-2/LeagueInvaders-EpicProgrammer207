import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	static final int width = 500;
	static final int height = 800;
	GamePanel panel;

	public LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
		setup();
	}

	public static void main(String[] args) {
		LeagueInvaders leagueInvaders = new LeagueInvaders();
	}

	void setup() {
		frame.setSize(width, height);
		frame.addKeyListener(panel);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();
	}
}
