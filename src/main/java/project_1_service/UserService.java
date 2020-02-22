package project_1_service;
import project_1.utils.JsonUtil;
import project_1_DAO.userDAO;

public class UserService {

	public String getUserJson(Object obj) {
		return JsonUtil.javaToJson(obj);
	}
	
}
