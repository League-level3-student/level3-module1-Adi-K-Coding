package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener {
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		// Song s = new Song("demo.mp3");
		// s.play();
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		// make an array list(<song>) and add a bunch of songs to it
		// make a GUI interface with the required buttons

	}

	ArrayList<Song> songs = new ArrayList();

	public static void main(String[] args) {
		new _06_IPodShuffle();
		_06_IPodShuffle ips = new _06_IPodShuffle();
		ips.run();
	}

	void run() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton randomSongButton = new JButton("Suprise Me");
		JButton stopButton = new JButton("Stop");
		frame.setVisible(true);
		frame.setSize(200, 100);
		frame.add(panel);
		panel.add(randomSongButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		randomSongButton.addActionListener(this);
		Song rickRoll = new Song("rickroll.mp3");
		songs.add(rickRoll);
		Song smoothSax = new Song("smoothSax.mp3");
		songs.add(smoothSax);
		Song summerOf69 = new Song("summerOf69.mp3");
		songs.add(summerOf69);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < songs.size(); i++) {
			songs.get(i).stop();
		}
		Random rand = new Random();
		int x = rand.nextInt(songs.size());
		songs.get(x).play();

	}

}
