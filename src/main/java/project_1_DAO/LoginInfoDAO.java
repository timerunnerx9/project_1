package project_1_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project_1.utils.ConnectionUtil;
import project_1.utils.PassHash;

public class LoginInfoDAO {
	
	public static void main(String[]  args){
		System.out.println(verifyuser("test","1"));
	}
	
	
	public static Boolean verifyuser(String username, String userpassword) {
		return PassHash.checkPass(userpassword,UserDAO.getUserByUsername(username).getPassword());
	}



}
