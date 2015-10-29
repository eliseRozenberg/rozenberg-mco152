package rozenberg.physics;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProjectileJFrame() {
		setTitle("Projectile");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(new ProjectileComponent(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new ProjectileJFrame().setVisible(true);
	}
}
