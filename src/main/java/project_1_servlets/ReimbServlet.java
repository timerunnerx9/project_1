package project_1_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import project_1_services.ReimbService;

@WebServlet("/ReimbServlet/*")
public class ReimbServlet extends HttpServlet {

//public static void main(String[] args) {
//	System.out.println(ReimbService.getTicketsByUserid(1));
//}
//	
	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Headers", "authorization");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.addHeader("Access-Control-Allow-Credentials", "true");

		super.service(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie c[] = request.getCookies();
		String actiontype = request.getParameter("actiontype");
		ObjectMapper om = new ObjectMapper();
		int userid = Integer.parseInt(c[0].getValue());
		System.out.println(userid);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		switch (actiontype) {
		case "101" : out.print(om.writeValueAsString(ReimbService.getTicketsByUserid(userid)));
		break;
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("it works");
	}

}
