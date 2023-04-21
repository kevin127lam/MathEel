package mathEel;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Eel extends EelBody {

	public enum Direction {
		UP, DOWN, LEFT, RIGHT;
	}

	Direction dir;
	private int key;
	private int length;
	private ArrayList<EelBody> bodyList;
	private EelBody lastPos;

	public Eel(int l, int x, int y) {
		super(x, y);
		dir = Direction.RIGHT;
		length = l;
		bodyList = new ArrayList<EelBody>();
		for (int i = 1; i < length; i++) {
			bodyList.add(new EelBody(x - 40 * i, y));
		}
	}

	public void setKey(int k) {
		key = k;
	}

	public void move() {
		bodyList.add(0, new EelBody(this.getX(), this.getY()));
		lastPos = bodyList.remove(bodyList.size() - 1);
		getDirection();
		switch (dir) {
		case UP:
			this.decY();
			break;
		case DOWN:
			this.incY();
			break;
		case LEFT:
			this.decX();
			break;
		case RIGHT:
			this.incX();
			break;
		}
		if (this.getX() >= 800 || this.getX() < 0 || this.getY() >= 800 || this.getY() < 0) {
			Game.gameOver();
		}
		for (EelBody b : bodyList) {
			if (b.getX() == this.getX() && b.getY() == this.getY()) {
				Game.gameOver();
			}
		}
	}

	public ArrayList<EelBody> getBodyList() {
		return bodyList;
	}

	public Direction getDirection() {
		if ((key == KeyEvent.VK_LEFT) && (dir != Direction.RIGHT)) {
			dir = Direction.LEFT;
		} else if ((key == KeyEvent.VK_RIGHT) && (dir != Direction.LEFT)) {
			dir = Direction.RIGHT;
		} else if ((key == KeyEvent.VK_UP) && (dir != Direction.DOWN)) {
			dir = Direction.UP;
		} else if ((key == KeyEvent.VK_DOWN) && (dir != Direction.UP)) {
			dir = Direction.DOWN;
		}
		return dir;
	}

	public void incLength() {
		length++;
		bodyList.add(lastPos);

	}

	public void decLength() {
		length--;
		if (bodyList.size() != 0) {
			bodyList.remove(bodyList.size() - 1);
		} else {
			Game.gameOver();
		}
	}

	public void draw(Graphics g, BufferedImage head, BufferedImage body, EelWindow e) {
		for (EelBody b : bodyList) {
			g.drawImage(body, b.getX(), b.getY(), e);
		}
		g.drawImage(head, this.getX(), this.getY(), e);
	}
}
