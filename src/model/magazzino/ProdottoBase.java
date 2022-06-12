package model.magazzino;

import model.anagrafica.fornitori.Fornitori;

public class ProdottoBase {

	private int COD;
	private String nome;
	private String type;
	private int quantita;
	private Fornitori forn;

	public int getCOD() {
		return COD;
	}

	public void setCOD(int cOD) {
		COD = cOD;
	}

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

	public ProdottoBase(int COD, String nome, String type, int quantita, Fornitori forn) {
		super();
		this.COD = COD;
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
