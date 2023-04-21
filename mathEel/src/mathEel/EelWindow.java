package mathEel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import mathEel.Game.GameState;

@SuppressWarnings("serial")
public class EelWindow extends JPanel implements ActionListener {

	private final int W_WIDTH = 800;
	private final int W_HEIGHT = 800;
	private final int DELAY = 150;

	private BufferedImage headImage;
	private BufferedImage bodyImage;
	private BufferedImage shrimpImage;

	private Eel eel = new Eel(3, W_WIDTH / 2, W_HEIGHT / 2);
	private KeyboardInput keyboard = new KeyboardInput(eel);
	private Timer timer;
	private Question question;

	public EelWindow() {
		addKeyListener(keyboard);
		setBackground(Color.blue);
		setFocusable(true);
		setPreferredSize(new Dimension(W_WIDTH, W_HEIGHT));
		timer = new Timer(DELAY, this);
		try {
			headImage = ImageIO.read(new File("src\\images\\head.png"));
			bodyImage = ImageIO.read(new File("src\\images\\body.png"));
			shrimpImage = ImageIO.read(new File("src\\images\\shrimp.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pauseGame() {
		timer.stop();
	}

	public void startGame() {
		timer.start();
	}

	public void gameOver() {
		timer.stop();
	}

	public void actionPerformed(ActionEvent e) {
		eel.move();
		for (Shrimp s : question.getShrimp()) {
			s.check(eel);
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		question = Game.getQuestion();
		if (Game.getGameState() == GameState.IN_GAME) {
			eel.draw(g, headImage, bodyImage, this);
			question.drawShrimp(g, shrimpImage, this);
		} else if (Game.getGameState() == GameState.PAUSED) {
			question.draw(g);
		} else if (Game.getGameState() == GameState.GAME_OVER) {
			setBackground(Color.black);
			g.setColor(Color.red);
			Font font = new Font("Times New Roman", Font.BOLD, 50);
			g.setFont(font);
			g.drawString("GAME OVER", 250, 400);
			gameOver();
		}

	}
}
