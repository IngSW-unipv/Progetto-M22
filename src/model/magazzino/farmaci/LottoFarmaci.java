package model.magazzino.farmaci;

import java.sql.Date;

import model.anagrafica.fornitori.Fornitori;
import model.magazzino.Vendibile;

public class LottoFarmaci implements Vendibile {

	private String IDLotto;
	private String mode;
	private String type;
	private Fornitori fornitore;
	private java.sql.Date dataScadenza;
	private int quantita;

	public String getIDLotto() {
		return IDLotto;
	}

	public String getMode() {
		return mode;
	}

	public String getType() {
		return type;
	}

	public java.sql.Date getDataScadenza() {
		return dataScadenza;
	}

	public Fornitori getFornitore() {
		return fornitore;
	}

	public void setFornitore(Fornitori fornitore) {
		this.fornitore = fornitore;
	}

	public int getQuantita() {
		return quantita;
	}

	public LottoFarmaci(String IDLotto, String mode, String type, Fornitori fornitore, java.sql.Date dataScadenza,
			int quantita) {
		super();
		this.IDLotto = IDLotto;
		this.mode = mode;
		this.type = type;
		this.fornitore = fornitore;
		this.dataScadenza = dataScadenza;
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "LottoFarmaci [IDLotto=" + IDLotto + ", mode=" + mode + ", type=" + type + ", fornitore=" + fornitore
				+ ", dataScadenza=" + dataScadenza + ", quantita=" + quantita + "]";
	}

	@Override
	public int decrementa() {
		// TODO Auto-generated method stub
		return 0;
	}

}
