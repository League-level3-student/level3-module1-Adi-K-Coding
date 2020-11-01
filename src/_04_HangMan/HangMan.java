package _04_HangMan;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String userAnswer;
	Stack<String> words = new Stack<String>();
	String currentWord;
	int lives = 10;

	public static void main(String[] args) {
		HangMan hangMan = new HangMan();
		hangMan.run();
		hangMan.start();
	}

	void run() {

		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		label.setSize(new Dimension(100, 30));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void start() {
		lives = 10;
		userAnswer = JOptionPane.showInputDialog("How many words would you like to guess?");
		int userAnswerNumber = Integer.parseInt(userAnswer);
		for (int i = 0; i < userAnswerNumber; i++) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(word)) {
				words.push(word);
			}
		}
		start2();
	}

	void start2() {
		currentWord = words.pop();
		String underScores = "";
		for (int i = 0; i < currentWord.length(); i++) {
			underScores = underScores + "_ ";
		}
		label.setText(underScores);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		boolean correctGuess = false;
		char letter = e.getKeyChar();
		for (int i = 0; i < currentWord.length(); i++) {
			if (currentWord.charAt(i) == letter) {
				String text = label.getText();
				String modifiedText = text.substring(0, i * 2) + letter + text.substring(i * 2 + 1);
				label.setText(modifiedText);
				correctGuess = true;
				frame.pack();

			}
		}
		if (correctGuess == false) {
			lives = lives - 1;
			System.out.println(lives);
			if (lives <= 0) {
				int playAgain = JOptionPane.showConfirmDialog(null,
						"Game Over, the word was " + currentWord + "\nDo you want to play again?");
				if (playAgain == 0) {
					start();
				} else {
					System.exit(0);
				}
			}
		}
		if (!label.getText().contains("_") && !words.isEmpty()) {
			start2();
			lives = 10;

		} else if (!label.getText().contains("_")) {
			JOptionPane.showMessageDialog(null, "You won. Good Job. ");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
