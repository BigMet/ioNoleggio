package persistence;

import persistence.dao.*;

public class PostgresDAOFactory extends DAOFactory {

	private static DataSource dataSource;
	private static PostgresDAOFactory factory;

	// --------------------------------------------

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			
		//remoto
		dataSource = new DataSource("jdbc:postgresql://packy.db.elephantsql.com:5432/ttywdcne", "ttywdcne", "WM0RwbB8eHKhElY7Vg8Vk7j6VjXbL8YH");
			
		//locale
//		dataSource=new DataSource("jdbc:postgresql://localhost:5432/CarRental","postgres","postgres");
		
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}
	

	public static PostgresDAOFactory getInstance(){
		if (factory == null){
			factory = new PostgresDAOFactory();
		}
		return factory;
	}
	// --------------------------------------------

	@Override
	public UtenteDao getUtenteDAO() {
		return new UtenteDaoJDBC(dataSource);
	}

	@Override
	public VeicoloDao getVeicoloDAO() {
		return new VeicoloDaoJDBC(dataSource);
	}


	@Override
	public NoleggioDao getNoleggioDAO() {
		return new NoleggioDaoJDBC(dataSource);
	}


	@Override
	public PrenotazioneDao getPrenotazioneDAO() {
		return new PrenotazioneDaoJDBC(dataSource);
	}

	@Override
	public UtilDao getUtilDAO() {
		return new UtilDao(dataSource);
	}


	


}
