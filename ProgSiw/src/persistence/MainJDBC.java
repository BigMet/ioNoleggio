package persistence;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Prenotazione;
import model.*;
import persistence.dao.*;


public class MainJDBC {

	public static void main(String args[]) throws FileNotFoundException {
		
		Calendar cal = Calendar.getInstance();
		cal.set(1996, Calendar.JANUARY, 1);  // 21 marzo 1995
		Date date1 = cal.getTime();
		
		cal.set(1997, Calendar.FEBRUARY, 3);  // 21 marzo 1995
		Date date2 = cal.getTime();
		
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		
//		util.resetDatabase();
//		util.dropDatabase();
//		util.createDatabase();
		
		
		UtenteDao utenteDao = factory.getUtenteDAO();
		
//		Utente utente1 = new Utente("utente", "Davide", "Perri", "pass", "n", "n", "n", "n", date1, "222",false);
//		Utente utenteAdmin = new Utente("admin", "Matteo", "Grande", "admin", "n", "n", "n", "n", date2, "333", true);
//		utenteDao.save(utente1);
//		utenteDao.save(utenteAdmin);
		


		// creo i veicoli
		
		VeicoloDao veicoloDao = factory.getVeicoloDAO();
		
		Veicolo veicolo1 = new Veicolo("aaaaaa", "A", "FIAT", "500", date1);
		Veicolo veicolo2 = new Veicolo("bbbbbb", "A", "PEUGEOT", "107", date1);
		Veicolo veicolo3 = new Veicolo("cccccc", "A", "OPEL", "adam", date1);
		Veicolo veicolo4 = new Veicolo("dddddd", "B", "FIAT", "panda", date1);
		Veicolo veicolo5 = new Veicolo("eeeeee", "B", "RENAULT", "clio", date1);
		Veicolo veicolo6 = new Veicolo("ffffff", "B", "TOYOTA", "yaris", date1);
		Veicolo veicolo7 = new Veicolo("gggggg", "C", "FORD", "fiesta", date1);
		Veicolo veicolo8 = new Veicolo("hhhhhh", "C", "CITROEN", "c3", date1);
		Veicolo veicolo9 = new Veicolo("iiiiii", "D", "AUDI", "A3", date1);
		Veicolo veicolo10 = new Veicolo("llllll","D", "VOLKSWAGEN", "golf",date1);
		
		
//		veicoloDao.save(veicolo1);		
//		veicoloDao.save(veicolo2);	
//		veicoloDao.save(veicolo3);		
//		veicoloDao.save(veicolo4);
//		veicoloDao.save(veicolo5);		
//		veicoloDao.save(veicolo6);
//		veicoloDao.save(veicolo7);		
//		veicoloDao.save(veicolo8);
//		veicoloDao.save(veicolo9);		
//		veicoloDao.save(veicolo10);
		
		
		// fine creazione veicoli
		
		
		
		
	 	PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDAO();
	 	List <Prenotazione> prenotazioni = prenotazioneDao.findAll();
		
	 	System.out.println(prenotazioni+"\r\n");
		
//		veicolo2=veicoloDao.findOneByCategory("A", , dataFine)

//		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDAO();
//		cal.set(2019, Calendar.FEBRUARY, 4);  // 21 marzo 1995
//		Date dataInizio = cal.getTime();
//		cal.set(2019, Calendar.FEBRUARY, 8);
//		Date dataFine =cal.getTime();
//		Prenotazione prenotazione1 = new Prenotazione(utente1.getIdUtente(), date1, dataInizio, dataFine, veicolo1);
//		prenotazione1.setTarga(veicolo1.getTarga());
//
//		prenotazioneDao.save(prenotazione1);
//		System.out.println(prenotazione1.toString());
//		prenotazioneDao.save(prenotazione2);
//
//		NoleggioDao noleggioDao = factory.getNoleggioDAO();
//		
//		Noleggio noleggio1 = new Noleggio(prenotazione1, veicolo1);
//		Noleggio noleggio2 = new Noleggio(prenotazione2, veicolo2);
//		
//		noleggioDao.save(noleggio1);
//		noleggioDao.save(noleggio2);
		
		

	}

}
