package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDao {

	private DataSource dataSource;
	
	public UtilDao(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	
	// elimina tutte le tabelle create in precedenza
public void dropDatabase(){
	
	Connection connection = dataSource.getConnection();
	try {
		String delete = "drop SEQUENCE if EXISTS sequenza_id;"
				+ "drop table if exists noleggio;"
				+ "drop table if exists veicolo;"
				+ "drop table if exists prenotazione;"
				+ "drop table if exists utente;";
		PreparedStatement statement = connection.prepareStatement(delete);
		
		statement.executeUpdate();
		System.out.println("Drop database eseguito");
		
	} catch (SQLException e) {
		
		throw new PersistenceException(e.getMessage());
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			
			throw new PersistenceException(e.getMessage());
		}
	}
}



public DataSource getDataSource() {
	return dataSource;
}

public void setDataSource(DataSource dataSource) {
	this.dataSource = dataSource;
}

public void createDatabase(){
	
	Connection connection = dataSource.getConnection();
	try {
		
		String create = "create SEQUENCE sequenza_id;"
				+ "create table utente(\"idutente\" bigint primary key, email varchar(255),nome varchar(255),cognome varchar(255),password varchar(255),indirizzo varchar(255),codiceFiscale varchar(255),numCartaDiCredito varchar(255),numPatente varchar(255),dataNascita DATE,numTelefono varchar(255), admin boolean, registrato boolean);"
				+ "create table prenotazione(\"id\" bigint primary key,idutente bigint,targa varchar(255),prezzo float,dataPrenotazione DATE,dataInizioPrenotazione DATE,dataFinePrenotazione DATE);"
				+ "create table veicolo(\"targa\" varchar(255) primary key,categoria varchar(255),prezzo float, casaproduttrice varchar(255),statoveicolo varchar(255), modello varchar(255),dataacquisto DATE);"
				+ "create table noleggio(\"id\" bigint primary key,prenotazione bigint, veicolo varchar(255));";
		PreparedStatement statement = connection.prepareStatement(create);
		
		statement.executeUpdate();
		System.out.println("Creazione database eseguita");
		
	} catch (SQLException e) {
		
		throw new PersistenceException(e.getMessage());
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			
			throw new PersistenceException(e.getMessage());
		}
	}
}

// elimina tutte le righe delle tabelle create
public  void resetDatabase() {
		
		Connection connection = dataSource.getConnection();
		try {
			String delete = "delete FROM utente";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			
			delete = "delete FROM prenotazione";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM noleggio";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM veicolo";
			statement = connection.prepareStatement(delete);
			
			
			statement.executeUpdate();
			System.out.println("Reset database eseguito");

		} catch (SQLException e) {
			
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				
				throw new PersistenceException(e.getMessage());
			}
		}
	}
}

