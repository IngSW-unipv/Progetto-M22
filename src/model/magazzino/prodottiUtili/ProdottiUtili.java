package model.magazzino.prodottiUtili;

import model.anagrafica.fornitori.Fornitori;
import model.magazzino.ProdottoBase;

public class ProdottiUtili extends ProdottoBase {

	public ProdottiUtili(String type, int quantita, String cod, Fornitori forn) {
		super(type, quantita, cod, forn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProdottiUtili [" + super.toString() + "]";
	}

}
