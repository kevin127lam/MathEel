package mathEel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import mathEel.Game.GameState;

public class Shrimp {
	private int x;
	private int y;
	private String display;
	private boolean correct;

	public Shrimp(String d, boolean c) {
		randPos();
		display = d;
		correct = c;
	}

	public void randPos() {
		x = randomX();
		y = randomY();
	}

	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int randomX() {
		return 40 * (int) (Math.random() * 20.0);
	}

	private int randomY() {
		return 40 * (int) (Math.random() * 20.0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void check(Eel e) {
		for (EelBody b : e.getBodyList()) {
			if (b.getX() == x && b.getY() == y) {
				randPos();
				check(e);
				break;
			}
		}

		if (e.getX() == x && e.getY() == y) {
			if (correct == true) {
				e.incLength();
				randPos();
				Game.nextQuestion();
			} else {
				e.decLength();
				setPos(-100, -100);
			}
			if (Game.getGameState() != GameState.GAME_OVER)
				Game.pauseGame();
		}
	}

	public void draw(Graphics g, BufferedImage shrimp, EelWindow e) {
		g.drawImage(shrimp, x, y, e);
		Font font = new Font("Times New Roman", Font.BOLD, 34);
		g.setFont(font);
		g.drawString(display, x + 8, y + 30);
	}
}
