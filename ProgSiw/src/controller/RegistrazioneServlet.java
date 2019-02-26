package controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
	 	

	 	if(paramNome=="" || paramCognome=="" || paramPassword=="" || paramEmail=="" || paramIndirizzo=="")
	 		resp.sendRedirect("registrazione.jsp");
	 	
	 else {
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
	 		sendEmail(paramEmail);
	 		resp.sendRedirect("provaLogin.jsp");
	 	}else {
	 		resp.sendRedirect("registrazione.jsp");
	 	}
	 }
	 	
	}
	 	
	 	
	 public void sendEmail(String userEmail) {
		 try{
			 	String host ="smtp.gmail.com" ;
	            String user = "siwmail001@gmail.com";
	            String pass = "Sistemiperilweb.";
	            String to = userEmail;
	            String from = "siwmail001@gmail.com";
	            String subject = "Inviata da progetto SIW";
	            String messageText = "Questa è una mail inviata dal servizio mail di SIW, congratulazioni la registrazione è stata effettuata con Successo";
	            boolean sessionDebug = false;

	            Properties props = System.getProperties();

	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.starttls.required", "true");

//	            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	            Session mailSession = Session.getDefaultInstance(props, null);
	            mailSession.setDebug(sessionDebug);
	            Message msg = new MimeMessage(mailSession);
	            msg.setFrom(new InternetAddress(from));
	            InternetAddress[] address = {new InternetAddress(to)};
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.setSubject(subject); msg.setSentDate(new Date());
	            msg.setText(messageText);

	           Transport transport=mailSession.getTransport("smtp");
	           transport.connect(host, user, pass);
	           transport.sendMessage(msg, msg.getAllRecipients());
	           transport.close();
	           System.out.println("Messaggio inviato correttamente");
	        }catch(Exception ex)
	        {
	            System.out.println(ex+"problema nell'invio la mail");
	        }
	 }

}
