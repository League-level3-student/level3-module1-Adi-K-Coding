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
		userAnswer = JOptionPane.showInputDialog("How many words would you like to guess?");
		int userAnswerNumber = Integer.parseInt(userAnswer);
		for (int i = 0; i < userAnswerNumber; i++) {
			String word = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(word)) {
				words.push(word);
			}
		}
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
		char letter = e.getKeyChar();
		for (int i = 0; i < currentWord.length(); i++) {
			if (currentWord.charAt(i) == letter) {
				String text = label.getText();
				String modifiedText = text.substring(0, i * 2) + letter + text.substring(i * 2 + 1);
				label.setText(modifiedText);
				frame.pack();
			//if(boolean)
			
				//lives = lives - 1;
				//make boolean before the for loop to keep track of whether there was a correct match between what the 
				//user typed and the word they are trying to guess
			}	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
