package model.anagrafica.fornitori;

/**
 * la classe fornitori rappresenta l'entita fornitori della clinica 
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * 
 */
public class Fornitori {

	private String PIVA;
	private String nomeAzienda;
	private String nTelefono;
	private String email;
	private String sede;
	private String IBAN;

	/**
	 * ritorna il nome della clinica
	 * @return String nomeAzienda
	 */
	public String getNomeAzienda() {
		return nomeAzienda;
	}

	/**
	 * ritona la PIVA della clinica
	 * @return String PIVA
	 */
	public String getPIVA() {
		return PIVA;
	}

	/**
	 * assegna la piva del fornitore
	 * @param pIVA è la piva del fornitore
	 */
	public void setPIVA(String pIVA) {
		PIVA = pIVA;
	}

	/**
	 * restituisce la mail
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * assegna la mail dei fornitori
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * resitiuisce la sede del fornitore
	 * @return String sede
	 */
	public String getSede() {
		return sede;
	}

	/**
	 * assegna  la sede del fornitore
	 * @param sede
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}

	/**
	 * resituisce il nTelefono del fornitore
	 * @return String nTelefono
	 */
	public String getnTelefono() {
		return nTelefono;
	}

	/**
	 * 
	 * @param nTelefono
	 */
	public void setnTelefono(String nTelefono) {
		this.nTelefono = nTelefono;
	}

	/**
	 * 
	 * @return String IBAN
	 */
	public String getIBAN() {
		return IBAN;
	}

	/**
	 * 
	 * @param iBAN
	 */
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	/**
	 * costruttore
	 * @param PIVA
	 * @param nomeAzienda
	 * @param nTelefono
	 * @param email
	 * @param sede
	 * @param IBAN
	 */
	public Fornitori(String PIVA, String nomeAzienda, String nTelefono, String email, String sede, String IBAN) {
		super();
		this.PIVA = PIVA;
		this.nomeAzienda = nomeAzienda;
		this.nTelefono = nTelefono;
		this.email = email;
		this.sede = sede;
		this.IBAN = IBAN;
	}

	@Override
	public String toString() {
		return "Fornitori [PIVA=" + PIVA + ", nomeAzienda=" + nomeAzienda + ", nTelefono=" + nTelefono + ", email="
				+ email + ", sede=" + sede + ", IBAN=" + IBAN + "]";
	}

}
