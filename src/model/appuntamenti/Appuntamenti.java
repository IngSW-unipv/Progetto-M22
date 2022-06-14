package model.appuntamenti;

import java.sql.Date;
import java.sql.Time;

import model.anagrafica.veterinari.Veterinari;
import model.pazienti.Paziente;
/** 
 * La classe appuntamenti definisce la prenotazione di una visita ad un paziente ad una data e ora.
 * Ne specifica il tipo, la sala, il costo e il veterinario che ka effettua.
 * Sarà presente una stringa per le eventuali note
 * 
 * @author MMA
 * version 1.0
 *
 */
public class Appuntamenti {

	private int COD;
	private Paziente paziente;
	private String sala;
	private String tipo;
	private Date data;
	private Time time;
	private Veterinari veterinario;
	private double costo;
	private String note;

	/**
	 * restituisce il codice
	 * @return int COD codice
	 */
	public int getCOD() {
		return COD;
	}

	/**
	 * assegna il codice
	 * @param cOD codice
	 */
	public void setCOD(int cOD) {
		COD = cOD;
	}

	/**
	 * restituisce il tipo
	 * @return String tipo tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * restituisce il paziente
	 * @return Paziente paziente
	 */
	public Paziente getPaziente() {
		return paziente;
	}

	/**
	 * restituisce il veterinario
	 * @return Veterinari veterinario
	 */
	public Veterinari getVeterinario() {
		return veterinario;
	}

	/**
	 * restituisce il costo
	 * @return double costo
	 */
	public double getCosto() {
		return costo;
	}
	
	/**
	 *  restituisce le note
	 * @return String note note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * restituisce la data
	 * @return Date data 
	 */
	public java.sql.Date getData() {
		return data;
	}

	/**
	 * restituisce la sala
	 * @return String sala
	 */
	public String getSala() {
		return sala;
	}

	/**
	 * restituisce l'ora
	 * @return Time time
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * costruttore
	 * @param int COD
	 * @param Paziente paziente
	 * @param String sala
	 * @param String tipo
	 * @param Date data
	 * @param Time time
	 * @param Veterinario veterinario
	 * @param double costo
	 * @param String note
	 */
	public Appuntamenti(int COD, Paziente paziente, String sala, String tipo, Date data, Time time,
			Veterinari veterinario, double costo, String note) {
		super();

		this.sala = sala;
		this.tipo = tipo;
		this.data = data;
		this.time = time;
		this.paziente = paziente;
		this.veterinario = veterinario;
		this.costo = costo;
		this.note = note;
		this.COD = COD;
	}

	/**
	 * stampa la stringa "visite" affiancata dai vari campi interessati
	 * @return String
	 */
	@Override
	public String toString() {
		return "Visite [paziente=" + paziente + ", sala=" + sala + ", tipo=" + tipo + ", data=" + data + ", time="
				+ time + ", veterinario=" + veterinario + ", costo=" + costo + ", note=" + note + "]";
	}

}
