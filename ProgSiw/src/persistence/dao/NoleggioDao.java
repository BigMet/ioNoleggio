package persistence.dao;

import java.util.List;

import model.Noleggio;

public interface NoleggioDao {

	public void save(Noleggio noleggio);  // Create
	Noleggio findByPrimaryKey(int id);
	public List<Noleggio> findAll();       
	public void update(Noleggio noleggio); //Update
	public void delete(Noleggio noleggio); //Delete	
}
