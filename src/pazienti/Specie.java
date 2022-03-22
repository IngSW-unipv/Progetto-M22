package pazienti;

public enum Specie {
	CANE("Cane"), GATTO("Gatto"), CONIGLIO("Coniglio"), CRICETO("Criceto"), UCCELLO("Uccello");

	private String specie;

	private Specie(String specie) {
		this.specie = specie;
	}

	@Override
	public String toString() {
		return specie;
	}
}
