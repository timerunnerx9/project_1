package project_1_DAO;

import java.sql.Connection;
import java.sql.SQLException;

import project_1.utils.ConnectionUtil;
import project_1_baseClasses.Reimbursement;

public class reimbursementDAO {
	
	public static Reimbursement createRecord(int userid, Reimbursement r) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "";//sql to insert record into the reimbursement table
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
