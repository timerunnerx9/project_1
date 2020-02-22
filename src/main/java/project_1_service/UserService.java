package project_1_service;
import project_1.utils.JsonUtil;
import project_1_DAO.userDAO;

public class UserService {
//	public static void main(String[] args) {
//		UserService userService = new UserService();
//		
//		System.out.println(userDAO.getUser(1));
//	}

	public String getUserJson(Object obj) {
		return JsonUtil.javaToJson(obj);
	}
	
}
