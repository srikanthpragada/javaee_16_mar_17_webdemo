package jsf;

import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean
public class LoginBean {

	private String username, password, message;
	
	// Action Controller 
	// Return value is page name 
	public String login() {
		if (username.equals("admin") && password.equals("admin"))
		 return "home"; // home.xhtml
		else
		{
			message = "Invalid Login!";
			return "login";  // login.xhtml
		}
	}

	@Size(min=5, max=10, message = "Username must be 5 to 10 chars")
	@Pattern(regexp="[0-9a-zA-Z]+", message = "Invalid username. It must be alphanumeric")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("setUsername()");
		this.username = username;
	}

	@Size(min=5, max=10, message = "Password must be 5 to 10 chars")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
