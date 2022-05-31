package model.pazienti;

import java.util.ArrayList;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import database.classiDAO.anagraficaDAO.clientiDAO.ClientiDAO;
import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;

public class Paziente {

	private String ID_PAZ;
	private String nome;
	private String specie;
	private String razza;
	private Date DataNascita;
	private String sesso;
	private Veterinari Veterinario;
	private String GruppoSanguigno;
	private String microchip;
	private String sterilizzato;
	private double peso;
	private Date DataMorte;
	private Clienti Cliente;
	private String note;

	public String getID_PAZ() {
		return ID_PAZ;
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

	public Date getDataNascita() {
		return DataNascita;
	}

	public String getSesso() {
		return sesso;
	}

	public Veterinari getVeterinario() {
		return Veterinario;
	}

	public String getGruppoSanguigno() {
		return GruppoSanguigno;
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

	public Date getDataMorte() {
		return DataMorte;
	}

	public Clienti getCliente() {
		return Cliente;
	}

	public String getNote() {
		return note;
	}

	public Paziente(String ID_PAZ, String nome, String specie, String razza, String sesso, Date DataNascita, String GruppoSanguigno,
			String microchip, Veterinari Vet, double peso, String sterilizzato, Clienti Cl, Date DataMorte, java.sql.Date sqlDate1, int qt1,
					java.sql.Date sqlDate2, int qt2, String note) {
		super();
		this.ID_PAZ = ID_PAZ;
		this.nome = nome;
		this.specie = specie;
		this.razza = razza;
		this.DataNascita = DataNascita;
		this.sesso = sesso;
		this.Veterinario = Vet;
		this.GruppoSanguigno = GruppoSanguigno;
		this.microchip = microchip;
		this.sterilizzato = sterilizzato;
		this.peso = peso;
		this.DataMorte = DataMorte;
		this.note = note;
		this.Cliente = Cl;

	}

	@Override
	public String toString() {
		return "Paziente [ID_PAZ=" + ID_PAZ + ", nome=" + nome + ", specie=" + specie + ", razza=" + razza + ", born=" + DataNascita
				+ ", sesso=" + sesso + ", medicoBase=" + Veterinario + ", gs=" + GruppoSanguigno + ", microchip=" + microchip
				+ ", sterilizzato=" + sterilizzato + ", peso=" + peso + ", death=" + DataMorte + ", proprietario="
				+ Cliente + ", note=" + note + "]";
	}

	public boolean insertPaziente(Paziente paz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setVeterinario(Veterinari veterinario) {
		this.Veterinario = veterinario;
		
	}

}
