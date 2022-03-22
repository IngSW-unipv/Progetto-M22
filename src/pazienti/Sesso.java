package pazienti;

public enum Sesso {
	F("F"), M("M");

	private String sesso;

	private Sesso(String sesso) {
		this.sesso = sesso;
	}

	@Override
	public String toString() {
		return sesso;
	}

}
