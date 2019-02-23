package persistence.dao;

import java.util.List;

import model.Utente;

public interface UtenteDao {
	

	public void save(Utente utente);  // Create
	public Utente findByPrimaryKey(int id);
	public Utente findByEmail(String email);
	
	public List<Utente> findAll();       
	public void update(Utente utente); //Update
	public void delete(Utente utente); //Delete	
	public void deleteByMail(String email);
	
	public void setPassword(Utente utente, String password);
	public Utente findByCredential(String username, String password);
	
//	public static  UtenteCredenziali findByPrimaryKeyCredential(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}     // Retrieve

}
