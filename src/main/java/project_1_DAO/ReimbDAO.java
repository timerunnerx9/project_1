package project_1_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;

import project_1.utils.ConnectionUtil;
import project_1_POJO.Reimb;
import project_1_POJO.tempReimb;


public class ReimbDAO {
	static Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
	public static void main(String[] args) {
		System.out.println(megaReimbDao(1));
	}

	public static ArrayList<tempReimb> megaReimbDao(int user_id) {
		try(Connection connection =  ConnectionUtil.getConnection()){
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
			ArrayList<tempReimb> ticketList = new ArrayList<tempReimb>();
			String sql = " select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_resolved, r.reimb_description, r.reimb_receipt,r.reimb_description, r.reimb_receipt, "+
					"a.user_first_name as au, u.user_first_name as uu, s.reimb_status,t.reimb_type "+
					"from ers_reimbursement r "+
					"left join ers_users a on "+
					"(a.ers_user_id = r.reimb_author) "+
					"left join ers_users u on "+
					"(u.ers_user_id = r.reimb_resolver) "+
					"left join ers_reimbursement_status s on "+
					"(s.reimb_status_id = r.reimb_status_id ) "+
					"join ers_reimbursement_type t on "+
					"(t.reimb_type_id = r.reimb_type_id)";

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				String reimb_id = String.valueOf(result.getInt("reimb_id"));
				String reimb_amount = String.valueOf(result.getDouble("reimb_amount"));
				
				String reimb_submitted = dateFormat.format(result.getTimestamp("reimb_submitted"));
				String reimb_resolved = result.getTimestamp("reimb_resolved")==null? "-":dateFormat.format(result.getTimestamp("reimb_resolved"));

			
				String reimb_description = result.getString("reimb_description");
				
				String reimb_receipt = String.valueOf(result.getBoolean("reimb_receipt"));
				String reimb_author = result.getString("au");
				String reimb_resolver = result.getString("uu");
				String reimb_status_id = result.getString("reimb_status");
				String reimb_type_id = result.getString("reimb_type");
//				System.out.println(new Reimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,description,reimb_receipt,reimb_author,reimb_resolver,
//						reimb_status_id,reimb_type_id));
				ticketList.add(new tempReimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,reimb_author,reimb_resolver,
						reimb_status_id,reimb_type_id));
						
			}return ticketList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}return null;
	}
	
	
	
	
	public static ArrayList<tempReimb> megaPendingReimbDao(int user_id) {
		try(Connection connection =  ConnectionUtil.getConnection()){
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			ArrayList<tempReimb> ticketList = new ArrayList<tempReimb>();
			String sql = " select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_resolved, r.reimb_description, r.reimb_receipt,r.reimb_description, r.reimb_receipt, "+
					"a.user_first_name as au, u.user_first_name as uu, s.reimb_status,t.reimb_type "+
					"from ers_reimbursement r "+
					"left join ers_users a on "+
					"(a.ers_user_id = r.reimb_author) "+
					"left join ers_users u on "+
					"(u.ers_user_id = r.reimb_resolver) "+
					"left join ers_reimbursement_status s on "+
					"(s.reimb_status_id = r.reimb_status_id ) "+
					"join ers_reimbursement_type t on "+
					"(t.reimb_type_id = r.reimb_type_id) where r.reimb_status_id = 1";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				String reimb_id = String.valueOf(result.getInt("reimb_id"));
				String reimb_amount = String.valueOf(result.getDouble("reimb_amount"));
				
				String reimb_submitted = dateFormat.format(result.getTimestamp("reimb_submitted"));
				String reimb_resolved = result.getTimestamp("reimb_resolved")==null? "-":dateFormat.format(result.getTimestamp("reimb_resolved"));
			
				String reimb_description = result.getString("reimb_description");
				
				String reimb_receipt = String.valueOf(result.getBoolean("reimb_receipt"));
				String reimb_author = result.getString("au");
				String reimb_resolver = result.getString("uu");
				String reimb_status_id = result.getString("reimb_status");
				String reimb_type_id = result.getString("reimb_type");
//				System.out.println(new Reimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,description,reimb_receipt,reimb_author,reimb_resolver,
//						reimb_status_id,reimb_type_id));
				ticketList.add(new tempReimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,reimb_author,reimb_resolver,
						reimb_status_id,reimb_type_id));
						
			}return ticketList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}return null;
	}
	
	
	public static ArrayList<tempReimb> megaReimbDaoByUser(int user_id) {
		try(Connection connection =  ConnectionUtil.getConnection()){
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			ArrayList<tempReimb> ticketList = new ArrayList<tempReimb>();
			String sql = " select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_resolved, r.reimb_description, r.reimb_receipt,r.reimb_description, r.reimb_receipt, "+
					"a.user_first_name as au, u.user_first_name as uu, s.reimb_status,t.reimb_type "+
					"from ers_reimbursement r "+
					"left join ers_users a on "+
					"(a.ers_user_id = r.reimb_author) "+
					"left join ers_users u on "+
					"(u.ers_user_id = r.reimb_resolver) "+
					"left join ers_reimbursement_status s on "+
					"(s.reimb_status_id = r.reimb_status_id ) "+
					"join ers_reimbursement_type t on "+
					"(t.reimb_type_id = r.reimb_type_id) where r.reimb_author = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, user_id);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				String reimb_id = String.valueOf(result.getInt("reimb_id"));
				String reimb_amount = String.valueOf(result.getDouble("reimb_amount"));
				
				String reimb_submitted = dateFormat.format(result.getTimestamp("reimb_submitted"));
							
				String reimb_resolved = result.getTimestamp("reimb_resolved")==null? "-":dateFormat.format(result.getTimestamp("reimb_resolved"));
				
				
				String reimb_description = result.getString("reimb_description");
				
				String reimb_receipt = String.valueOf(result.getBoolean("reimb_receipt"));
				String reimb_author = result.getString("au");
				String reimb_resolver = result.getString("uu");
				String reimb_status_id = result.getString("reimb_status");
				String reimb_type_id = result.getString("reimb_type");
//				System.out.println(new Reimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,description,reimb_receipt,reimb_author,reimb_resolver,
//						reimb_status_id,reimb_type_id));
				ticketList.add(new tempReimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,reimb_author,reimb_resolver,
						reimb_status_id,reimb_type_id));
						
			}return ticketList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}return null;
	}
	
	

	
	
	
	
	
	
	

	// method used to retrieve all reimbursements from specific employee.	
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
				String reimb_description = result.getString("reimb_description");
				Boolean reimb_receipt = result.getBoolean("reimb_receipt");
				int reimb_author = result.getInt("reimb_author");
				int reimb_resolver = result.getInt("reimb_resolver");
				int reimb_status_id = result.getInt("reimb_status_id");
				int reimb_type_id = result.getInt("reimb_type_id");
//				System.out.println(new Reimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,description,reimb_receipt,reimb_author,reimb_resolver,
//						reimb_status_id,reimb_type_id));
				ticketList.add(new Reimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,reimb_author,reimb_resolver,
						reimb_status_id,reimb_type_id));
						
			}return ticketList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}return null;
	}




// method used to retrieve all reimbursements from the table.	
	public static ArrayList<Reimb> viewPastTickets(int user_id) {
		try(Connection connection =  ConnectionUtil.getConnection()){
			ArrayList<Reimb> ticketList = new ArrayList<Reimb>();
			String sql =  "SELECT * FROM ers_reimbursement";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int reimb_id = result.getInt("reimb_id");
				Double reimb_amount = result.getDouble("reimb_amount");
				Timestamp reimb_submitted = result.getTimestamp("reimb_submitted");
				Timestamp reimb_resolved = result.getTimestamp("reimb_resolved");
				String reimb_description = result.getString("reimb_description");
				Boolean reimb_receipt = result.getBoolean("reimb_receipt");
				int reimb_author = result.getInt("reimb_author");
				int reimb_resolver = result.getInt("reimb_resolver");
				int reimb_status_id = result.getInt("reimb_status_id");
				int reimb_type_id = result.getInt("reimb_type_id");
//				System.out.println(new Reimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,description,reimb_receipt,reimb_author,reimb_resolver,
//						reimb_status_id,reimb_type_id));
				ticketList.add(new Reimb(reimb_id, reimb_amount, reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,reimb_author,reimb_resolver,
						reimb_status_id,reimb_type_id));
						
			}return ticketList;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}return null;
	}


	
	
	//util DAO used to parse result
	public static Reimb extractRecord(ResultSet result) throws SQLException{
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
		return new Reimb(reimb_id, reimb_amount, reimb_submitted, reimb_resolved, description,
							reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id);
	}
	
	
	// Query used to create a record based on filling in the reimbursement model data. 
	public static Reimb createRecord(int user_id, Reimb tempReimb) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted,  reimb_description,"
					+ " reimb_receipt, reimb_author, reimb_status_id, reimb_type_id)"
					+ "VALUES (?,?,?,?,?,?,?) RETURNING*";//sql to insert record into the reimbursement table
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setDouble(1, tempReimb.getReimb_amount());
			statement.setTimestamp(2, tempReimb.getReimb_submitted());
	
			statement.setString(3, tempReimb.getDescription());
			statement.setBoolean(4, tempReimb.getReimb_receipt());
			statement.setInt(5, tempReimb.getReimb_author());
			statement.setInt(6, tempReimb.getReimb_status_id());
			statement.setInt(7, tempReimb.getReimb_type_id());
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
	
	
	
	
	
	//manger reimb
	public static Reimb updateRecord(int user_id, int reimb_id, int status_code) {
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "update ers_reimbursement set reimb_status_id = ? ," + 
					"reimb_resolved = ? , reimb_resolver = ? WHERE reimb_id = ? RETURNING*;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, status_code);
			statement.setTimestamp(2, currentTimestamp.from(Instant.now()));
			statement.setInt(3, user_id);
			statement.setInt(4, reimb_id);
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