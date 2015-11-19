package rozenberg.connect4;

import java.awt.Color;

public class Table {

	private int[][] table;
	private Player player1;
	private Player player2;
	private int turnsLeft;
	private int rows;
	private int cols;

	public Table() {
		table = new int[][] { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		turnsLeft = 42;
		rows = 6;
		cols = 7;

		player1 = new Player(1, Color.black);
		player2 = new Player(2, Color.gray);
	}

	public boolean checkCell(int row, int col, int player) {
		return table[row][col] == player;
	}

	public int setCell(int col, int player) {
		for (int i = 0; i < table.length; i++) {
			if (table[i][col] == 0) {
				table[i][col] = player;
				turnsLeft--;
				return i;
			}
		}
		return -1;
	}

	public boolean check(int player) {

		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < cols - 4; row++) {
				if (table[row][col] == player && table[row][col] == table[row + 1][col]
						&& table[row + 1][col] == table[row + 2][col] && table[row + 2][col] == table[row + 3][col]) {
					return true;
				}
			}
		}
		for (int col = 0; col < rows; col++) {
			for (int row = 0; row < rows - 4; row++) {
				if (table[row][col] == player && table[row][col] == table[row][col + 1]
						&& table[row][col + 1] == table[row][col + 2] && table[row][col + 2] == table[row][col + 3]) {
					return true;
				}
			}
		}
		for (int row = 3; row < rows; row++) {
			for (int col = 0; col < rows - 2; col++) {
				if (table[row][col] == player && table[row][col] == table[row - 1][col + 1]
						&& table[row - 1][col + 1] == table[row - 2][col + 2]
						&& table[row - 2][col + 2] == table[row - 3][col + 3]) {
					return true;
				}
			}
		}
		for (int row = 0; row < rows - 3; row++) {
			for (int col = 0; col < rows - 2; col++) {
				if (table[row][col] == player && table[row][col] == table[row + 1][col + 1]
						&& table[row][col] == table[row + 2][col + 2] && table[row][col] == table[row + 3][col + 3]) {
					return true;
				}
			}
		}
		return false;
	}

	public int changePlayer(int player) {
		if (player == 1) {
			return 2;
		} else {
			return 1;
		}
	}

	public boolean draw() {
		return turnsLeft == 0;
	}

	public int getTurnsLeft() {
		return turnsLeft;
	}

	public int[][] getTable() {
		return table;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public Player getPlayer(int player) {
		if (player1.getNumId() == player) {
			return player1;
		} else {
			return player2;
		}
	}

	public void clearTable() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				table[i][j] = 0;
			}
		}
		turnsLeft = 42;

	}

}