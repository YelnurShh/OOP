package exceptions;

public class NotResearcherException extends Exception {

	public NotResearcherException(String message) {
		super(message);
	}

	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public String toString() {
		return "NotResearcherException: " + getMessage();
	}
}
