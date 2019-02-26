package model;

public class Noleggio {

//	
//	private int idPrenotazione; // il progressivo della prenotazione
//	private String targaVeicolo; // la targa del veicoloPrenotato
	
	private int id;
	private Prenotazione prenotazione;
	private Veicolo veicolo;
	private String stato;
	
	

	public Noleggio(Prenotazione prenotazione, Veicolo veicolo) {
		super();
		this.prenotazione = prenotazione;
		this.veicolo = veicolo;
		this.stato = "";
		
	}
	
	
	public Noleggio() {
	}



	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Prenotazione getPrenotazione() {
		return prenotazione;
	}
	
	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}
	
	public Veicolo getVeicolo() {
		return veicolo;
	}
	
	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}
	
	

	public String getStato() {
		return stato;
	}


	public void setStato(String stato) {
		this.stato = stato;
	}


	@Override
	public String toString() {
		return "Noleggio [id=" + id + ", prenotazione=" + prenotazione + ", veicolo=" + veicolo + ", stato=" + stato
				+ "]";
	}
	
	
	
}
