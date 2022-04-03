package appuntamenti.visite;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import anagrafica.veterinari.Veterinari;
import anagrafica.veterinari.VeterinariDAO;

import pazienti.Paziente;
import pazienti.PazienteDAO;

public class Visite {
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

	public Visite(String cod, String paziente, String sala, String tipo, Date data, Time time, String veterinario,
			double costo, String note) {
		super();

		this.cod = cod;

		PazienteDAO pazientidao = new PazienteDAO();
		ArrayList<Paziente> paz = pazientidao.selectAll();

		for (Paziente pazient : paz) {

			if (paziente.equals(pazient.getCod())) {

				this.paziente = pazient;
			}
		}
		this.sala = sala;
		this.tipo = tipo;
		this.data = data;
		this.time = time;

		VeterinariDAO vetdao = new VeterinariDAO();
		ArrayList<Veterinari> vets = vetdao.selectAll();
		for (Veterinari veterinari : vets) {

			if (veterinario.equals(veterinari.getCF())) {

				this.veterinario = veterinari;

			}

		}

		this.costo = costo;
		this.note = note;
	}

	@Override
	public String toString() {
		return "Visite [cod=" + cod + ", paziente=" + paziente + ", sala=" + sala + ", tipo=" + tipo + ", data=" + data
				+ ", time=" + time + ", veterinario=" + veterinario + ", costo=" + costo + ", note=" + note + "]";
	}

}
