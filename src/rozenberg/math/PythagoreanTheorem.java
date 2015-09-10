package rozenberg.math;

public class PythagoreanTheorem {

	private double a;
	private double b;
	private double c;

	public PythagoreanTheorem() {

	}

	/**
	 * Sets the value of A and B and computes C
	 */
	public void setAB(double a, double b) throws InvalidDataException {
		if (a == 0 || b == 0)
			throw new InvalidDataException();
		this.a = a;
		this.b = b;
		this.c = Math.sqrt((a * a) + (b * b));
	}

	/**
	 * Sets the value of A and C and computes B
	 */
	public void setAC(double a, double c) throws InvalidDataException {
		if (a == 0 || c == 0)
			throw new InvalidDataException();
		if (c < a)
			throw new InvalidDataException();
		this.a = a;
		this.c = c;
		this.b = Math.sqrt((c * c) - (a * a));
	}

	/**
	 * Sets the value of B and C and computes A
	 */
	public void setBC(double b, double c) throws InvalidDataException {
		if (c == 0 || b == 0)
			throw new InvalidDataException();
		if (c < b)
			throw new InvalidDataException();
		this.b = b;
		this.c = c;
		this.a = Math.sqrt((c * c) - (b * b));
	}

	public double getA() {
		return this.a;
	}

	public double getB() {
		return this.b;
	}

	public double getC() {
		return this.c;
	}

}
