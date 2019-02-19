package model;

public class Noleggio {

//	
//	private int idPrenotazione; // il progressivo della prenotazione
//	private String targaVeicolo; // la targa del veicoloPrenotato
	
	private int id;
	private Prenotazione prenotazione;
	private Veicolo veicolo;
	

	public Noleggio(Prenotazione prenotazione, Veicolo veicolo) {
		super();
		this.prenotazione = prenotazione;
		this.veicolo = veicolo;
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
	
	@Override
	public String toString() {
		return "Noleggio [id=" + id + ", prenotazione=" + prenotazione + ", veicolo=" + veicolo + "]";
	}
	
	
}
