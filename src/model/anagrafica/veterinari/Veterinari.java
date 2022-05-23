package model.anagrafica.veterinari;

import model.anagrafica.Persona;

public class Veterinari extends Persona {
	private String PIVA;
	private String contratto;
	private String stipendio;
	private String commissioni;
	private String IBAN;

	public String getPIVA() {
		return PIVA;
	}

	public String getContratto() {
		return contratto;
	}

	public String getStipendio() {
		return stipendio;
	}

	public String getCommissioni() {
		return commissioni;
	}

	public String getIBAN() {
		return IBAN;
	}

	public Veterinari(String nome, String cognome, String cF, String email, String cellulare, String citta,
			String indirizzo, String pIVA, String contratto, String stipendio, String commissioni, String iBAN) {
		super(nome, cognome, cF,email, cellulare,  citta, indirizzo);
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
