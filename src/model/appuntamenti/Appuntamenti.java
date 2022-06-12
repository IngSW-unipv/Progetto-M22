package model.appuntamenti;

import java.sql.Date;
import java.sql.Time;

import model.anagrafica.veterinari.Veterinari;
import model.pazienti.Paziente;

public class Appuntamenti {

	private int COD;
	private Paziente paziente;
	private String sala;
	private String tipo;
	private Date data;
	private Time time;
	private Veterinari veterinario;
	private double costo;
	private String note;

	public int getCOD() {
		return COD;
	}

	public void setCOD(int cOD) {
		COD = cOD;
	}

	public String getTipo() {
		return tipo;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public Veterinari getVeterinario() {
		return veterinario;
	}

	public double getCosto() {
		return costo;
	}

	public String getNote() {
		return note;
	}

	public java.sql.Date getData() {
		return data;
	}

	public String getSala() {
		return sala;
	}

	public Time getTime() {
		return time;
	}

	public Appuntamenti(int COD, Paziente paziente, String sala, String tipo, Date data, Time time,
			Veterinari veterinario, double costo, String note) {
		super();

		this.sala = sala;
		this.tipo = tipo;
		this.data = data;
		this.time = time;
		this.paziente = paziente;
		this.veterinario = veterinario;
		this.costo = costo;
		this.note = note;
		this.COD = COD;
	}

	@Override
	public String toString() {
		return "Visite [paziente=" + paziente + ", sala=" + sala + ", tipo=" + tipo + ", data=" + data + ", time="
				+ time + ", veterinario=" + veterinario + ", costo=" + costo + ", note=" + note + "]";
	}

}
