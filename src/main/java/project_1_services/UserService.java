package project_1_services;
import project_1.utils.JsonUtil;
import project_1_DAO.UserDAO;
import project_1_POJO.User;

public class UserService {
//	public static void main(String[] args) {
//		UserService userService = new UserService();
//		
//		System.out.println(userDAO.getUser(1));
//	}

	
	
	public static String getUserJson(String username) {
		User u = UserDAO.getUserByUsername(username);
		String s = JsonUtil.javaToJson(u);
	return s;
}
}
