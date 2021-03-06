package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */

	HashMap<Integer, String> logSearch = new HashMap<Integer, String>();
	JFrame frame = new JFrame("List o'Peeps");
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Add Entry");
	JButton button2 = new JButton("Search by ID");
	JButton button3 = new JButton("View List");
	JButton button4 = new JButton("Remove Entry");

	public static void main(String[] args) {
		_02_LogSearch constructor = new _02_LogSearch();
		constructor.run();
	}

	void run() {
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == (button1)) {
			String userIDNumberString = JOptionPane.showInputDialog("Enter an ID Number.");
			int userIDNumberInt = Integer.parseInt(userIDNumberString);
			String userNameEntry = JOptionPane.showInputDialog("Enter a Name");
			logSearch.put(userIDNumberInt, userNameEntry);
		}
		if (e.getSource() == (button2)) {
			String searchIDNumber = JOptionPane.showInputDialog("Enter an ID number to search for.");
			int searchedIDNumber = Integer.parseInt(searchIDNumber);
			String button2Input = logSearch.get(searchedIDNumber);
			System.out.println(button2Input);
		}
		if (e.getSource() == (button3)) {
			String allPeople = "";
			for (Integer i : logSearch.keySet()) {
				allPeople = allPeople + "ID: " + i + " Name: " + logSearch.get(i) + "\n";

			}
			JOptionPane.showMessageDialog(null, allPeople);
		}
		if (e.getSource() == (button4)) {
			String userToRemoveString = JOptionPane.showInputDialog("Enter an ID Number to remove");
			int userToRemoveInt = Integer.parseInt(userToRemoveString);
			logSearch.remove(userToRemoveInt);
		}
	}

}