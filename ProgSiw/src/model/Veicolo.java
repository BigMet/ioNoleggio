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
		
		System.out.println("categoria in costruttore " + categoria);
		
		if(this.categoria.equals("a")|| this.categoria.equals("A"))
			this.prezzo = 12f;
		
		else if(this.categoria.equals("b")|| this.categoria.equals("B"))
			this.prezzo = 18f;
		
		else if(this.categoria.equals("c")|| this.categoria.equals("C"))
			this.prezzo = 22f;
		
		else if(this.categoria.equals("d")|| this.categoria.equals("D"))
			this.prezzo = 30f;
		
		else if(this.categoria.equals("i")|| this.categoria.equals("I"))
			this.prezzo = 35f;
		
		else if(this.categoria.equals("p")|| this.categoria.equals("P"))
			this.prezzo = 33f;
		
		else if(this.categoria.equals("n")|| this.categoria.equals("N"))
			this.prezzo = 25f;
		
		else if(this.categoria.equals("l")|| this.categoria.equals("L"))
			this.prezzo = 48f;
		
		else if(this.categoria.equals("o")|| this.categoria.equals("O"))
			this.prezzo = 40f;
		
		
		
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

	
	
//	public float getPrezzoPerCategoria(String categoria) {
//		if(this.categoria == "a" || this.categoria == "A")
//			return 12f;
//		
//		else if(this.categoria == "b" || this.categoria == "B")
//			return 18f;
//		
//		else if(this.categoria == "c" || this.categoria == "C")
//			return 22f;
//		
//		else if(this.categoria == "d" || this.categoria == "D")
//			return 30f;
//		
//		else if(this.categoria == "i" || this.categoria == "I")
//			return 35f;
//		
//		else if(this.categoria == "p" || this.categoria == "P")
//			return 33f;
//		
//		else if(this.categoria == "n" || this.categoria == "N")
//			return 25f;
//		
//		else if(this.categoria == "l" || this.categoria == "L")
//			return 48f;
//		
//		else if(this.categoria == "o" || this.categoria == "O")
//			return 40f;
//		
//		return -1;
//	}


	@Override
	public String toString() {
		return "Veicolo [targa=" + targa + ", categoria=" + categoria + ", prezzo=" + prezzo + ", casaProduttrice="
				+ casaProduttrice + ", statoVeicolo=" + statoVeicolo + ", modello=" + modello + ", dataAcquisto="
				+ dataAcquisto + "]";
	}
	
	
	
	
	
	
}
