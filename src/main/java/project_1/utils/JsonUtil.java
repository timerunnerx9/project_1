package project_1.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static ObjectMapper om;
	{
		om = new ObjectMapper();
	}
	public static String javaToJson(Object obj) {
		String jsonString ="";
		
		try {
			jsonString = om.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			
			System.out.println("Exception occured while converting java object to json");
		}
		return jsonString;
	}
}
