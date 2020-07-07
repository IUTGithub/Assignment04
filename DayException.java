
public class DayException extends Exception {
	public DayException(String message) {
		super(message);
	}
	
	public DayException() {
		super("Invalid day. Reenter a valid day.");
	}
}
