package rozenberg.gui;

import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {
	// class will override a method from a class
	// override- when implementing/ extending a class, you can redefine it
	// components can draw themselves when told by the OS

	// CAN ONLY DRAW TO THE STRING INSIDE THE PAINT COMPONENT!!
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawLine(0, 300, 800, 50);
		//x1,x2,y1,y2 - grid components
		//(0,0) is the top left corner
		
		g.drawOval(100, 100, 400, 400);
		g.drawOval(200, 200, 50, 50);
		g.drawOval(350, 200, 50, 50);
		
		g.drawArc(170, 350, 170, 300, 180,180);
		
	}

}
