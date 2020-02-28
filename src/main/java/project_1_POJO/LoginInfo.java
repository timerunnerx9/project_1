package project_1_POJO;
/*
 * This is a plain old java object for project 1. 
 * This will create fields and methods to store and extract user login information.
 * This will be important to reference later on for checking the hash of the user's password. 
 * */
public class LoginInfo {

	public LoginInfo() {
		super();
	}

	private String username;
	private String userpassword;
	

	
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getUserPassword(){
		return this.userpassword;
	}
	
	public void setUserPassword(String userpassword) {
		this.userpassword = userpassword;
	}
}
