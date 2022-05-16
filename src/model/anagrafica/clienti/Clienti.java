package model.anagrafica.clienti;

import model.anagrafica.Persona;

public class Clienti extends Persona {

	public Clienti(String nome, String cognome, String cF, String email, String cellulare, String citta,
			String indirizzo) {
		super(nome, cognome, cF, email, cellulare, citta, indirizzo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Clienti [" + super.toString() + "]";
	}

}
