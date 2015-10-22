package rozenberg.math;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class QuadraticGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldC;

	private JLabel labelA;
	private JLabel labelB;
	private JLabel labelC;
	private JLabel labelAns;

	private JButton buttonCalc;

	public QuadraticGui() {
		setTitle("QuadraticGui");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		labelA = new JLabel("A");
		add(labelA);

		textFieldA = new JTextField();
		add(textFieldA);

		labelB = new JLabel("B");
		add(labelB);

		textFieldB = new JTextField();
		add(textFieldB);

		labelC = new JLabel("C");
		add(labelC);

		textFieldC = new JTextField();
		add(textFieldC);

		buttonCalc = new JButton("Calculate");
		add(buttonCalc);

		labelAns = new JLabel();
		add(labelAns);

		buttonCalc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double a = Double.parseDouble(textFieldA.getText());
				double b = Double.parseDouble(textFieldB.getText());
				double c = Double.parseDouble(textFieldC.getText());

				try {
					QuadraticEquation quadratic = new QuadraticEquation(a, b, c);
					Double getN = quadratic.getNegative();
					Double getP = quadratic.getPositive();
					labelAns.setText("Negative: " + getN.toString() + " Positive: " + getP.toString());
				} catch (InvalidDataException e) {
					System.exit(1);
				}

			}

		});
	}

}