package rozenberg.connect4;

import java.awt.Color;

public class Player {

	private int numId;
	private Color color;
	private int wins;

	public Player(int numId, Color color) {
		this.numId = numId;
		this.color = color;
		wins =0;
	}

	public int getNumId() {
		return numId;
	}

	public Color getColor() {
		return color;
	}

	public int getWins() {
		return wins;
	}

	public void setWins() {
		this.wins++;
	}

}
