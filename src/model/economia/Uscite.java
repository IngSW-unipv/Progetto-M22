package model.economia;

public class Uscite {
	private int ID;
	private double prezzo;
	private String causa;

	public int getID() {
		return ID;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public String getCausa() {
		return causa;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public Uscite(int iD, double prezzo, String causa) {
		super();
		ID = iD;
		this.prezzo = prezzo;
		this.causa = causa;
	}
}
