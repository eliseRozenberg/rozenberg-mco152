package rozenberg.gui;

public class GuiDemo {

	public static void main(String[] args) {

		// DONT DO THIS
		// JFrame frame = new jFrame();
		// instead we create a class that extends from JFrame- see JFrame Demo

		final JFrameDemo frame = new JFrameDemo();
		// wont be visible until you set it to be visible
		frame.setVisible(true);
	}

}
