package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	public static void main(String[] args) {
		_02_GuestBook gb = new _02_GuestBook();
		gb.run();
	}

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addButton = new JButton("Add Names");
	JButton viewButton = new JButton("View Names");
	ArrayList<String> names = new ArrayList<String>();

	void run() {
		frame.add(panel);
		panel.add(addButton);
		panel.add(viewButton);
		frame.setVisible(true);
		addButton.addActionListener(this);
		viewButton.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == (addButton)) {
			String userAnswer = JOptionPane.showInputDialog("Enter a name.");
			names.add(userAnswer);
		} else if (e.getSource() == (viewButton)) {
			String formattedList = "";
			for (int i = 0; i < names.size(); i++) {
				formattedList = formattedList + "Guest #" + (i+1)+ ": " + names.get(i)+"\n";
			}
	JOptionPane.showMessageDialog(null, formattedList);
		}

	}
}
