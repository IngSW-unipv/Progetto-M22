package magazzino.farmaci;

public enum TipoFarmaci {
	ANTINFIAMMATORI("antinfiammatori"), ANTIDOLORIFICI("antidolorifici"), ANTIBIOTICI("antibiotici"),
	INSULINA("insulina");

	private String tipoFarmaci;

	private TipoFarmaci(String tipoFarmaci) {
		this.tipoFarmaci = tipoFarmaci;
	}

	@Override
	public String toString() {
		return tipoFarmaci;
	}
}
