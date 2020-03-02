package project_1.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PassHash {
	
	
	

	
	public static String hashingPass(String password) {
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt(8));
		return hashed;
	}

	
	public static boolean checkPass(String password, String hashed) {
		return BCrypt.checkpw(password, hashed);
	}

}

