package anagrafica;

public abstract class Persona {
	private String nome;
	private String cognome;
	private String CF;
	private String email;
	private String cellulare;
	private String citta;
	private String indirizzo;

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCF() {
		return CF;
	}

	public String getEmail() {
		return email;
	}

	public String getCellulare() {
		return cellulare;
	}

	public String getCitta() {
		return citta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public Persona(String nome, String cognome, String CF, String email, String cellulare, String citta,
			String indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.CF = CF;
		this.cellulare = cellulare;
		this.email = email;
		this.citta = citta;
		this.indirizzo = indirizzo;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", CF=" + CF + ", email=" + email + ", cellulare="
				+ cellulare + ", citta=" + citta + ", indirizzo=" + indirizzo + "]";
	}

}
