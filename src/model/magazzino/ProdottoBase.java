package model.magazzino;

import model.anagrafica.fornitori.Fornitori;

public class ProdottoBase {

	private String nome;
	private String type;
	private int quantita;
	private Fornitori forn;

	public String getNome() {
		return nome;
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


	public void setForn(Fornitori forn) {
		this.forn = forn;
	}

	public ProdottoBase(String nome, String type, int quantita, Fornitori forn) {
		super();
		this.nome = nome;
		this.type = type;
		this.quantita = quantita;
		this.forn = forn;

	}

	@Override
	public String toString() {
		return "ProdottoBase [nome=" + nome + "type=" + type + ", quantita=" + quantita + ", forn=" + forn + "]";
	}

}
