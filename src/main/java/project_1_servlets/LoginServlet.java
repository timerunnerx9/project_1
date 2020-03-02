package project_1_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import project_1_DAO.LoginInfoDAO;
import project_1_DAO.UserDAO;
import project_1_POJO.LoginInfo;
import project_1_services.UserService;


public class LoginServlet extends HttpServlet{
	
	public void init() throws ServletException {
		
		try {
			Class.forName("org.postgresql.Driver");
			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		super.init();
	}	
	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
//		resp.addHeader("Access-Control-Allow-Headers", "authorization");
		response.addHeader("Access-Control-Allow-Headers", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET POST PUT DELETE");
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		
		super.service(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("name");
		String password = request.getParameter("password");

		if(LoginInfoDAO.verifyuser(username, password)){
			Cookie c1 = new Cookie("userid",String.valueOf(UserDAO.getUserByUsername(username).getUser_id()));
			c1.setPath("/");
			c1.setDomain("localhost");
			response.addCookie(c1);
			
			out.print(UserService.getUserJson(username));
		}
		else {
			out.print("Account Verification failed");
			response.setStatus(404);
		}
}
}
