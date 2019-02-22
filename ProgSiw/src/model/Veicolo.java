package model;

import java.util.Date;

public class Veicolo {

	private String targa; // la mia chiave primaria
	private String categoria; // identificata da una lettera
	private float prezzo;
	private String casaProduttrice;
	private String statoVeicolo;
	private String modello;
	private Date dataAcquisto;
	
	
	
	public Veicolo(String targa, String categoria, String casaProduttrice, String modello, 
			Date dataAcquisto) {
		super();
		this.targa = targa;
		this.categoria = categoria;
		this.casaProduttrice = casaProduttrice;
		this.modello = modello;
		this.dataAcquisto = dataAcquisto;
		this.statoVeicolo = "DISPONIBILE";
		
		if(this.categoria == "a" || this.categoria == "A")
			this.prezzo = 12f;
		
		else if(this.categoria == "b" || this.categoria == "B")
			this.prezzo = 18f;
		
		else if(this.categoria == "c" || this.categoria == "C")
			this.prezzo = 22f;
		
		else if(this.categoria == "d" || this.categoria == "D")
			this.prezzo = 30f;
		
		else if(this.categoria == "i" || this.categoria == "I")
			this.prezzo = 38f;
		
		else if(this.categoria == "p" || this.categoria == "P")
			this.prezzo = 33f;
		
		
		
	}
	
	public Veicolo() {
	}


	public String getTarga() {
		return targa;
	}


	public void setTarga(String targa) {
		this.targa = targa;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getcasaProduttrice() {
		return casaProduttrice;
	}


	public void setcasaProduttrice(String casaProduttrice) {
		this.casaProduttrice = casaProduttrice;
	}


	public String getModello() {
		return modello;
	}


	public void setModello(String modello) {
		this.modello = modello;
	}



	public Date getDataAcquisto() {
		return dataAcquisto;
	}


	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}



	public float getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}



	public String getCasaProduttrice() {
		return casaProduttrice;
	}



	public void setCasaProduttrice(String casaProduttrice) {
		this.casaProduttrice = casaProduttrice;
	}



	public String getStatoVeicolo() {
		return statoVeicolo;
	}



	public void setStatoVeicolo(String statoVeicolo) {
		this.statoVeicolo = statoVeicolo;
	}



	@Override
	public String toString() {
		return "Veicolo [targa=" + targa + ", categoria=" + categoria + ", prezzo=" + prezzo + ", casaProduttrice="
				+ casaProduttrice + ", statoVeicolo=" + statoVeicolo + ", modello=" + modello + ", dataAcquisto="
				+ dataAcquisto + "]";
	}
	
	
	
	
	
	
}
