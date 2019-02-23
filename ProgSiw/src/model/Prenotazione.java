package model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Prenotazione {

	private int idPrenotazione; // non è la mail ma un numero progressivo che ad ogni prenotazione aumenta
	private int idCliente; // la chiave primaria di cliente 
	private String targa;
	private float prezzo;
	private Date dataPrenotazione; 
	private Date dataInizioPrenotazione;
	private Date dataFinePrenotazione;
	
	
	public Prenotazione(int idCliente, Date dataPrenotazione, Date dataInizioPrenotazione,
		Date dataFinePrenotazione,Veicolo veicolo) {
		super();
		this.idCliente = idCliente;		
		this.dataPrenotazione = dataPrenotazione;
		this.dataInizioPrenotazione = dataInizioPrenotazione;
		this.dataFinePrenotazione = dataFinePrenotazione;
		
		this.prezzo = veicolo.getPrezzo()*this.getNumGiorni();
		//prezzo=(float) (Math.round(prezzo*Math.pow(10, 2)) / (Math.pow(10, 2)));
	}
	
	


	public Prenotazione() {
		super();
	}



	public int getIdPrenotazione() {
		return idPrenotazione;
	}




	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}





	public int getIdCliente() {
		return idCliente;
	}




	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}




	public float getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}


	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}


	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}


	public Date getDataInizioPrenotazione() {
		return dataInizioPrenotazione;
	}


	public void setDataInizioPrenotazione(Date dataInizio) {
		this.dataInizioPrenotazione = dataInizio;
	}


	public Date getDataFinePrenotazione() {
		return dataFinePrenotazione;
	}


	public void setDataFinePrenotazione(Date dataFine) {
		this.dataFinePrenotazione = dataFine;
	}
	
	


	public String getTarga() {
		return targa;
	}




	public void setTarga(String targa) {
		this.targa = targa;
	}




	public int getNumGiorni() {
		Date dataInizio = dataInizioPrenotazione;
		Date dataFine = dataFinePrenotazione;
	
		long diff = dataFine.getTime() - dataInizio.getTime();
		int giorni=(int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return giorni;
	}




	@Override
	public String toString() {
		return "Prenotazione [idPrenotazione=" + idPrenotazione + ", idCliente=" + idCliente + ", prezzo=" + prezzo
				+ ", dataPrenotazione=" + dataPrenotazione + ", dataInizioPrenotazione=" + dataInizioPrenotazione
				+ ", dataFinePrenotazione=" + dataFinePrenotazione + "]";
	}
	
	
}
