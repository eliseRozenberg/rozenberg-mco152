package rozenberg.math;

public class QuadraticEquation {
	private double a;
	private double b;
	private double c;
	private double sqrRt;

	public QuadraticEquation(double a, double b, double c) throws InvalidDataException {
		// see divide by 0 exception-
		// in a GUI- will have problems...think nuclear explosion

		if (a == 0) {
			throw new InvalidDataException();
		}
		this.a = a;
		this.b = b;
		this.c = c;
		// check if <0 - if so Math.sqrt returns NaN
		double temp = (this.b * this.b) - (4 * this.a * this.c);
		if (temp < 0) {
			throw new InvalidDataException();
		}
		this.sqrRt = Math.sqrt(temp);

	}

	public double getPositive() {
		return (-b + (sqrRt)) / (2 * a);
	}

	public double getNegative() {
		return (-b - (sqrRt)) / (2 * a);
	}
}
