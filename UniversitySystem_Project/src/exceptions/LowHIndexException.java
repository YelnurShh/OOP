package exceptions;

public class LowHIndexException extends Exception {

	public LowHIndexException(String message) {
		super(message);
	}

	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public String toString() {
		return "LowHIndexException: " + getMessage();
	}
}
