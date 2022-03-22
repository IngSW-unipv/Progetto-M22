package magazzino.ProdottiVendita;

public enum TipoProdottiVendita {
	MANGIMI("mangimi"), CuraAnimale("curaAnimale"), ANTIPARASSITARI("Antiparassitari");

	private String tipoProdottiVendita;

	private TipoProdottiVendita(String tipoProdottiVendita) {
		this.tipoProdottiVendita = tipoProdottiVendita;
	}

	@Override
	public String toString() {
		return tipoProdottiVendita;
	}
}
