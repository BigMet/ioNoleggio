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

import model.Veicolo;
import persistence.DAOFactory;
import persistence.dao.VeicoloDao;

/**
 * Servlet implementation class RimuoviVeicoloServlet
 */
@WebServlet("/rimuoviVeicolo")
public class RimuoviVeicoloServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramTarga= req.getParameter("targav");
	 	HttpSession session = req.getSession();
	 	System.out.println("Targa: "+paramTarga);
	 	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	 	VeicoloDao veicoloDao = factory.getVeicoloDAO();
		PrintWriter out=resp.getWriter();
	 	Veicolo nuovoVeicolo=null;
	 	nuovoVeicolo=veicoloDao.findByPrimaryKey(paramTarga);
	 	if(nuovoVeicolo==null) {
	 	out.write("veicoloInesistente");
	 	}
	 	else {
	 		veicoloDao.delete(nuovoVeicolo);
	 		out.write("veicoloRimosso");
	 	}	
	 		

	}
}
