package model.magazzino.prodottiVendita;

import java.util.Date;

import model.magazzino.ProdottoBase;

public class ProdottiVendita extends ProdottoBase {

	private Date dataScadenza;

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public ProdottiVendita(String type, int quantita, String cod, String fornitore, Date dataScadenza) {
		super(type, quantita, cod, fornitore);
		this.dataScadenza = dataScadenza;
	}

	@Override
	public String toString() {
		return "ProdottiVendita [" + super.toString() + "dataScadenza=" + dataScadenza + "]";
	}

}
