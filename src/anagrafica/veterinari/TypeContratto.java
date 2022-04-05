package anagrafica.veterinari;

public enum TypeContratto {
	INDETERMINATO("Indeterminato"), STAGE("Stage"), DETERMINATO("Determinato");

	private String typeContratto;

	private TypeContratto(String typeContratto) {
		this.typeContratto = typeContratto;
	}

	public String getTypeContratto() {
		return typeContratto;
	}

	@Override
	public String toString() {
		return typeContratto;
	}
}
