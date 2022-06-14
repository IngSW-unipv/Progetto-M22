package model.magazzino.prodottiUtili;

import model.anagrafica.fornitori.Fornitori;
import model.magazzino.ProdottoBase;
/**
 * la classe Prodottiutili racchiude i prodotti per uso interno alla clinica 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class ProdottiUtili extends ProdottoBase {

	/**
	 * costruttore
	 * @param COD codice
	 * @param nome nome
	 * @param type tipo
	 * @param quantita quantità
	 * @param forn fornitore
	 */
	public ProdottiUtili(int COD, String nome, String type, int quantita, Fornitori forn) {
		super(COD, nome, type, quantita, forn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * restituisce i prodotti utili con gli attributi sottoforma di stringa
	 * @return String
	 */
	@Override
	public String toString() {
		return "ProdottiUtili [" + super.toString() + "]";
	}

}
