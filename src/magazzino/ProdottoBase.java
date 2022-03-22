package magazzino;

import java.util.ArrayList;

import anagrafica.fornitori.Fornitori;
import anagrafica.fornitori.FornitoriDAO;

public class ProdottoBase {
	private String type;
	private int quantita;
	private String cod;
	private Fornitori fornitore;

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
		return fornitore;
	}

	public ProdottoBase(String type, int quantita, String cod, String fornitore) {
		super();
		this.type = type;
		this.quantita = quantita;

		FornitoriDAO fornitoridao = new FornitoriDAO();
		ArrayList<Fornitori> forn = fornitoridao.selectAll();

		for (Fornitori fornitori : forn) {

			if (fornitore.equals(fornitori.getCOD())) {

				this.fornitore = fornitori;
			}
		}
		this.cod = cod;

	}

	@Override
	public String toString() {
		return "ProdottoBase [type=" + type + ", quantita=" + quantita + ", forn=" + fornitore + ", cod=" + cod + "]";
	}

}
