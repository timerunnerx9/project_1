package project_1_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
//		resp.addHeader("Access-Control-Allow-Headers", "authorization");
		resp.addHeader("Access-Control-Allow-Headers", "*");
		resp.addHeader("Access-Control-Allow-Methods", "GET POST PUT DELETE");
//		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		
		resp.addHeader("Access-Control-Allow-Origin", "*");
		
		super.service(req, resp);
		
	}
	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("application/json");
		
//		ObjectMapper om = new ObjectMapper();
//		LoginInfo loginInfo = om.readValue(line, LoginInfo.class);
		
		PrintWriter out = response.getWriter();

//		LoginInfo loginInfo = new Gson().fromJson(request.getReader(), LoginInfo.class);
		
//		String username = loginInfo.getUsername();
//		String password = loginInfo.getUserPassword();

//		System.out.println(username);
//		System.out.println(password);
//		System.out.println(UserService.getUserJson(username));
//		out.print(UserService.getUserJson(username));
//	
//		System.out.println(request.getReader().readLine());
//		String querystring = request.getQueryString();
		String username = request.getParameter("name");
		String password = request.getParameter("password");

		if(LoginInfoDAO.verifyuser(username, password)){
			HttpSession session = request.getSession();
			session.setAttribute("userid", UserDAO.getUserByUsername(username).getUser_id());
			out.print(UserService.getUserJson(username));
		}
		else {
			response.setStatus(404);
		}
}
}
