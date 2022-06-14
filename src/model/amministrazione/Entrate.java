package model.amministrazione;



public class Entrate {

	private int ID;
	private String tipo;
	private double prezzo;
	private String causa;
	private java.sql.Date data;

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

	public java.sql.Date getData() {
		return data;
	}

	public Entrate(int iD, String tipo, double prezzo, String causa, java.sql.Date data) {
		super();
		ID = iD;
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.causa = causa;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Entrate [ID=" + ID + ", tipo=" + tipo + ", prezzo=" + prezzo + ", causa=" + causa + "]";
	}

}
