package magazzino;

public enum ModAssunz {
	INIEZIONE("iniezione"), ORALE("orale"), OCULARE("oculare"), 
	NASALE("nasale"), INALAZIONE("inalazione"),TRANSDERMICA("transdermica");

	private String modAssunz;
/*
	private ModAssunz(String modAssunz) {
		this.modAssunz = modAssunz;
	}*/

	private ModAssunz(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return modAssunz;
	}
}
