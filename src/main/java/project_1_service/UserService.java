package project_1_service;
import project_1.utils.JsonUtil;
import project_1_DAO.userDAO;
import project_1_baseClasses.User;

public class UserService {
//	public static void main(String[] args) {
//		UserService userService = new UserService();
//		
//		System.out.println(userDAO.getUser(1));
//	}

	public static String getUserJson(int i) {
			User u = userDAO.getUser(i);
			String s = JsonUtil.javaToJson(u);
		return s;
	}
	
}