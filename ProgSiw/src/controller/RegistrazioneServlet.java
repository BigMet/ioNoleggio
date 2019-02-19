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
import model.Utente;
import persistence.DAOFactory;
import persistence.dao.UtenteDao;

/**
 * Servlet implementation class RegistrazioneServlet
 */
@SuppressWarnings("serial")
@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet {
	
	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	String paramEmail= req.getParameter("email");
	 	String paramNome = req.getParameter("nome");
	 	String paramCognome = req.getParameter("cognome");
	 	String paramPassword = req.getParameter("password");
	 	String paramIndirizzo = req.getParameter("indirizzo");
	 	String paramCodiceFiscale = req.getParameter("codicefiscale");
	 	String paramNumCartaDiCredito = req.getParameter("numcartadicredito");
	 	String paramNumPatente = req.getParameter("numpatente");
	 	String paramDate = req.getParameter("datanascita");
	 	String paramNumTelefono = req.getParameter("numtelefono");
	 	

	 	
	 	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	 	UtenteDao utenteDao = factory.getUtenteDAO();
	 	Utente utente = utenteDao.findByEmail(paramEmail);
	 	
	 	if(utente==null) {
	 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 		boolean paramAdmin= Boolean.parseBoolean(req.getParameter("admin"));
	 		Date finale = null;
			try {
				finale = sdf.parse(paramDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		Utente nuovoUtente=new Utente(paramEmail,paramNome,paramCognome,paramPassword,paramIndirizzo,paramCodiceFiscale,paramNumCartaDiCredito,paramNumPatente,
	 				finale,paramNumTelefono,paramAdmin);
	 		utenteDao.save(nuovoUtente);
	 		resp.sendRedirect("provaLogin.jsp");
	 	}else {
	 		resp.sendRedirect("registrazione.jsp");
	 	}
	 	
	 	
	 	
	 }

}
