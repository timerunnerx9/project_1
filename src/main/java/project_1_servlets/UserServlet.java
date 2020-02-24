package project_1_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import project_1_POJO.LoginInfo;
import project_1_services.UserService;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.addHeader("Access-Control-Allow-Headers", "*");
//		resp.addHeader("Access-Control-Allow-Headers", "authorization");
		resp.addHeader("Access-Control-Allow-Methods", "GET POST PUT DELETE");
		resp.addHeader("Access-Control-Allow-Origin", "*");
//		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		
		super.service(req, resp);
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(UserService.getUserJson("davecen9"));
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
//		LoginInfo loginInfo = new Gson().fromJson(request.getReader(), LoginInfo.class);
//		String username = loginInfo.getUsername();
//		String password = loginInfo.getUserPassword();
//		PrintWriter out = response.getWriter();
		System.out.println(request.getReader().readLine());
//		System.out.println(username);
//		System.out.println(password);
//		out.print(UserService.getUserJson("davecen9"));
//		out.flush();
//		out.append("trying");
	}

}
