package model.magazzino.prodottiUtili;

import model.anagrafica.fornitori.Fornitori;
import model.magazzino.ProdottoBase;

public class ProdottiUtili extends ProdottoBase {

	public ProdottiUtili(String nome, String type, int quantita, Fornitori forn) {
		super(nome, type, quantita, forn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProdottiUtili [" + super.toString() + "]";
	}

}
