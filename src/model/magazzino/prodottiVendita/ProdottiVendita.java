package model.magazzino.prodottiVendita;

import model.anagrafica.fornitori.Fornitori;
import model.magazzino.ProdottoBase;
/**
 * La classe prodotti vendita racchiude i prodotti che possono essere venduti
 * @author MMA
 * version 1.0
 *
 */
public class ProdottiVendita extends ProdottoBase {

	private java.sql.Date dataScadenza;

	/**
	 * restituisce la data di scadenza
	 * @return Date dataScadenza dataScadenza
	 */
	public java.sql.Date getDataScadenza() {
		return dataScadenza;
	}

	/**
	 * costruttore
	 * @param COD codice
	 * @param nome nome
	 * @param type tipo
	 * @param quantita quantit�
	 * @param fornitore fornitore
	 * @param dataScadenza dataScadenza
	 */
	public ProdottiVendita(int COD, String nome, String type, int quantita, Fornitori fornitore, java.sql.Date dataScadenza) {
		super(COD, nome, type, quantita, fornitore);
		this.dataScadenza = dataScadenza;
	}

	/**
	 * stampa la stringa "ProdottiVendita" affiancata dai vari campi interessati
	 * @return String
	 */
	@Override
	public String toString() {
		return "ProdottiVendita [" + super.toString() + "dataScadenza=" + dataScadenza + "]"; 
	}

	public void setDataScadenza(java.sql.Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

}
