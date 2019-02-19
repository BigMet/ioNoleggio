package model;

import java.util.Calendar;
import java.util.Date;

public class Utente {
	
	
	private int idUtente;
	private String email; // essendo univoca è la nostra chiave primaria
	private String nome;
	private String cognome;
	private String password;
	private String indirizzo;
	private String codiceFiscale;
	private String numCartaCredito;
	private String numPatente;
	private Date dataNascita;
	private String numCellulare;
	private boolean admin ;
	private boolean registrato;
	
	
	public Utente(String email, String nome, String cognome, String password, String indirizzo, String codiceFiscale,
			String numCartaCredito, String numPatente, Date dataNascita, String numCellulare,boolean admin) {
		super();
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.indirizzo = indirizzo;
		this.codiceFiscale = codiceFiscale;
		this.numCartaCredito = numCartaCredito;
		this.numPatente = numPatente;
		this.dataNascita = dataNascita;
		this.numCellulare = numCellulare;
		this.admin = admin;
		this.registrato = true;
		
	}

	
	public Utente() {
		this.email = "";
		this.nome = "";
		this.cognome = "";
		this.password = "";
		this.indirizzo = "";
		this.codiceFiscale = "";
		this.numCartaCredito = "";
		this.numPatente = "";
		this.numCellulare = "";
		this.admin = false;
		this.registrato = true;
		
		Calendar cal = Calendar.getInstance();
		cal.set(1995, Calendar.MARCH, 21);
		this.dataNascita = cal.getTime();
		
		
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}



	public String getNumCartaCredito() {
		return numCartaCredito;
	}


	public void setNumCartaCredito(String numCartaCredito) {
		this.numCartaCredito = numCartaCredito;
	}


	public String getNumPatente() {
		return numPatente;
	}


	public void setNumPatente(String numPatente) {
		this.numPatente = numPatente;
	}


	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getNumCellulare() {
		return numCellulare;
	}

	public void setNumCellulare(String numCellulare) {
		this.numCellulare = numCellulare;
	}

	public String getNumTelefono() {
		return numCellulare;
	}
	
	
	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setNumTelefono(String numCellulare) {
		this.numCellulare = numCellulare;
	}


	@Override
	public String toString() {
		return "Utente [email=" + email + ", nome=" + nome + ", cognome=" + cognome + ", password=" + password
				+ ", indirizzo=" + indirizzo + ", codiceFiscale=" + codiceFiscale + ", numCartaCredito="
				+ numCartaCredito + ", numPatente=" + numPatente + ", dataNascita=" + dataNascita + ", numCellulare="
				+ numCellulare + ", admin=" + admin + "]";
	}


	public int getIdUtente() {
		return idUtente;
	}


	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}


	public boolean getRegistrato() {
		return registrato;
	}


	public void setRegistrato(boolean registrato) {
		this.registrato = registrato;
	}

	

	
	
	
 
	

	
	
	

}
