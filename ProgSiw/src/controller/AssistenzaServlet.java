package controller;

import java.io.IOException;
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


@SuppressWarnings("serial")
@WebServlet("/assistenzaServlet")
public class AssistenzaServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String paramEmail= req.getParameter("email");
	 	String paramNome = req.getParameter("name");
	 	String paramOggetto = req.getParameter("subject");
	 	String paramMessaggio = req.getParameter("message");
	 	sendEmail(paramEmail,paramNome,paramOggetto,paramMessaggio);
	 	resp.sendRedirect("contatti.jsp");
	}
	 public void sendEmail(String userEmail, String name, String subject1,String message) {
		 try{
			 	String host ="smtp.gmail.com" ;
	            String user = "siwmail001@gmail.com";
	            String pass = "Sistemiperilweb.";
	            String to = "ionoleggioassistenza@gmail.com";
	            String from = "siwmail001@gmail.com";
	            String subject = subject1;
	            String messageText = message+"\n Inviato Da: "+name+" con email: "+userEmail;
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
