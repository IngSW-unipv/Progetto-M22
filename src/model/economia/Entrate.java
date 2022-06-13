package model.economia;

public class Entrate {
	private int ID;
	private String tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Entrate(int iD, String tipo, double prezzo, String causa) {
		super();
		ID = iD;
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.causa = causa;
	}

}
