package model.amministrazione;

import java.sql.Date;

/**
 * la classe uscite rappresenta le uscite della clinica 
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * 
 */

public class Uscite {

	private int ID;
	private double prezzo;
	private String causa;
	private Date data;
	private String tipo;

	/**
	 * restituisce il codice delle uscite
	 * @return int ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * assegna il codice delle uscite
	 * @param iD codice delle uscite
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * restituisce il tipo di entrata
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
	 * restituisce il prezzo delle uscite
	 * @return double prezzo
	 */
	public double getPrezzo() {
		return prezzo;
	}
	
	/**
	 * restituisce il causa delle uscite
	 * @return String causa
	 */
	public String getCausa() {
		return causa;
	}

	/**
	 * restituisce la data dell' uscita
	 * @return Date data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * controller
	 * @param iD
	 * @param causa
	 * @param tipo
	 * @param prezzo
	 * @param data
	 */
	public Uscite(int iD, String causa, String tipo, double prezzo, Date data) {
		super();
		ID = iD;
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.causa = causa;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Uscite [ID=" + ID + ", tipo=" + tipo + ", prezzo=" + prezzo + ", causa=" + causa + "]";
	}

}
