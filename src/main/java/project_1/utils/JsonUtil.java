package project_1.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project_1_DAO.UserDAO;

public class JsonUtil {
//	public static void main(String[] args) {
//		System.out.println(javaToJson(userDAO.getUser(1)));
//	}
//	
	public static String javaToJson(Object obj) {
		ObjectMapper om = new ObjectMapper();
		
		String jsonString ="";
		
		try {
			 jsonString = om.writeValueAsString(obj);
			 
		} catch (Exception e) {
			
			e.printStackTrace();
//			System.out.println("Exception occured while converting java object to json");
		}
		return jsonString;
	}
}
