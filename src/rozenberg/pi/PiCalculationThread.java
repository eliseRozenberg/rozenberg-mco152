package rozenberg.pi;

import javax.swing.JLabel;

public class PiCalculationThread extends Thread {
	// to get the program to run multiple things at once we need threads to
	// display it more quickly

	// create a thread as we do any other class
	private JLabel label;

	public PiCalculationThread(JLabel label) {
		this.label = label;

	}

	public void run() {
		
		PiCalculator cal = new PiCalculator();
		double pi = cal.calculate(50000000L);
		label.setText(String.valueOf(pi));
	}

}
