package project_1_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project_1.utils.ConnectionUtil;

public class userDAO {

	public static Boolean varifyuser(String userid) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ers_users WHERE userid = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userid);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
}
}
