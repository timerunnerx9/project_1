package project_1_services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import project_1_DAO.ReimbDAO;
import project_1_POJO.Reimb;

public class ReimbService {
	
//	public static void main(String[] args) {
//		for(Reimb r : getTicketsByUserid(1)) {
//			System.out.println(r.getDescription());
//		}
//
//	}

		public static ArrayList<Reimb> getTicketsByUserid(int user_id){
			return ReimbDAO.viewPastTicketsByUserid(user_id);
		}
		
		
		
		public static Reimb createReimb(int user_id, int reimb_type_id, Double reimb_amount,
				String reimb_description, Boolean reimb_receipt) {
		Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
		
		 Reimb tempReimb = new Reimb(reimb_amount,currentTimestamp, reimb_description, reimb_receipt,
				 user_id,1,reimb_type_id);
		 Reimb newReimb = ReimbDAO.createRecord(user_id, tempReimb);
		return newReimb;
		}
}
