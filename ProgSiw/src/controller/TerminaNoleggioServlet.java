package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noleggio;
import model.Veicolo;
import persistence.DAOFactory;
import persistence.dao.NoleggioDao;
import persistence.dao.VeicoloDao;

/**
 * Servlet implementation class TerminaNoleggioServlet
 */
@WebServlet("/terminaNoleggio")
public class TerminaNoleggioServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String paramTarga= req.getParameter("targave");
	String disponibile = req.getParameter("disponibile");
	Boolean presente=false;
	DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
 	NoleggioDao noleggioDao = factory.getNoleggioDAO();
 	VeicoloDao veicoloDao = factory.getVeicoloDAO();
 	List<Noleggio> noleggi=noleggioDao.findAll();
 	Noleggio temp;
 	for (Noleggio n : noleggi) {
		if(n.getVeicolo().getTarga().equals(paramTarga)) {
			presente=true;
			temp=n;
			break;
		}
	}
 	PrintWriter out=resp.getWriter();
 	if(presente) {
 		Veicolo up=veicoloDao.findByPrimaryKey(paramTarga);
 		if(disponibile.equals("true")) 
 			up.setStatoVeicolo("DISPONIBILE");
 		
 		else
 			up.setStatoVeicolo("INDISPONIBILE");
 		
 		veicoloDao.update(up);
 		out.write("noleggioTerminato");
 			
 	}
 	else
 		out.write("veicoloInesistente");
 	
}

}
