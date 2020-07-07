
public class MonthException extends Exception {
	public MonthException(String message) {
		super(message);
	}
	
	public MonthException() {
		super("Invalid month. Reenter a valid month:\n");
	}
}
