package model.pazienti;

import java.sql.Date;

import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;
/**
 * la classe pazienti rappresenta l'entita pazienti della clinica 
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * 
 */
public class Paziente {

	private int IDpaz;
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

	/**
	 * restituisce il nome del paziente
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * restituisce l'iDpaz del paziente
	 * @return int l'iDpaz
	 */
	public int getIDpaz() {
		return IDpaz;
	}

	/**
	 * assegnal'iDpaz al paziente
	 * @param iDpaz
	 */
	public void setIDpaz(int iDpaz) {
		IDpaz = iDpaz;
	}

	/**
	 * restituisce la specie del paziente
	 * @return String specie
	 */
	public String getSpecie() {
		return specie;
	}

	/**
	 * restituisce la razza del paziente
	 * @return String razza
	 */
	public String getRazza() {
		return razza;
	}

	/**
	 * restituisce la data di nascita del paziente
	 * @return String dataNascita
	 */
	public Date getDataNascita() {
		return DataNascita;
	}

	/**
	 * restituisce il sesso del paziente
	 * @return String sesso
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * restituisce il veterinario che ha in cura il paziente
	 * @return String veterinario
	 */
	public Veterinari getVeterinario() {
		return Veterinario;
	}

	/**
	 * restituisce il gruppo sanguinio del paziente
	 * @return String gruppoSanguinio
	 */
	public String getGruppoSanguigno() {
		return GruppoSanguigno;
	}

	/**
	 * restituisce 0 o 1 a seconda dell'assenza o presenza dell'impianto
	 * contenente il microchip nel paziente
	 * @return Boolean microchip
	 */
	public Boolean getMicrochip() {
		return microchip;
	}

	/**
	 * restituisce 0 o 1 a seconda della sterilizzazione o
	 * non del paziente
	 * @return Boolean sterilizzato
	 */
	public Boolean getSterilizzato() {
		return sterilizzato;
	}

	/**
	 * restituisce il peso del paziente
	 * @return double peso
	 */
	public double getPeso() {
		return peso;
	}

	/**
	 * restituisce la data di morte del paziente
	 * @return Date DataMorte
	 */
	public Date getDataMorte() {
		return DataMorte;
	}

	/**
	 * restituisce il CF del propietario del paziente
	 * @return Clienti Cliente
	 */
	public Clienti getCliente() {
		return Cliente;
	}

	/**
	 * restituisce le note relative al paziente
	 * @return String note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * costruttore
	 * @param IDpaz
	 * @param nome
	 * @param specie
	 * @param razza
	 * @param dataNascita
	 * @param sesso
	 * @param veterinario
	 * @param gruppoSanguigno
	 * @param microchip
	 * @param sterilizzato
	 * @param peso
	 * @param dataMorte
	 * @param cliente
	 * @param note
	 */
	public Paziente(int IDpaz, String nome, String specie, String razza, Date dataNascita, String sesso, Veterinari veterinario,
			String gruppoSanguigno, Boolean microchip, Boolean sterilizzato, double peso, Date dataMorte,
			Clienti cliente, String note) {
		super();
		this.IDpaz = IDpaz;
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
		return "Paziente [nome=" + nome + ", specie=" + specie + ", razza=" + razza + ", DataNascita=" + DataNascita
				+ ", sesso=" + sesso + ", Veterinario=" + Veterinario + ", GruppoSanguigno=" + GruppoSanguigno
				+ ", microchip=" + microchip + ", sterilizzato=" + sterilizzato + ", peso=" + peso + ", DataMorte="
				+ DataMorte + ", Cliente=" + Cliente + ", note=" + note + "]";
	}


}
