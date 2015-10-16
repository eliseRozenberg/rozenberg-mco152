package rozenberg.math;

public class QuadraticEquationMain {

	public static void main(String[] args) throws InvalidDataException {
		QuadraticEquation dd = new QuadraticEquation(1, 3, -4);

		System.out.println(dd.getNegative());
		System.out.println(dd.getPositive());
		
	}
}
