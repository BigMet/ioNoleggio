package controller;

import java.io.IOException;
import java.util.LinkedList;
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
 * Servlet implementation class NoleggioClienteServlet
 */
@SuppressWarnings("serial")
@WebServlet("/noleggioCliente")
public class NoleggioClienteServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	 	NoleggioDao noleggioDao = factory.getNoleggioDAO();
	 	List <Noleggio> noleggi = noleggioDao.findAll();
	 	List<Noleggio> daRimuovere=new LinkedList<Noleggio>();
	 	for (Noleggio n : noleggi) {
			if(n.getPrenotazione().getIdCliente()!=(int)session.getAttribute("idutente"))
				daRimuovere.add(n);
		}
	 	for (Noleggio n : daRimuovere) {
	 		noleggi.remove(n);
		}
	 	session.setAttribute("noleggi", noleggi);
	 	RequestDispatcher disp;
	 	disp = req.getRequestDispatcher("noleggi.jsp");
		disp.forward(req, resp);
	
	
	}

}
