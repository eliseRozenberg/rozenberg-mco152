package rozenberg.connect4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConnectFourFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private SquareComponent[][] squares;
	private JButton[] buttons;
	private ImageIcon arrow;
	private ImageIcon background;

	private int rows;
	private int cols;
	private int player;
	private Table table;

	public ConnectFourFrame() {
		setTitle("CONNECT 4");
		setSize(900, 900);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);

		panel = (JPanel) getContentPane();
		panel.setLayout(new GridLayout(7, 7));
		panel.setBackground(Color.WHITE);
		rows = 6;
		cols = 7;
		squares = new SquareComponent[rows][cols];
		buttons = new JButton[cols];
		background = new ImageIcon("pink.jpg");
		Image image = background.getImage();

		arrow = new ImageIcon("arrow.jpg");
		Image image1 = arrow.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
		arrow = new ImageIcon(image1);
		player = 1;
		table = new Table();

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setBackground(Color.WHITE);
			buttons[i].setIcon(arrow);
			buttons[i].setActionCommand("" + i);
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg) {
					int col = Integer.parseInt(arg.getActionCommand());
					int row = table.setCell(col, player);
					if (row != -1) {

						row = (-5 + row) * -1;

						squares[row][col].setColor(table.getPlayer(player).getColor());
						if (table.check(player)) {
							newGame(JOptionPane.showConfirmDialog(null, "Play New Game ??",
									"Player " + player + " WINS!!", JOptionPane.YES_NO_OPTION));
						} else if (table.draw()) {
							newGame(JOptionPane.showConfirmDialog(null, "Play New Game ??", "DRAW GAME!",
									JOptionPane.YES_NO_OPTION));
						} else {
							player = table.changePlayer(player);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Column Filled", "Choose another column...",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			panel.add(buttons[i]);
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				squares[i][j] = new SquareComponent(Color.WHITE, image);
				panel.add(squares[i][j]);
			}
		}
	}

	public void newGame(int temp) {
		if (temp < 1) {
			table.clearTable();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					squares[i][j].setColor(Color.WHITE);
				}
			}
		} else {
			dispose();
		}

	}

	public static void main(String[] args) {
		new ConnectFourFrame().setVisible(true);

	}
}
