package persistence;


import persistence.dao.NoleggioDao;
import persistence.dao.PrenotazioneDao;
import persistence.dao.UtenteDao;
import persistence.dao.VeicoloDao;

public abstract class DAOFactory {

	public static final int HSQLDB = 1;
	
	public static final int POSTGRESQL = 2;

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch ( whichFactory ) {
		
		case HSQLDB:
			return null;//new HsqldbDAOFactory();
		case POSTGRESQL:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}
	
	
	// ad esempio domenico aveva printerDao e ordineDao
	public abstract UtenteDao getUtenteDAO();
	
	public abstract VeicoloDao getVeicoloDAO();

	public abstract NoleggioDao getNoleggioDAO();

	public abstract PrenotazioneDao getPrenotazioneDAO();
	
	public abstract UtilDao getUtilDAO();
	
}
