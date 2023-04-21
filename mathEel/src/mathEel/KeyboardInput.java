package mathEel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import mathEel.Game.GameState;

public class KeyboardInput extends KeyAdapter {
	private Eel eel;

	public KeyboardInput(Eel e) {
		eel = e;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		eel.setKey(key);

		if ((key == KeyEvent.VK_ENTER) && (Game.getGameState() == GameState.PAUSED)) {
			Game.startGame();
		}
	}
}
