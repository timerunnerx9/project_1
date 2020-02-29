package project_1_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import project_1.utils.ConnectionUtil;
import project_1_POJO.Reimb;


public class ReimbDAO {
	


	public static ArrayList<Reimb> viewPastTicketsByUserid(int user_id) {
		try(Connection connection =  ConnectionUtil.getConnection()){
			ArrayList<Reimb> ticketList = new ArrayList<Reimb>();
			String sql =  "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int reimb_id = result.getInt("reimb_id");
				Double reimb_amount = result.getDouble("reimb_amount");
				Timestamp reimb_submitted = result.getTimestamp("reimb_submitted");
				Timestamp reimb_resolved = result.getTimestamp("reimb_resolved");
				String description = result.getString("reimb_description");
				Boolean reimb_receipt = result.getBoolean("reimb_receipt");
				int reimb_author = result.getInt("reimb_author");
				int reimb_resolver = result.getInt("reimb_resolver");
				int reimb_status_id = result.getInt("reimb_status_id");
				int reimb_type_id = result.getInt("reimb_type_id");
//				System.out.println(new Reimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,description,reimb_receipt,reimb_author,reimb_resolver,
//						reimb_status_id,reimb_type_id));
				ticketList.add(new Reimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,description,reimb_receipt,reimb_author,reimb_resolver,
						reimb_status_id,reimb_type_id));
						
			}return ticketList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}return null;
	}


	
	
<<<<<<< HEAD
// method used to retrieve all reimbursements from specific employee.	
	public static Reimb viewEmpPastTickets(int reimb_id) {
		try(Connection connection =  ConnectionUtil.getConnection()){
			String sql =  "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
=======
	public static Reimb finManUpdateRecord(int reimb_id) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "UPDATE ers_reimbursement SET reimb_status_id = 'Pending' WHERE reimb_id = ?";
>>>>>>> 7d6231eeb743b8d14999357b2ff3a7e6bf257dc9
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
<<<<<<< HEAD

// method used to retrieve all reimbursements from the table.	
	public static Reimb viewPastTickets(int reimb_id) {
=======
	
	
	
	public static Reimb viewEmpPastTickets(int reimb_id) {
>>>>>>> 7d6231eeb743b8d14999357b2ff3a7e6bf257dc9
		try(Connection connection =  ConnectionUtil.getConnection()){
			String sql =  "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
<<<<<<< HEAD
	 	
=======
	

	
>>>>>>> 7d6231eeb743b8d14999357b2ff3a7e6bf257dc9
	public static Reimb extractRecord(ResultSet result) throws SQLException{
		int reimb_id = result.getInt("reimb_id");
		Double reimb_amount = result.getDouble("reimb_amount");
		Timestamp reimb_submitted = result.getTimestamp("reimb_submitted");
		Timestamp reimb_resolved = result.getTimestamp("reimb_resolved");
		String description = result.getString("description");
		Boolean reimb_receipt = result.getBoolean("reimb_receipt");
		int reimb_author = result.getInt("reimb_receipt");
		int reimb_resolver = result.getInt("reimb_resolver");
		int reimb_status_id = result.getInt("reimb_status_id");
		int reimb_type_id = result.getInt("reumb_type_id");
		return new Reimb(reimb_id, reimb_amount, reimb_submitted, reimb_resolved, description,
							reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id);
	}
	
	
	// Query used to create a record based on filling in the reimbursement model data. 
	
	public static Reimb createRecord(int userid, Reimb r) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO ers_reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, description,"
					+ " reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?) RETURNING*";//sql to insert record into the reimbursement table
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, r.getReimb_id());
			statement.setDouble(2, r.getReimb_amount());
			statement.setTimestamp(3, r.getReimb_submitted());
			statement.setTimestamp(4, r.getReimb_resolved());
			statement.setString(5, r.getDescription());
			statement.setBoolean(6, r.getReimb_receipt());
			statement.setInt(7, r.getReimb_author());
			statement.setInt(8, r.getReimb_resolver());
			statement.setInt(9, r.getReimb_status_id());
			statement.setInt(10, r.getReimb_type_id());
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return extractRecord(result);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}