package model.pazienti;

import java.sql.Date;

import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;

public class Paziente {

	//private String ID_PAZ;
	private String nome;
	private String specie;
	private String razza;
	private Date DataNascita;
	private String sesso;
	private Veterinari Veterinario;
	private String GruppoSanguigno;
	private Boolean microchip;
	private Boolean sterilizzato;
	private double peso;
	private Date DataMorte;
	private Clienti Cliente;
	private String note;

	

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

	public Boolean getMicrochip() {
		return microchip;
	}

	public Boolean getSterilizzato() {
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

	public Paziente(String nome, String specie, String razza, Date dataNascita, String sesso, Veterinari veterinario,
			String gruppoSanguigno, Boolean microchip, Boolean sterilizzato, double peso, Date dataMorte,
			Clienti cliente, String note) {
		super();
		this.nome = nome;
		this.specie = specie;
		this.razza = razza;
		this.DataNascita = dataNascita;
		this.sesso = sesso;
		this.Veterinario = veterinario;
		this.GruppoSanguigno = gruppoSanguigno;
		this.microchip = microchip;
		this.sterilizzato = sterilizzato;
		this.peso = peso;
		this.DataMorte = dataMorte;
		this.Cliente = cliente;
		this.note = note;
	}

	@Override
	public String toString() {
		return "Paziente [nome=" + nome + ", specie=" + specie + ", razza=" + razza
				+ ", DataNascita=" + DataNascita + ", sesso=" + sesso + ", Veterinario=" + Veterinario
				+ ", GruppoSanguigno=" + GruppoSanguigno + ", microchip=" + microchip + ", sterilizzato=" + sterilizzato
				+ ", peso=" + peso + ", DataMorte=" + DataMorte + ", Cliente=" + Cliente + ", note=" + note + "]";
	}

}
