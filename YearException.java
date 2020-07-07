
public class YearException extends Exception {
	public YearException(String message) {
		super(message);
	}
	
	public YearException() {
		super("Invalid year. Please reenter a valid year:\n");
	}
}
