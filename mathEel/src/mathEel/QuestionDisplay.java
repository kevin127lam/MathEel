package mathEel;

import mathEel.Question.Answer;

public class QuestionDisplay {
	private Question[] questions;
	private int questionCount;

	public QuestionDisplay() {
		questionCount = 0;
		questions = new Question[10];
		questions[0] = new Question("What is 13 + 14", "72", "24", "27", "37", Answer.C);
		questions[1] = new Question("What is 4 * 5?", "16", "45", "25", "20", Answer.D);
		questions[2] = new Question("What is 2 + 2?", "1", "2", "3", "4", Answer.D);
		questions[3] = new Question("What is 19 * 20?", "190", "38", "380", "760", Answer.C);
		questions[4] = new Question("What is 3 - 1?", "1", "2", "3", "4", Answer.B);
		questions[5] = new Question("What is 13 * 4?", "26", "52", "39", "65", Answer.B);
		questions[6] = new Question("What is 5 + 14?", "19", "9", "11", "20", Answer.A);
		questions[7] = new Question("What is 16 - 3?", "10", "19", "16", "13", Answer.D);
		questions[8] = new Question("What is 9 + 1?", "11", "12", "10", "14", Answer.C);
		questions[9] = new Question("What is 8 * 12?", "96", "72", "84", "104", Answer.A);
	}

	public void nextQuestion() {
		questionCount++;
	}

	public Question getQuestion() {
		return questions[questionCount];
	}
}
