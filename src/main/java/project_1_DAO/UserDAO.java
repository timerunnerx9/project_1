package project_1_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project_1.utils.ConnectionUtil;
import project_1.utils.PassHash;
import project_1_POJO.User;
/*
 * DAO used to get information from specific user called. 
 * */
public class UserDAO {
	public static void main(String[] args) {
		
//		updatePassByID(1);
		
		
//		System.out.println(PassHash.checkPass("294597053",getUserByUsername("davecen9").getPassword()));
//			
		}
//		
		

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
	
	
	public static void updatePassByID(int userid) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String originPassword;
			String hashedPassword;
			String sql = "SELECT * FROM ers_users WHERE ers_user_id = ?"; 
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userid);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				originPassword = result.getString("ers_password");
				String sql1 = "UPDATE ers_users SET ers_password = ? WHERE "+
						"ers_user_id = ? RETURNING*";
				hashedPassword = PassHash.hashingPass(originPassword);
				PreparedStatement statement1 = connection.prepareStatement(sql1);
				statement1.setString(1, hashedPassword);
				statement1.setInt(2,userid);
				ResultSet result2 = statement1.executeQuery();
				if(result2.next()) {
					System.out.println("Password Hashed: "+hashedPassword);
				}
			}

			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	


}
