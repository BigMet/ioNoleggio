package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utente;
import persistence.DAOFactory;
import persistence.dao.UtenteDao;


/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	

	
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession session = req.getSession();
	String paramEmail= req.getParameter("email");
	String paramPassword = req.getParameter("password");
	
	session.setAttribute("loggato", false);

	
	System.out.println(paramEmail+" "+paramPassword);
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	UtenteDao utenteDao = factory.getUtenteDAO();
	Utente utente = utenteDao.findByCredential(paramEmail, paramPassword);
	
	if(utente!=null && utente.getRegistrato()) { // abbiamo già l'utente nel DB
		session.setAttribute("password", paramPassword);
		session.setAttribute("email", utente.getEmail());
		session.setAttribute("loggato", true);
		session.setAttribute("nome", utente.getNome());
		session.setAttribute("idutente", utente.getIdUtente());
		session.setAttribute("cognome", utente.getCognome());
		session.setAttribute("indirizzo", utente.getIndirizzo());
		session.setAttribute("telefono", utente.getNumCellulare());
//		if(utente.getNumPatente()=="")
//			session.setAttribute("numpatente", "/-----------/");
//		else
			session.setAttribute("numpatente", utente.getNumPatente());
		
		
		session.setAttribute("datadinascita", utente.getDataNascita());
		RequestDispatcher disp;
		
		if(!utente.getAdmin()) {
			session.setAttribute("admin", false);

			disp = req.getRequestDispatcher("index.jsp");
			disp.forward(req, resp);
		}else {
			session.setAttribute("admin", true);
			disp = req.getRequestDispatcher("indexAdmin.jsp");
			disp.forward(req, resp);
			
		}
		
	}else {
		
		resp.sendRedirect("provaLogin.jsp");
		
	}
	
	
}

}
