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
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		switch (actiontype) {
		case "101" : out.print(om.writeValueAsString(ReimbService.getTicketsByUserid(userid)));
		break;
		case "201": out.print(om.writeValueAsString(ReimbService.getAllTickets(userid)));
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reimb_id;
		Cookie c[] = request.getCookies();
		String actiontype = request.getParameter("actiontype");
		ObjectMapper om = new ObjectMapper();
		int userid = Integer.parseInt(c[0].getValue());
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		switch (actiontype) {
		case "210" : 
			reimb_id = Integer.parseInt(request.getParameter("reimb_id"));
			ReimbService.updateReimb(userid, reimb_id, 2);
			response.setStatus(200);
		break;
		case "220" : 
			reimb_id = Integer.parseInt(request.getParameter("reimb_id"));
			ReimbService.updateReimb(userid, reimb_id, 3);
			response.setStatus(200);
			break;
		case "102":
			int reimb_type_id = Integer.parseInt(request.getParameter("reimb_type_id"));
			Double reimb_amount = Double.parseDouble(request.getParameter("reimb_amount"));
			String reimb_description = request.getParameter("reimb_description");
			Boolean reimb_receipt = Boolean.parseBoolean(request.getParameter("reimb_receipt"));
			ReimbService.createReimb(userid, reimb_type_id, reimb_amount, reimb_description, reimb_receipt);
			response.setStatus(200);
			break;
			
		}
		
			
	}

}
