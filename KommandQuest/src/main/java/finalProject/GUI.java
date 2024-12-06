package finalProject;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI {

	private static void createAndShowGUI() {
        //Create and set up the window.
		// Window title
        JFrame frame = new JFrame("Kommand Quest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
	}
}
