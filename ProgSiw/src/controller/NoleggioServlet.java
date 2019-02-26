package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Noleggio;
import persistence.DAOFactory;
import persistence.dao.NoleggioDao;

/**
 * Servlet implementation class NoleggioServlet
 */
@SuppressWarnings("serial")
@WebServlet("/noleggioServlet")
public class NoleggioServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	 	NoleggioDao noleggioDao = factory.getNoleggioDAO();
	 	List <Noleggio> noleggi = noleggioDao.findAll();
	 	
	 	session.setAttribute("noleggi", noleggi);
	 	RequestDispatcher disp;
	 	disp = req.getRequestDispatcher("noleggi.jsp");
		disp.forward(req, resp);
	
	
	}

}
