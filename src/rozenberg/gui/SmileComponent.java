package rozenberg.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// class will override a method from a class
	// override- when implementing/ extending a class, you can redefine it
	// components can draw themselves when told by the OS

	// CAN ONLY DRAW TO THE STRING INSIDE THE PAINT COMPONENT!!
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// g.drawLine(0, 300, 800, 50);
		// x1,x2,y1,y2 - grid components
		// (0,0) is the top left corner

		g.setColor(Color.black);
		g.drawOval(100, 100, 400, 400);

		g.setColor(Color.yellow);
		g.fillOval(100, 100, 400, 400);

		g.setColor(Color.blue);
		g.fillOval(200, 200, 50, 50);

		g.setColor(Color.blue);
		g.fillOval(350, 200, 50, 50);

		g.setColor(Color.red);
		g.fillArc(200, 230, 200, 200, 0, -180);

		// g.drawOval(100, 100, getWidth()-200, getHeight()-200);
		// to resize with screen

	}

}
