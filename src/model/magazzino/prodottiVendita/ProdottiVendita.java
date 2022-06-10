package model.magazzino.prodottiVendita;

import model.anagrafica.fornitori.Fornitori;
import model.magazzino.ProdottoBase;

public class ProdottiVendita extends ProdottoBase {

	private java.sql.Date dataScadenza;

	public java.sql.Date getDataScadenza() {
		return dataScadenza;
	}

	public ProdottiVendita(String nome, String type, int quantita, Fornitori fornitore, java.sql.Date dataScadenza) {
		super(nome, type, quantita, fornitore);
		this.dataScadenza = dataScadenza;
	}

	@Override
	public String toString() {
		return "ProdottiVendita [" + super.toString() + "dataScadenza=" + dataScadenza + "]";
	}

}
