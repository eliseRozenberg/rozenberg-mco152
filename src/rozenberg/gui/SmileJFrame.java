package rozenberg.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class SmileJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SmileJFrame() {
		setTitle("Smile");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//BorderLayout layout = new BorderLayout();
		//container.setLayout(new BorderLayout());

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(new SmileComponent(), BorderLayout.CENTER);
	}
	
	public static void main (String []args){
		new SmileJFrame().setVisible(true);
	}
}
