package model.anagrafica;

/**
 * la classe persona rappresenta l'entita persona della clinica 
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * 
 */
public abstract class Persona {
	private String nome;
	private String cognome;
	private String CF;
	private String email;
	private String cellulare;
	private String citta;
	private String indirizzo;

	/**
	 * restituisce il nome della persona
	 * @return String Nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * restituisce il cognome della persona
	 * @return String Cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * restituisce il CF della persona
	 * @return String CF
	 */
	public String getCF() {
		return CF;
	}

	/**
	 * restituisce l'email della persona
	 * @return String Email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * restituisce il cellulare della persona
	 * @return String Cellulare
	 */
	public String getCellulare() {
		return cellulare;
	}

	/**
	 * restituisce la citta della persona
	 * @return String Citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * restituisce l'indirizzo della persona
	 * @return String Indirizzo
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * costrutto
	 * @param nome
	 * @param cognome
	 * @param CF
	 * @param email
	 * @param cellulare
	 * @param citta
	 * @param indirizzo
	 */
	public Persona(String nome, String cognome, String CF, String email, String cellulare, String citta,
			String indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.CF = CF;
		this.email = email;
		this.cellulare = cellulare;
		this.citta = citta;
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", CF=" + CF + ", email=" + email + ", cellulare="
				+ cellulare + ", citta=" + citta + ", indirizzo=" + indirizzo + "]";
	}

}
