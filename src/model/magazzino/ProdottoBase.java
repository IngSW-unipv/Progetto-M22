package model.magazzino;

import model.anagrafica.fornitori.Fornitori;
/**
 * La classe prodotto base contiene le informazioni principali sui prodotti
 * @author MMA
 * version 1.0
 *
 */
public class ProdottoBase {

	private int COD;
	private String nome;
	private String type;
	private int quantita;
	private Fornitori forn;

	/**
	 * restiturisce il codice
	 * @return int COD codice
	 */
	public int getCOD() {
		return COD;
	}

	/**
	 * assegna il codice 
	 * @param cOD codice
	 */
	public void setCOD(int cOD) {
		COD = cOD;
	}

	/**
	 * restituisce il nome
	 * @return String nome nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * restituisce il tipo
	 * @return String type tipo
	 */
	public String getType() {
		return type;
	}

	/**
	 * restituisce la quantit�
	 * @return int quantit� quantit�
	 */
	public int getQuantita() {
		return quantita;
	}

	/**
	 * restituisce il fornitore
	 * @return Fornitori forn fornitori
	 */
	public Fornitori getFornitore() {
		return forn;
	}

	/**
	 * assegna il fornitore
	 * @param forn fornitore
	 * @return void
	 */
	public void setForn(Fornitori forn) {
		this.forn = forn;
	}
	
	/**
	 * assegna il nome
	 * @param nome 
	 * @return void
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * assegna il tipo
	 * @param type tipo 
	 * @return void
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * assegna la quantita
	 * @param quantita
	 * @return void
	 */
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	/**
	 * costruttore
	 * @param COD codice
	 * @param nome nome
	 * @param type tipo
	 * @param quantita quantita
	 * @param forn fornitore
	 */
	public ProdottoBase(int COD, String nome, String type, int quantita, Fornitori forn) {
		super();
		this.COD = COD;
		this.nome = nome;
		this.type = type;
		this.quantita = quantita;
		this.forn = forn;

	}

	/**
	 * stampa la stringa "prodotto base" affiancata dai vari campi interessati
	 * @return String
	 */
	@Override
	public String toString() {
		return "ProdottoBase [nome=" + nome + "type=" + type + ", quantita=" + quantita + ", forn=" + forn + "]";
	}

}
