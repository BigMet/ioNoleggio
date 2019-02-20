package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javafx.util.Pair;


@SuppressWarnings("serial")
@WebServlet("/catalogo")
public class catalogoServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
//		System.out.println("partita servlet di catalogo");
		
		String paramStart= req.getParameter("trip-start");
		String paramEnd = req.getParameter("trip-end");
		session.setAttribute("dataInizio", paramStart);
		session.setAttribute("dataFine", paramEnd);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataInizio = null;
		Date dataFine = null;
		try {
			dataInizio = sdf.parse(paramStart);
			dataFine = sdf.parse(paramEnd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//int giorni = dataFine.getDay()-dataInizio.getDay();
		long diff = dataFine.getTime() - dataInizio.getTime();
		int giorni=(int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		session.setAttribute("giorni", giorni);
		
		
		RequestDispatcher disp;
		if(giorni<=0) {
			disp = req.getRequestDispatcher("index.jsp");
			disp.forward(req, resp);
		}else {
			if((Boolean)session.getAttribute("admin")==false) {
			disp = req.getRequestDispatcher("catalogo.jsp");
			}
			else
			disp = req.getRequestDispatcher("registrazioneWalkin.jsp");
			disp.forward(req, resp);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
