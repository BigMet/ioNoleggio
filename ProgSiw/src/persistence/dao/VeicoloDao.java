package persistence.dao;

import java.util.Date;
import java.util.List;

import model.Veicolo;


public interface VeicoloDao {
	public void save(Veicolo veicolo);  // Create
	public Veicolo findByPrimaryKey(String targa);     // Retrieve
	public List<Veicolo> findAll();       
	public void update(Veicolo veicolo); //Update
	public void delete(Veicolo veicolo); //Delete	
	
	public List<Veicolo> findByCategory(String categoria);
	public Veicolo findOneByCategory(String categoria, Date dataInizio, Date dataFine);
	
	
}
