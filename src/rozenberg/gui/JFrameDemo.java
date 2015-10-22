package rozenberg.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameDemo extends JFrame {
	// expected way to do it

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// if you have components to be used, add them here
	//private JTextField textField1;
	private JLabel textLabel1;
	private JLabel textLabel2;
	private JLabel textLabel3;

	private JButton button1;

	public JFrameDemo() {
		// always do 3 things:
		// 1. set a title
		// 2. set a size
		// 3. set default close operations- what happens when you hit the x
		// button
		setTitle("JFrameDemo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// closes the window and exists your program
		// if you don't set default operation- it will continue running after
		// the dialog box closes
		// when it happens switch to the debug and it will list for you all that
		// is running and allows you to stop it

		// all that sits on the content pane is put into container
		// a container is like the JPanel
		Container container = getContentPane();

		// setLayout(new FlowLayout());
		// to see the text box
		// flow layout will try to size things as small as possible therefore
		// when we ran it with no text, it was small

		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		// needs a container
		// to display vertically

		// set text Fields - in BoxLayout takes over the rest of the screen
		// textField1 = new JTextField();
		// textField1.setText("Hi :)");
		// add(textField1);

		textLabel1 = new JLabel("All the text gets shown all the time.");
		add(textLabel1);
		textLabel2 = new JLabel("H!!!!!!!!!!!!!");
		add(textLabel2);
		textLabel3 = new JLabel("All the text gets shown all the time.");
		add(textLabel3);

		button1 = new JButton("button1");
		add(button1);
		// the button needs an ActionListener for it to run when it gets clicked
		// its an interface
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Clap if you see this!!!");
			}

		});
		// creating an anonymous class that only exist here
		// it defines the action performed

	}// end main
}// end class
