package mathEel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Question {
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String exitMessage = "Press enter to continue";
	private Shrimp shrimp1;
	private Shrimp shrimp2;
	private Shrimp shrimp3;
	private Shrimp shrimp4;
	private Shrimp[] answerShrimp = new Shrimp[4];
	private Answer answer;
	private boolean answerIsA = false;
	private boolean answerIsB = false;
	private boolean answerIsC = false;
	private boolean answerIsD = false;

	public enum Answer {
		A, B, C, D
	}

	public Question(String q, String a1, String a2, String a3, String a4, Answer a) {
		question = q;
		answer1 = a1;
		answer2 = a2;
		answer3 = a3;
		answer4 = a4;
		answer = a;
		answerSelector();
		createShrimp();
	}

	public void answerSelector() {
		switch (answer) {
		case A:
			answerIsA = true;
			break;
		case B:
			answerIsB = true;
			break;
		case C:
			answerIsC = true;
			break;
		case D:
			answerIsD = true;
			break;
		}
	}

	public void createShrimp() {
		shrimp1 = new Shrimp("A", answerIsA);
		shrimp2 = new Shrimp("B", answerIsB);
		shrimp3 = new Shrimp("C", answerIsC);
		shrimp4 = new Shrimp("D", answerIsD);
		answerShrimp[0] = shrimp1;
		answerShrimp[1] = shrimp2;
		answerShrimp[2] = shrimp3;
		answerShrimp[3] = shrimp4;
	}

	public void draw(Graphics g) {
		Font questionFont = new Font("Times New Roman", Font.PLAIN, 18);
		g.setFont(questionFont);
		g.setColor(Color.white);
		g.fillRect(200, 200, 400, 400);
		g.setColor(Color.black);
		g.drawString(question, 250, 250);
		g.drawString("A: " + answer1, 250, 350);
		g.drawString("B: " + answer2, 250, 400);
		g.drawString("C: " + answer3, 250, 450);
		g.drawString("D: " + answer4, 250, 500);
		g.drawString(exitMessage, 250, 550);
	}

	public Shrimp[] getShrimp() {
		return answerShrimp;
	}

	public void drawShrimp(Graphics g, BufferedImage shrimpImage, EelWindow w) {
		for (Shrimp s : answerShrimp) {
			s.draw(g, shrimpImage, w);
		}
	}
}
