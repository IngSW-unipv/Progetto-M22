package model.amministrazione;

import java.sql.Date;

public class Uscite {

	private int ID;
	private double prezzo;
	private String causa;
	private Date data;
	private String tipo;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public String getCausa() {
		return causa;
	}

	public Date getData() {
		return data;
	}

	public Uscite(int iD, String causa, String tipo, double prezzo, Date data) {
		super();
		ID = iD;
		this.tipo = tipo;
		this.prezzo = prezzo;
		this.causa = causa;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Uscite [ID=" + ID + ", tipo=" + tipo + ", prezzo=" + prezzo + ", causa=" + causa + "]";
	}

}
