
public class FormatException extends Exception{
	public FormatException(String message) {
		super(message);
	}
	
	public FormatException() {
		super("Input date is not properly formatted. Please enter a new date.");
	}
}
