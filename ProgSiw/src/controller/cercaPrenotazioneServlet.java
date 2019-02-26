package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Noleggio;
import model.Utente;
import persistence.DAOFactory;
import persistence.dao.NoleggioDao;
import persistence.dao.PrenotazioneDao;
import persistence.dao.UtenteDao;
import persistence.dao.VeicoloDao;

/**
 * Servlet implementation class cercaPrenotazioneServlet
 */
@SuppressWarnings("serial")
@WebServlet("/cercaPrenotazione")
public class cercaPrenotazioneServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
//		System.out.println(req.getParameter("idP"));
		int paramIdPrenotazione= Integer.parseInt(req.getParameter("idP"));
		Boolean presente=false;
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDAO();
		NoleggioDao noleggioDao = factory.getNoleggioDAO();
		List<Noleggio> noleggi = noleggioDao.findAll();
		for (Noleggio n : noleggi) {
			if(n.getPrenotazione().getIdPrenotazione()==paramIdPrenotazione) {
				presente=true;
				break;
			}
		}
		PrintWriter out=resp.getWriter();
		
		if(prenotazioneDao.findByPrimaryKey(paramIdPrenotazione)==null)
			out.write("notfound");
		else if(presente)
			out.write("presente");
		else {
			out.write(String.valueOf(prenotazioneDao.findByPrimaryKey(paramIdPrenotazione).getPrezzo()));
		}

		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String paramNumPatente = req.getParameter("nP");
		String paramCarta=req.getParameter("nC");
		int paramIdPrenotazione= Integer.parseInt(req.getParameter("idP"));
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDAO();
		UtenteDao utenteDao = factory.getUtenteDAO();
		VeicoloDao veicoloDao = factory.getVeicoloDAO();
		NoleggioDao noleggioDao=factory.getNoleggioDAO();
		Noleggio noleggio=new Noleggio(prenotazioneDao.findByPrimaryKey(paramIdPrenotazione), veicoloDao.findByPrimaryKey(prenotazioneDao.findByPrimaryKey(paramIdPrenotazione).getTarga()));
		noleggio.setStato("IN CORSO");
		Utente temp = utenteDao.findByPrimaryKey(prenotazioneDao.findByPrimaryKey(paramIdPrenotazione).getIdCliente());
		
		temp.setNumPatente(paramNumPatente);
		temp.setNumCartaCredito(paramCarta);
		System.out.println(paramNumPatente);
		System.out.println(paramCarta);
		utenteDao.update(temp);
		noleggioDao.save(noleggio);
		
		
		
	}

}
