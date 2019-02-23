package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Utente;
import persistence.dao.UtenteDao;

public class UtenteDaoJDBC implements UtenteDao {
	
	private DataSource dataSource;

	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			int id = IdBroker.getId(connection);
			utente.setIdUtente(id);
			String insert = "insert into utente(email,idutente, nome, cognome, password, indirizzo, codiceFiscale, numCartaDiCredito, numPatente, dataNascita, numTelefono,admin,registrato) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getEmail());
			statement.setInt(2, utente.getIdUtente());
			statement.setString(3, utente.getNome());
			statement.setString(4, utente.getCognome());
			statement.setString(5, utente.getPassword());
			statement.setString(6, utente.getIndirizzo());
			statement.setString(7, utente.getCodiceFiscale());
			statement.setString(8, utente.getNumCartaCredito());
			statement.setString(9, utente.getNumPatente());
			statement.setDate(10, new java.sql.Date(utente.getDataNascita().getTime()));
			statement.setString(11, utente.getNumTelefono());
			statement.setBoolean(12, utente.getAdmin());
			statement.setBoolean(13, utente.getRegistrato());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("prob 2");
				throw new PersistenceException(e.getMessage());
			}
		}
	}  

	public Utente findByEmail(String email) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setEmail(result.getString("email"));
				utente.setIdUtente(result.getInt("idutente"));
				utente.setNome(result.getString("nome"));	
				utente.setCognome(result.getString("cognome"));				
				utente.setPassword(result.getString("password"));
				utente.setIndirizzo(result.getString("indirizzo"));
				utente.setCodiceFiscale(result.getString("codiceFiscale"));
				utente.setNumCartaCredito(result.getString("numCartaDiCredito"));
				utente.setNumPatente(result.getString("numPatente"));
				long secs = result.getDate("dataNascita").getTime();
				utente.setDataNascita(new java.util.Date(secs));
				utente.setNumTelefono(result.getString("numTelefono"));
				utente.setAdmin(result.getBoolean("admin"));
				utente.setRegistrato(result.getBoolean("registrato"));


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
		return utente;
	}
	
	public Utente findByPrimaryKey(int id) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where idutente = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setEmail(result.getString("email"));
				utente.setIdUtente(result.getInt("idutente"));
				utente.setNome(result.getString("nome"));	
				utente.setCognome(result.getString("cognome"));				
				utente.setPassword(result.getString("password"));
				utente.setIndirizzo(result.getString("indirizzo"));
				utente.setCodiceFiscale(result.getString("codiceFiscale"));
				utente.setNumCartaCredito(result.getString("numCartaDiCredito"));
				utente.setNumPatente(result.getString("numPatente"));
				long secs = result.getDate("dataNascita").getTime();
				utente.setDataNascita(new java.util.Date(secs));
				utente.setNumTelefono(result.getString("numTelefono"));
				utente.setAdmin(result.getBoolean("admin"));
				utente.setRegistrato(result.getBoolean("registrato"));


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
		return utente;
		
	}
	
	
	// restituisce l'utente cercando tramite mail e password
	public Utente findByCredential(String email,String password) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			
			PreparedStatement statement;
			String query = "select * from utente where email = ? and password = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setEmail(result.getString("email"));
				utente.setIdUtente(result.getInt("idutente"));
				utente.setNome(result.getString("nome"));	
				utente.setCognome(result.getString("cognome"));				
				utente.setPassword(result.getString("password"));
				utente.setIndirizzo(result.getString("indirizzo"));
				utente.setCodiceFiscale(result.getString("codiceFiscale"));
				utente.setNumCartaCredito(result.getString("numCartaDiCredito"));
				utente.setNumPatente(result.getString("numPatente"));
				long secs = result.getDate("dataNascita").getTime();
				utente.setDataNascita(new java.util.Date(secs));
				utente.setNumTelefono(result.getString("numTelefono"));
				utente.setAdmin(result.getBoolean("admin"));
				utente.setRegistrato(result.getBoolean("registrato"));
				
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
		return utente;
	}
	


	// restituisce tutta la lista di utente
	public List<Utente> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Utente> utenti = new LinkedList<>();
		try {
			Utente utente;
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new Utente();
				utente.setEmail(result.getString("email"));
				utente.setIdUtente(result.getInt("idutente"));
				utente.setNome(result.getString("nome"));	
				utente.setCognome(result.getString("cognome"));				
				utente.setPassword(result.getString("password"));
				utente.setIndirizzo(result.getString("indirizzo"));
				utente.setCodiceFiscale(result.getString("codiceFiscale"));
				utente.setNumCartaCredito(result.getString("numCartaDiCredito"));
				utente.setNumPatente(result.getString("numPatente"));
				long secs = result.getDate("dataNascita").getTime();
				utente.setDataNascita(new java.util.Date(secs));
				utente.setNumTelefono(result.getString("numTelefono"));
				utente.setAdmin(result.getBoolean("admin"));
				utente.setRegistrato(result.getBoolean("registrato"));


				utenti.add(utente);
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
		return utenti;
	}
	

	public void update(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET email = ?, nome = ?,cognome = ?,password = ?,indirizzo = ?,codiceFiscale = ?,numCartaDiCredito = ?,numPatente = ?,dataNascita = ?,numTelefono = ?, admin = ?, registrato=? WHERE idutente=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getEmail());
			statement.setString(2, utente.getNome());
			statement.setString(3, utente.getCognome());
			statement.setString(4, utente.getPassword());
			statement.setString(5, utente.getIndirizzo());
			statement.setString(6, utente.getCodiceFiscale());
			statement.setString(7, utente.getNumCartaCredito());
			statement.setString(8, utente.getNumPatente());
			statement.setDate(9, new java.sql.Date(utente.getDataNascita().getTime()));
			statement.setString(10, utente.getNumTelefono());
			statement.setBoolean(11, utente.getAdmin());
			statement.setBoolean(12, utente.getRegistrato());
			statement.setInt(13, utente.getIdUtente());
			System.out.println("aggiorno");
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

	public void delete(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM utente WHERE email = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, utente.getEmail());
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
	public void setPassword(Utente utente, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET password = ? WHERE email=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, utente.getEmail());
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
	public void deleteByMail(String email) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM utente WHERE email = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, email);
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

}
