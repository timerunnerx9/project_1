package project_1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() {
		String schemasetting = "?currentSchema=project_1";
		String url = "jdbc:postgresql://database-1.cupazha4mqw8.us-east-2.rds.amazonaws.com:5432/postgres"+schemasetting;
		String user = "davecen9";
		String password = "294597053";
		
		try {
			return DriverManager.getConnection(url,user,password);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
