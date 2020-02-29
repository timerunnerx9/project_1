package project_1_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project_1.utils.ConnectionUtil;
import project_1_POJO.User;
/*
 * DAO used to get information from specific user called. 
 * */
public class UserDAO {

	public static User getUserByID(int userid) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ers_users WHERE ers_user_id = ?"; 
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userid);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				int user_id= result.getInt("ers_user_id");
				String username = result.getString("ers_username");
				String password = result.getString("ers_password");
				String firstname = result.getString("user_first_name");
				String lastname = result.getString("user_last_name");
				String email = result.getString("user_email");
				int role_id = result.getInt("user_role_id");
				
				return new User(user_id, username, password, firstname, lastname, email,
				role_id);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static User getUserByUsername(String username1) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?"; 
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username1);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				int user_id= result.getInt("ers_user_id");
				String username = result.getString("ers_username");
				String password = result.getString("ers_password");
				String firstname = result.getString("user_first_name");
				String lastname = result.getString("user_last_name");
				String email = result.getString("user_email");
				int role_id = result.getInt("user_role_id");
				
				return new User(user_id, username, password, firstname, lastname, email,
				role_id);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	


}
