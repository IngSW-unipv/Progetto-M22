package model.magazzino;

import model.anagrafica.fornitori.Fornitori;

public class ProdottoBase {
	private String type;
	private int quantita;
	private String cod;
	private Fornitori forn;

	public String getCod() {
		return cod;
	}

	public String getType() {
		return type;
	}

	public int getQuantita() {
		return quantita;
	}

	public Fornitori getFornitore() {
		return forn;
	}

	public ProdottoBase(String type, int quantita, String cod, Fornitori forn) {
		super();
		this.type = type;
		this.quantita = quantita;
		this.forn = forn;
		this.cod = cod;

	}

	@Override
	public String toString() {
		return "ProdottoBase [type=" + type + ", quantita=" + quantita + ", forn=" + forn + ", cod=" + cod + "]";
	}

}
