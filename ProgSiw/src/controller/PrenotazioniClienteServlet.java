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

import model.Prenotazione;
import persistence.DAOFactory;
import persistence.dao.PrenotazioneDao;

/**
 * Servlet implementation class PrenotazioniClienteServlet
 */
@SuppressWarnings("serial")
@WebServlet("/prenotazioniCliente")
public class PrenotazioniClienteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	 	PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDAO();
	 	List <Prenotazione> prenotazioni = prenotazioneDao.findByCredential((int) session.getAttribute("idutente"));
	 	session.setAttribute("prenotazioni", prenotazioni);
	 	RequestDispatcher disp;
	 	disp = req.getRequestDispatcher("prenotazioni.jsp");
		disp.forward(req, resp);
	
	
	}

}