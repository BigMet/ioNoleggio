package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class disconnectServlet
 */
@SuppressWarnings("serial")
@WebServlet("/disconnectServlet")
public class disconnectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		session.removeAttribute("email");
		session.removeAttribute("password");
		session.removeAttribute("loggato");
		session.removeAttribute("nome");
		session.removeAttribute("admin");
	
		
	
		RequestDispatcher disp;
		
		
			disp = req.getRequestDispatcher("index.jsp");
			disp.forward(req, resp);
	}



}
