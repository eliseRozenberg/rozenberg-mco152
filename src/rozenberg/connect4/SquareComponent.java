package rozenberg.connect4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public class SquareComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	private Image image;

	public SquareComponent(Color color, Image image) {
		this.color = color;
		this.image = image;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(color);
		g.fillOval(15, 15, getWidth() - 30, getHeight() - 30);
		super.repaint();
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
