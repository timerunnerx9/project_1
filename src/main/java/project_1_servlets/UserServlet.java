package project_1_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project_1_service.UserService;

/**
 * Servlet implementation class UserServlet
 */
//@WebServlet("/UserServlet")

public class UserServlet extends HttpServlet {
//	public static void main(String[] args) {
//		
//		UserService userService = new UserService();
//		String jsonUser = userService.getUserJson(userDAO.getUser(1));
//		System.out.println(jsonUser);
//	}
	
//	private static final long serialVersionUID = 1L;
	
	
	
	@Override
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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		resp.addHeader("Access-Control-Allow-Headers", "authorization");
		resp.addHeader("Access-Control-Allow-Methods", "GET POST PUT DELETE");
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		
		super.service(req, resp);
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(UserService.getUserJson(1));
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
