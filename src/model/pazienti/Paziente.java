package model.pazienti;

import java.util.ArrayList;
import java.util.Date;

import database.classiDAO.anagraficaDAO.clientiDAO.ClientiDAO;
import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;

public class Paziente {

	private String cod;
	private String nome;
	private String specie;
	private String razza;
	private Date born;
	private String sesso;
	private Veterinari medicoBase;
	private String gs;
	private String microchip;
	private String sterilizzato;
	private double peso;
	private Date death;
	private Clienti proprietario;
	private String note;

	public String getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	public String getSpecie() {
		return specie;
	}

	public String getRazza() {
		return razza;
	}

	public Date getBorn() {
		return born;
	}

	public String getSesso() {
		return sesso;
	}

	public Veterinari getMedicoBase() {
		return medicoBase;
	}

	public String getGs() {
		return gs;
	}

	public String getMicrochip() {
		return microchip;
	}

	public String isSterilizzato() {
		return sterilizzato;
	}

	public double getPeso() {
		return peso;
	}

	public Date getDeath() {
		return death;
	}

	public Clienti getProprietario() {
		return proprietario;
	}

	public String getNote() {
		return note;
	}

	public Paziente(String cod, String nome, String specie, String razza, Date born, String sesso,
			Veterinari medicoBase, String gs, String microchip, String sterilizzato, double peso, Date death,
			Clienti proprietario, String note) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.specie = specie;
		this.razza = razza;
		this.born = born;
		this.sesso = sesso;
		this.medicoBase = medicoBase;
		this.gs = gs;
		this.microchip = microchip;
		this.sterilizzato = sterilizzato;
		this.peso = peso;
		this.death = death;
		this.note = note;
		this.proprietario = proprietario;

	}

	@Override
	public String toString() {
		return "Paziente [cod=" + cod + ", nome=" + nome + ", specie=" + specie + ", razza=" + razza + ", born=" + born
				+ ", sesso=" + sesso + ", medicoBase=" + medicoBase + ", gs=" + gs + ", microchip=" + microchip
				+ ", sterilizzato=" + sterilizzato + ", peso=" + peso + ", death=" + death + ", proprietario="
				+ proprietario + ", note=" + note + "]";
	}

}
