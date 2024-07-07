public class AccountDoesNotExistException extends Exception{
	
	public AccountDoesNotExistException(String message) {
		super(message);
	}
	
	public AccountDoesNotExistException() {
		super("Error: Account Doesn't Exist");
	}
}
