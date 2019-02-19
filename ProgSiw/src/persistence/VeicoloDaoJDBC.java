package persistence;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import model.Veicolo;
import persistence.dao.VeicoloDao;

public class VeicoloDaoJDBC implements VeicoloDao {
	
	private DataSource dataSource;

	public VeicoloDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	@Override
	public void save(Veicolo veicolo) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into veicolo(targa, categoria,prezzo, casaproduttrice,statoveicolo, modello,dataacquisto) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setString(1, veicolo.getTarga());
			statement.setString(2, veicolo.getCategoria());
			statement.setFloat(3, veicolo.getPrezzo());
			statement.setString(4, veicolo.getcasaProduttrice());
			statement.setString(5, veicolo.getStatoVeicolo());
			statement.setString(6, veicolo.getModello());
			
			long secs = veicolo.getDataAcquisto().getTime();
			statement.setDate(7, new java.sql.Date(secs));
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
	public Veicolo findByPrimaryKey(String targa) {
		Connection connection = this.dataSource.getConnection();
		Veicolo veicolo= null;
		try {
			PreparedStatement statement;
			String query = "select * from veicolo where targa = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, targa);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				veicolo = new Veicolo();
				
				veicolo.setTarga(result.getString("targa"));
				veicolo.setCategoria(result.getString("categoria"));
				veicolo.setPrezzo(result.getFloat("prezzo"));

				veicolo.setcasaProduttrice(result.getString("casaproduttrice"));
				veicolo.setStatoVeicolo(result.getString("statoveicolo"));

				veicolo.setModello(result.getString("modello"));
				long secs = result.getDate("dataacquisto").getTime();
				veicolo.setDataAcquisto(new java.util.Date(secs));
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
		return veicolo;
	}

	@Override
	public List<Veicolo> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Veicolo> veicoli = new LinkedList<>();
		try {
			Veicolo veicolo;
			PreparedStatement statement;
			String query = "select * from veicolo";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				veicolo = new Veicolo();
				veicolo.setTarga(result.getString("targa"));
				veicolo.setCategoria(result.getString("categoria"));
				veicolo.setPrezzo(result.getFloat("prezzo"));
				veicolo.setcasaProduttrice(result.getString("casaproduttrice"));
				veicolo.setStatoVeicolo(result.getString("statoveicolo"));
				veicolo.setModello(result.getString("modello"));
				long secs = result.getDate("dataacquisto").getTime();
				veicolo.setDataAcquisto(new java.util.Date(secs));
				veicoli.add(veicolo);
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
		return veicoli;
	}

	@Override
	public void update(Veicolo veicolo) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update veicolo SET categoria = ?,prezzo=?,casaproduttrice = ?,statoveicolo=?,modello= ?,dataAcquisto = ? WHERE targa=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, veicolo.getTarga());
			statement.setString(2, veicolo.getCategoria());
			statement.setFloat(3, veicolo.getPrezzo());
			statement.setString(4, veicolo.getcasaProduttrice());
			statement.setString(5, veicolo.getStatoVeicolo());
			statement.setString(6, veicolo.getModello());
			
			long secs = veicolo.getDataAcquisto().getTime();
			statement.setDate(7, new java.sql.Date(secs));
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
	public void delete(Veicolo veicolo) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM veicolo WHERE targa = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, veicolo.getTarga());
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
	
	// da vedere cosa deve fare questo metodo

	@Override
	public List<Veicolo> findByCategory(String categoria) {
		Connection connection = this.dataSource.getConnection();
		List<Veicolo> veicoli =  new LinkedList<>();;
		try {
			PreparedStatement statement;
			String query = "select * from veicolo where categoria = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, categoria);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				Veicolo veicolo = new Veicolo();
				
				veicolo.setTarga(result.getString("targa"));
				veicolo.setCategoria(result.getString("categoria"));
				veicolo.setPrezzo(result.getFloat("prezzo"));

				veicolo.setcasaProduttrice(result.getString("casaproduttrice"));
				veicolo.setStatoVeicolo(result.getString("statoveicolo"));

				veicolo.setModello(result.getString("modello"));
				long secs = result.getDate("dataacquisto").getTime();
				veicolo.setDataAcquisto(new java.util.Date(secs));
				
				veicoli.add(veicolo);
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
		return veicoli;
	}


	@Override
	public Veicolo findOneByCategory(String categoria, Date dataInizio,Date dataFine) {
		Connection connection = this.dataSource.getConnection();
		Veicolo veicolo= null;
		try {
			PreparedStatement statement;
			String query = "select * from veicolo as v where v.categoria=? and v.targa not in (select targa from prenotazione where datainizioprenotazione>=? and datafineprenotazione<=?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, categoria);
			long secs = dataInizio.getTime();
			statement.setDate(2, new java.sql.Date(secs));
			secs = dataFine.getTime();
			statement.setDate(3, new java.sql.Date(secs));


			ResultSet result = statement.executeQuery();
			if (result.next()) {
				veicolo = new Veicolo();
				
				veicolo.setTarga(result.getString("targa"));
				veicolo.setCategoria(result.getString("categoria"));
				veicolo.setPrezzo(result.getFloat("prezzo"));

				veicolo.setcasaProduttrice(result.getString("casaproduttrice"));
				veicolo.setStatoVeicolo(result.getString("statoveicolo"));

				veicolo.setModello(result.getString("modello"));
				long marco = result.getDate("dataacquisto").getTime();
				veicolo.setDataAcquisto(new java.util.Date(marco));
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
		return veicolo;
	}

}
