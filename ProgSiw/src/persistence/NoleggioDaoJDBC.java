package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Noleggio;
import persistence.dao.NoleggioDao;
import persistence.dao.PrenotazioneDao;
import persistence.dao.VeicoloDao;

public class NoleggioDaoJDBC implements NoleggioDao{

	private DataSource dataSource;

	public NoleggioDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Noleggio noleggio) {
		Connection connection = this.dataSource.getConnection();
		try {
			int id = IdBroker.getId(connection);
			noleggio.setId(id);
			String insert = "insert into noleggio(id, prenotazione,veicolo,stato) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setInt(1, noleggio.getId());
			statement.setInt(2, noleggio.getPrenotazione().getIdPrenotazione());
			statement.setString(3, noleggio.getVeicolo().getTarga());
			statement.setString(4, noleggio.getStato());	
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
	public Noleggio findByPrimaryKey(int id) {
		Connection connection = this.dataSource.getConnection();
		Noleggio noleggio = null;
		try {
			PreparedStatement statement;
			String query = "select * from noleggio where id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				noleggio = new Noleggio();
				noleggio.setId(result.getInt("id"));
				noleggio.getPrenotazione().setIdPrenotazione(result.getInt("prenotazione"));
				noleggio.getVeicolo().setTarga(result.getString("targa"));	
				noleggio.setStato(result.getString("stato"));
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
		return noleggio;
	}

	@Override
	public List<Noleggio> findAll() {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
	 	VeicoloDao veicoloDao = factory.getVeicoloDAO();
	 	PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDAO();
		Connection connection = this.dataSource.getConnection();
		List<Noleggio> noleggi = new LinkedList<>();
		try {
			Noleggio noleggio;
			PreparedStatement statement;
			String query = "select * from noleggio";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				noleggio = new Noleggio();
				noleggio.setId(result.getInt("id"));
				noleggio.setPrenotazione(prenotazioneDao.findByPrimaryKey(result.getInt("prenotazione")));
				noleggio.setVeicolo(veicoloDao.findByPrimaryKey(result.getString("veicolo")));
				noleggio.setStato(result.getString("stato"));
				noleggi.add(noleggio);
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
		return noleggi;
	}

	@Override
	public void update(Noleggio noleggio) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update noleggio SET prenotazione = ?, veicolo = ?, stato = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, noleggio.getPrenotazione().getIdPrenotazione());
			statement.setString(2, noleggio.getVeicolo().getTarga());
			statement.setString(3, noleggio.getStato());
			statement.setInt(4,noleggio.getId());
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
	public void delete(Noleggio noleggio) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM noleggio WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, noleggio.getId());
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

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	
}
