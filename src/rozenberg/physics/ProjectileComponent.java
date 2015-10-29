package rozenberg.physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class ProjectileComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		double x, y, x2, y2;
		Projectile projectile = new Projectile(31, 20, 0);
		for (double i = 0; i < 10; i = i + .5) {
			x = projectile.getX();
			y = projectile.getY();
			projectile.setTime(i + .5);
			x2 = projectile.getX();
			y2 = projectile.getY();
			g2.draw(new Line2D.Double(x, getHeight() - y, x2, getHeight() - y2));
		}
	}
}
