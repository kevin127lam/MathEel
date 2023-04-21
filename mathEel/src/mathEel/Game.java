package mathEel;

import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame {
	public enum GameState {
		PAUSED, GAME_OVER, IN_GAME
	}

	public static EelWindow eelWindow = new EelWindow();
	public static GameState gameState = GameState.PAUSED;
	private static QuestionDisplay question = new QuestionDisplay();

	public Game() {
		add(eelWindow);
		setResizable(false);
		pack();

		setTitle("Eel Math");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void startGame() {
		eelWindow.startGame();
		gameState = GameState.IN_GAME;
	}

	public static void pauseGame() {
		eelWindow.pauseGame();
		gameState = GameState.PAUSED;
	}

	public static void gameOver() {
		gameState = GameState.GAME_OVER;
	}

	public static void nextQuestion() {
		question.nextQuestion();
	}

	public static Question getQuestion() {
		return question.getQuestion();
	}

	public static void setGameState(GameState g) {
		gameState = g;
	}

	public static GameState getGameState() {
		return gameState;
	}

	public static void main(String[] args) {

		// Creates a new thread so our GUI can process itself
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new Game();
				frame.setVisible(true);
				pauseGame();
			}
		});
	}
}