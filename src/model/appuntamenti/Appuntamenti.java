package model.appuntamenti;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import database.classiDAO.pazientiDAO.PazienteDAO;
import model.anagrafica.veterinari.Veterinari;
import model.pazienti.Paziente;

public class Appuntamenti {
	private String cod;
	private Paziente paziente;
	private String sala;
	private String tipo;
	private Date data;
	private Time time;
	private Veterinari veterinario;
	private double costo;
	private String note;

	public String getCod() {
		return cod;
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

	public Date getData() {
		return data;
	}

	public String getSala() {
		return sala;
	}

	public Time getTime() {
		return time;
	}

	public Appuntamenti(String cod, Paziente paziente, String sala, String tipo, Date data, Time time,
			Veterinari veterinario, double costo, String note) {
		super();

		this.cod = cod;
		this.sala = sala;
		this.tipo = tipo;
		this.data = data;
		this.time = time;
		this.paziente = paziente;
		this.veterinario = veterinario;
		this.costo = costo;
		this.note = note;
	}

	@Override
	public String toString() {
		return "Visite [cod=" + cod + ", paziente=" + paziente + ", sala=" + sala + ", tipo=" + tipo + ", data=" + data
				+ ", time=" + time + ", veterinario=" + veterinario + ", costo=" + costo + ", note=" + note + "]";
	}

}
