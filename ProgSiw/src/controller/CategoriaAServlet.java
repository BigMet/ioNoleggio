package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class CategoriaAServlet
 */
@SuppressWarnings("serial")
@WebServlet("/categoriaA")
public class CategoriaAServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		VeicoloDao veicoloDao = factory.getVeicoloDAO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataInizioTmp = null;
		Date dataFineTmp = null;
		try {
			dataInizioTmp = sdf.parse((String) session.getAttribute("dataInizio"));
			dataFineTmp = sdf.parse((String) session.getAttribute("dataFine"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Veicolo veicolo = veicoloDao.findOneByCategory(req.getParameter("categ"),dataInizioTmp,dataFineTmp);
		session.setAttribute("categoria",req.getParameter("categ") );
		RequestDispatcher disp;
		PrintWriter out=resp.getWriter();
		
		if(veicolo==null) {
//			System.out.println("nessun veicolo trovato andiamo su un'altra servlet");
			disp = req.getRequestDispatcher("categoriaB");
			disp.forward(req, resp);
		}
		else {
			session.setAttribute("veicolo", veicolo);
			if(session.getAttribute("loggato")==null) {
				out.write("noLog");
				return;
			}
//			System.out.println("popup veicolo");
			int prezzoFinale=(int) ((int) session.getAttribute("giorni")*veicolo.getPrezzo());
			out.write(String.valueOf(prezzoFinale));
//			System.out.println(prezzoFinale);
//		disp = req.getRequestDispatcher("profiloVeicolo.jsp");
//		disp.forward(req, resp);
		}
		
	}
	

}
