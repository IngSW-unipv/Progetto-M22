package anagrafica.veterinari;

import anagrafica.Persona;

public class Veterinari extends Persona {
	private String PIVA;
	private String contratto;
	private double stipendio;
	private double commissioni;
	private String IBAN;

	public String getPIVA() {
		return PIVA;
	}

	public String getContratto() {
		return contratto;
	}

	public double getStipendio() {
		return stipendio;
	}

	public double getCommissioni() {
		return commissioni;
	}

	public String getIBAN() {
		return IBAN;
	}

	public Veterinari(String nome, String cognome, String cF, String email, String cellulare, String citta,
			String indirizzo, String pIVA, String contratto, double stipendio, double commissioni, String iBAN) {
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
