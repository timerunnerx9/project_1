package project_1_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project_1.utils.ConnectionUtil;

public class LoginInfoDAO {
	public static Boolean verifyuser(String username, String userpassword) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				if(result.getString("ers_password").equals(userpassword)) {
					return true;
				}
				
			}
			else {
				return false;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return false;
	}
}
