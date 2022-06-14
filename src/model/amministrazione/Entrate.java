package model.amministrazione;


/**
 * la classe entrate rappresenta i guadagni della clinica 
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * 
 */

public class Entrate {

	private int ID;
	private String tipo;
	private double prezzo;
	private String causa;
	private java.sql.Date data;

	/**
	 * ritorna il codice delle entrate
	 * @return int ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * ritorna il prezzo delle entrate
	 * @return double prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}
	
	/**
	 * ritorna il causa delle entrate
	 * @return String causa
	 */
	public String getCausa() {
		return causa;
	}
	
	/**
	 * assegna il codice delle entrate
	 * @param iD codice delle entrate
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * assegna il prezzo delle entrate
	 * @param prezzo prezzo delle entrate
	 */
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * assegna causa delle entrate
	 * @param causa il motivo delle entrate
	 */
	public void setCausa(String causa) {
		this.causa = causa;
	}
 
	/**
	 * ritorna il tipo di entrata
	 * @return String tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * assegna il tipo di entrata
	 * @param tipo specifica l'entrata
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * ritorna la data dell' entrata
	 * @return Date data
	 */
	public java.sql.Date getData() {
		return data;
	}

	/**
	 * costruttore
	 * @param iD
	 * @param tipo
	 * @param prezzo
	 * @param causa
	 * @param data
	 */
	public Entrate(int iD, String tipo, double prezzo, String causa, java.sql.Date data) {
		super();
		ID = iD;
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.causa = causa;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Entrate [ID=" + ID + ", tipo=" + tipo + ", prezzo=" + prezzo + ", causa=" + causa + "]";
	}

}
