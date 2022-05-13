package magazzino.farmaci;

import java.util.ArrayList;
import java.util.Date;
import anagrafica.fornitori.Fornitori;
import anagrafica.fornitori.FornitoriDAO;
import magazzino.Vendibile;

public class LottoFarmaci implements Vendibile {

	private String IDLotto;
	private String mode;
	private String type;
	private Fornitori fornitore;
	private Date dataScadenza;
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

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public Fornitori getFornitore() {
		return fornitore;
	}

	public int getQuantita() {
		return quantita;
	}

	public LottoFarmaci(String IDLotto, String mode, String type, String fornitore, Date dataScadenza, int quantita) {
		super();
		this.IDLotto = IDLotto;
		this.mode = mode;
		this.type = type;

		FornitoriDAO fornitoridao = new FornitoriDAO();
		ArrayList<Fornitori> forn = fornitoridao.selectAll();

		for (Fornitori fornitori : forn) {

			if (fornitore.equals(fornitori.getPIVA())) {

				this.fornitore = fornitori;

			}
		}
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
