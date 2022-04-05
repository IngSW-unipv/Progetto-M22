package appuntamenti.operazioni;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import anagrafica.veterinari.Veterinari;
import anagrafica.veterinari.VeterinariDAO;
import pazienti.Paziente;
import pazienti.PazienteDAO;

public class Operazioni {
	private String cod;
	private Paziente paziente;
	private String sala;
	private String tipo;
	private Date data;
	private Time time;
	private Veterinari vet;
	private double costo;
	private String note;

	public String getCod() {
		return cod;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public String getSala() {
		return sala;
	}

	public String getTipo() {
		return tipo;
	}

	public Date getData() {
		return data;
	}

	public Time getTime() {
		return time;
	}

	public Veterinari getVet() {
		return vet;
	}

	public double getCosto() {
		return costo;
	}

	public String getNote() {
		return note;
	}

	public Operazioni(String cod, String paziente, String sala, String tipo, Date data, Time time, String vet,
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

			if (vet.equals(veterinari.getCF())) {

				this.vet = veterinari;
			}
		}

		this.costo = costo;
		this.note = note;

	}

	@Override
	public String toString() {
		return "Operazioni [cod=" + cod + ", paziente=" + paziente + ", sala=" + sala + ", tipo=" + tipo + ", data="
				+ data + ", time=" + time + ", vet=" + vet + ", costo=" + costo + ", note=" + note + "]";
	}

}
