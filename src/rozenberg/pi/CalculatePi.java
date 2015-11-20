package rozenberg.pi;

public class CalculatePi {

	public static void main(String[] args) {
		System.out.println(Math.PI);
		// when run it through debug
		PiCalculator cal = new PiCalculator();
		System.out.println(cal.calculate(500000));

	}
}
