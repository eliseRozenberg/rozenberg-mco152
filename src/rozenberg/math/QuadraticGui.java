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
	private JTextField textField1;
	private JLabel textLabelA;
	private JLabel textLabelB;
	private JLabel textLabelC;
	private QuadraticEquation quadratic;
	private JButton buttonCalc;

	public QuadraticGui() {
		setTitle("QuadraticGui");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		textLabelA = new JLabel("A =");
		add(textLabelA);
		double a = Double.parseDouble(textLabelA.getText());

		textLabelB = new JLabel("B = ");
		add(textLabelB);
		double b = Double.parseDouble(textLabelB.getText());

		textLabelC = new JLabel("C = ");
		add(textLabelC);
		double c = Double.parseDouble(textLabelC.getText());

		buttonCalc = new JButton("Calculate");
		add(buttonCalc);

		buttonCalc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(quadratic.getPositive());
				System.out.println(quadratic.getNegative());

			}

		});
	}

}
