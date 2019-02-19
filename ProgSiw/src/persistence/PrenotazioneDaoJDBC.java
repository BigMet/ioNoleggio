package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Prenotazione;
import persistence.dao.PrenotazioneDao;

public class PrenotazioneDaoJDBC implements PrenotazioneDao {
	
	private DataSource dataSource;
	

	public PrenotazioneDaoJDBC(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	
	@Override
	public void save(Prenotazione prenotazione) {
		Connection connection = this.dataSource.getConnection();
		try {
			int id = IdBroker.getId(connection);
			prenotazione.setIdPrenotazione(id);
			String insert = "insert into prenotazione(id, idutente,targa,prezzo,dataPrenotazione,dataInizioPrenotazione,dataFinePrenotazione) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setInt(1, prenotazione.getIdPrenotazione());
			statement.setInt(2, prenotazione.getIdCliente());
			statement.setString(3, prenotazione.getTarga());
			statement.setFloat(4, prenotazione.getPrezzo());
			
			statement.setDate(5, new java.sql.Date(prenotazione.getDataPrenotazione().getTime()));

			statement.setDate(6, new java.sql.Date(prenotazione.getDataInizioPrenotazione().getTime()));

			statement.setDate(7, new java.sql.Date(prenotazione.getDataFinePrenotazione().getTime()));

			statement.executeUpdate();
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

	@Override
	public Prenotazione findByPrimaryKey(int id) {
		Connection connection = this.dataSource.getConnection();
		Prenotazione prenotazione = null;
		try {
			PreparedStatement statement;
			String query = "select * from prenotazione where id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				prenotazione = new Prenotazione();
				prenotazione.setIdPrenotazione(result.getInt("id"));
				prenotazione.setIdCliente(result.getInt("idutente"));
				prenotazione.setTarga(result.getString("targa"));
				prenotazione.setPrezzo(result.getFloat("prezzo"));
				
				long secs = result.getDate("dataPrenotazione").getTime();
				prenotazione.setDataPrenotazione(new java.util.Date(secs));
				
				secs = result.getDate("dataInizioPrenotazione").getTime();
				prenotazione.setDataInizioPrenotazione(new java.util.Date(secs));
				
				secs = result.getDate("dataFinePrenotazione").getTime();
				prenotazione.setDataFinePrenotazione(new java.util.Date(secs));
				
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
		return prenotazione;
	}

	@Override
	public List<Prenotazione> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Prenotazione> prenotazioni = new LinkedList<>();
		try {
			Prenotazione prenotazione;
			PreparedStatement statement;
			String query = "select * from prenotazione";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				prenotazione = new Prenotazione();
				prenotazione.setIdPrenotazione(result.getInt("id"));
				prenotazione.setIdCliente(result.getInt("idutente"));
				prenotazione.setTarga(result.getString("targa"));
				prenotazione.setPrezzo(result.getFloat("prezzo"));
				
				long secs = result.getDate("dataPrenotazione").getTime();
				prenotazione.setDataPrenotazione(new java.util.Date(secs));
				
				secs = result.getDate("dataInizioPrenotazione").getTime();
				prenotazione.setDataInizioPrenotazione(new java.util.Date(secs));
				
				secs = result.getDate("dataFinePrenotazione").getTime();
				prenotazione.setDataFinePrenotazione(new java.util.Date(secs));
				
				prenotazioni.add(prenotazione);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return prenotazioni;
	}

	@Override
	public void update(Prenotazione prenotazione) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update prenotazione SET idcliente,prezzo = ?,dataPrenotazione= ?,dataInizioPrenotazione = ?,dataFinePrenotazione= ? WHERE idprenotazione=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, prenotazione.getIdPrenotazione());
			statement.setInt(2, prenotazione.getIdCliente());
			statement.setString(3, prenotazione.getTarga());
			statement.setFloat(4, prenotazione.getPrezzo());
			
			statement.setDate(5, new java.sql.Date(prenotazione.getDataPrenotazione().getTime()));

			statement.setDate(6, new java.sql.Date(prenotazione.getDataInizioPrenotazione().getTime()));

			statement.setDate(7, new java.sql.Date(prenotazione.getDataFinePrenotazione().getTime()));
			statement.executeUpdate();
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

	@Override
	public void delete(Prenotazione prenotazione) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM prenotazione WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, prenotazione.getIdPrenotazione());
			statement.executeUpdate();
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

	@Override
	public Prenotazione findByCredential(int idCliente) {
		Connection connection = this.dataSource.getConnection();
		Prenotazione prenotazione = null;
		try {
			PreparedStatement statement;
			String query = "select * from prenotazione where idcliente = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1,idCliente);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				prenotazione = new Prenotazione();
				prenotazione.setIdPrenotazione(result.getInt("id"));
				prenotazione.setIdCliente(result.getInt("idcliente"));
				prenotazione.setTarga(result.getString("targa"));
				prenotazione.setPrezzo(result.getFloat("prezzo"));
				
				long secs = result.getDate("dataPrenotazione").getTime();
				prenotazione.setDataPrenotazione(new java.util.Date(secs));
				
				secs = result.getDate("dataInizioPrenotazione").getTime();
				prenotazione.setDataInizioPrenotazione(new java.util.Date(secs));
				
				secs = result.getDate("dataFinePrenotazione").getTime();
				prenotazione.setDataFinePrenotazione(new java.util.Date(secs));
				
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
		return prenotazione;
	}

}
