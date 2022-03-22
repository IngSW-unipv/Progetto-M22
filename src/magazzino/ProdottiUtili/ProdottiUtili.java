package magazzino.ProdottiUtili;

import magazzino.ProdottoBase;

public class ProdottiUtili extends ProdottoBase {

	public ProdottiUtili(String type, int quantita, String cod, String forn) {
		super(type, quantita, cod, forn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProdottiUtili [" + super.toString() + "]";
	}

}
