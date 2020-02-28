package project_1_services;

import java.util.ArrayList;
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
}
