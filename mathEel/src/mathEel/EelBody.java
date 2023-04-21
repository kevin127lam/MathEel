package mathEel;

public class EelBody {
	private int x;
	private int y;

	public EelBody(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void incX() {
		x += 40;
	}

	public void decX() {
		x -= 40;
	}

	public void incY() {
		y += 40;
	}

	public void decY() {
		y -= 40;
	}
}
