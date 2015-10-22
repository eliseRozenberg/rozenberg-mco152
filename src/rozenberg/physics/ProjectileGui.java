package rozenberg.physics;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProjectileGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField FieldAng;
	private JTextField FieldVel;
	private JTextField FieldTi;

	private JLabel labelAng;
	private JLabel labelVel;
	private JLabel labelTi;
	private JLabel labelAns;

	private JButton button;

	public ProjectileGui() {
		setTitle("ProjectileGui");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		labelAng = new JLabel("Angle");
		add(labelAng);
		FieldAng = new JTextField();
		add(FieldAng);

		labelVel = new JLabel("Velocity");
		add(labelVel);
		FieldVel = new JTextField();
		add(FieldVel);

		labelTi = new JLabel("Time");
		add(labelTi);
		FieldTi = new JTextField();
		add(FieldTi);

		button = new JButton("Compute");
		add(button);
		labelAns = new JLabel();
		add(labelAns);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				double a = Double.parseDouble(FieldAng.getText());
				double b = Double.parseDouble(FieldVel.getText());
				double c = Double.parseDouble(FieldTi.getText());

				Projectile p = new Projectile(a, b, c);
				Double getX = p.getX();
				Double getY = p.getY();
				labelAns.setText("X = " + getX + "        Y = " + getY);
			}
		});
	}

	public static void main(String[] args) {
		ProjectileGui frame = new ProjectileGui();
		frame.setVisible(true);
	}

}
