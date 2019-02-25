package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.Veicolo;
import persistence.DAOFactory;
import persistence.dao.UtenteDao;
import persistence.dao.VeicoloDao;

/**
 * Servlet implementation class RegistaVeicoloServlet
 */
@SuppressWarnings("serial")
@WebServlet("/registraVeicolo")
public class RegistaVeicoloServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
	String paramTarga= req.getParameter("targa");
 	String paramCategoria = req.getParameter("categoria");
 	String paramData = req.getParameter("dataAcquisto");
 	String paramCasaProduttrice = req.getParameter("casaProduttrice");
 	String paramModello = req.getParameter("modello");
 	HttpSession session = req.getSession();
 	
 	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
 	VeicoloDao veicoloDao = factory.getVeicoloDAO();
 	
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
 		Date finale = null;
		try {
			finale = sdf.parse(paramData);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out=resp.getWriter();
 		Veicolo nuovoVeicolo=null;
 		nuovoVeicolo=veicoloDao.findByPrimaryKey(paramTarga);
 		if(nuovoVeicolo==null) {
 		nuovoVeicolo = new Veicolo(paramTarga, paramCategoria, paramCasaProduttrice, paramModello, finale);
 		veicoloDao.save(nuovoVeicolo);
 		out.write("veicoloAggiunto");
 		}
 		else
 			out.write("veicoloPresente");
 		
 		

}

}
