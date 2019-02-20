package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Prenotazione;
import model.Veicolo;
import persistence.DAOFactory;
import persistence.dao.PrenotazioneDao;

/**
 * Servlet implementation class prenotazioneServlet
 */
@SuppressWarnings("serial")
@WebServlet("/prenotazione")
public class prenotazioneServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("SERVLETPRENOTAZIONE");

		Date date1 = new Date();
		int dd, mm, aaaa;
		dd = date1.getDate();
		mm = date1.getMonth()+1;
		aaaa = date1.getYear();
		System.out.println("Giorno: "+dd+" Mese: "+mm+" Anno: "+aaaa);


		HttpSession session=req.getSession();
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDAO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataInizio = null;
		Date dataFine = null;
		try {
			dataInizio = sdf.parse((String) session.getAttribute("dataInizio"));
			dataFine = sdf.parse((String) session.getAttribute("dataFine"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
//		System.out.println(session.getAttribute("idutente"));
		Prenotazione prenotazione=new Prenotazione( (int) session.getAttribute("idutente"), date1 , dataInizio, dataFine,
									(Veicolo)session.getAttribute("veicolo"));
		
		prenotazione.setTarga(((Veicolo) session.getAttribute("veicolo")).getTarga());
		
		prenotazioneDao.save(prenotazione);
//		System.out.println(prenotazione.getIdPrenotazione()+"id prenotazione");
		session.setAttribute("idprenotazione", prenotazione.getIdPrenotazione());
		PrintWriter out=resp.getWriter();
		out.write(String.valueOf(prenotazione.getIdPrenotazione()));
//		System.out.println(prenotazione.getPrezzo()+"2ewewa ");
		session.setAttribute("prezzo", prenotazione.getPrezzo());
		
		
	}
	
}
