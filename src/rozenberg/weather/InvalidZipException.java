package rozenberg.weather;

public class InvalidZipException extends Exception {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public InvalidZipException() {
		super("Invalid Zip Code");
	}
}
