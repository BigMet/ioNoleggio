package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class WalkInServlet
 */
@SuppressWarnings("serial")
@WebServlet("/walkIn")
public class WalkInServlet extends HttpServlet {

	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	String paramEmail= req.getParameter("email");
	 	String paramNome = req.getParameter("first_name");
	 	String paramCognome = req.getParameter("last_name");
	 	String paramIndirizzo = req.getParameter("indirizzo");
	 	String paramCodiceFiscale = req.getParameter("codicefiscale");
	 	String paramNumCartaDiCredito = req.getParameter("cartaDc");
	 	String paramNumPatente = req.getParameter("numPatente");
	 	String paramDate = req.getParameter("datanascita");
	 	String paramNumTelefono = req.getParameter("phone_number");
	 	
	 	HttpSession session = req.getSession();
	 	
	 	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	 	UtenteDao utenteDao = factory.getUtenteDAO();
	 	
	 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 		boolean paramAdmin= Boolean.parseBoolean(req.getParameter("admin"));
	 		Date finale = null;
			try {
				finale = sdf.parse(paramDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		Utente nuovoUtente=new Utente(paramEmail,paramNome,paramCognome," ",paramIndirizzo,paramCodiceFiscale,paramNumCartaDiCredito,paramNumPatente,
	 				finale,paramNumTelefono,paramAdmin);
	 		nuovoUtente.setRegistrato(false);
	 		utenteDao.save(nuovoUtente);
	 		session.setAttribute("idutente", nuovoUtente.getIdUtente());
	 		resp.sendRedirect("catalogo.jsp");
	 	
	 	
	 	
	 	
	 }

}
