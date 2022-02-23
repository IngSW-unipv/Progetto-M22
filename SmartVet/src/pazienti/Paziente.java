package pazienti;

import java.util.ArrayList;
import java.util.Date;

import anagrafica.clienti.Clienti;
import anagrafica.veterinari.Veterinari;
import appuntamenti.operazioni.Operazioni;
import appuntamenti.visite.Visite;

public abstract class Paziente {

	private String nome;
	private Specie specie;
	private String razza;
	private Date born;
	private Sesso sesso;
	private GruppoSanguigno gs;
	private Date death;
	private String microchip;
	private Clienti proprietario;
	private Veterinari medicoBase;
	private double peso;
	private boolean sterilizzato;
	private ArrayList<Visite> visita;
	private ArrayList<Operazioni> operazione;

}
