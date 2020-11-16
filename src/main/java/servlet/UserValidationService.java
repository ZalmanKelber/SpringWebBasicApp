package servlet;

public class UserValidationService {
	
	private final String tempUsername = "Zalman";
	private final String tempPassword = "password";
	
	public boolean isValid (String username, String password) {
		return username.equals(tempUsername) && password.equals(tempPassword);
	}
}