package model.anagrafica.veterinari;

import model.anagrafica.Persona;

/**
 * la classe veterinari rappresenta l'entita veterinari del veterinario
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * 
 */

public class Veterinari extends Persona {
	private String PIVA;
	private String contratto;
	private double stipendio;
	private double commissioni;
	private String IBAN;

	/**
	 * ritona la PIVA del veterinario
	 * 
	 * @return String PIVA
	 */
	public String getPIVA() {
		return PIVA;
	}

	/**
	 * ritona il comtratto del veterinario
	 * 
	 * @return String contratto
	 */
	public String getContratto() {
		return contratto;
	}

	/**
	 * ritona lo stipendio del veterinario
	 * 
	 * @return String stipendio
	 */
	public double getStipendio() {
		return stipendio;
	}

	/**
	 * ritona le commissioni del veterinario
	 * 
	 * @return String commissioni
	 */
	public double getCommissioni() {
		return commissioni;
	}

	/**
	 * ritona l'IBAN del veterinario
	 * 
	 * @return String IBAN
	 */
	public String getIBAN() {
		return IBAN;
	}

	/**
	 * setta piva veterinario
	 * 
	 * @param piva
	 */
	public void setPIVA(String pIVA) {
		PIVA = pIVA;
	}

	/**
	 * setta tipo contratto veterinario
	 * 
	 * @param contratto (tipo)
	 */
	public void setContratto(String contratto) {
		this.contratto = contratto;
	}

	/**
	 * setta stipendio veterinario
	 * 
	 * @param stipendio
	 */
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	/**
	 * setta commissioni veterinario
	 * 
	 * @param commissioni
	 */
	public void setCommissioni(double commissioni) {
		this.commissioni = commissioni;
	}

	/**
	 * setta iban veterinario
	 * 
	 * @param iban
	 */
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	/**
	 * costruttore
	 * 
	 * @param nome
	 * @param cognome
	 * @param cF
	 * @param email
	 * @param cellulare
	 * @param citta
	 * @param indirizzo
	 * @param pIVA
	 * @param contratto
	 * @param stipendio
	 * @param commissioni
	 * @param iBAN
	 */
	public Veterinari(String nome, String cognome, String cF, String email, String cellulare, String citta,
			String indirizzo, String pIVA, String contratto, double stipendio, double commissioni, String iBAN) {
		super(nome, cognome, cF, email, cellulare, citta, indirizzo);
		PIVA = pIVA;
		this.contratto = contratto;
		this.stipendio = stipendio;
		this.commissioni = commissioni;
		IBAN = iBAN;
	}

	@Override
	public String toString() {
		return "Veterinari " + super.toString() + "[PIVA=" + PIVA + ", contratto=" + contratto + ", stipendio="
				+ stipendio + ", commissioni=" + commissioni + ", IBAN=" + IBAN + "]";
	}

}
