package model;

import java.util.ArrayList;

import model.amministrazione.Entrate;
import model.amministrazione.Uscite;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.magazzino.farmaci.LottoFarmaci;
import model.magazzino.prodottiUtili.ProdottiUtili;
import model.magazzino.prodottiVendita.ProdottiVendita;
import model.pazienti.Paziente;

/**
 * riunisce tutti gli array del model
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class SmartVetModel {

	private ArrayList<Clienti> clienti;
	private ArrayList<Veterinari> vets;
	private ArrayList<Fornitori> forn;
	private ArrayList<Paziente> paz;
	private ArrayList<Appuntamenti> app;
	private ArrayList<LottoFarmaci> farmaci;
	private ArrayList<LottoFarmaci> scadenza;
	private ArrayList<ProdottiUtili> prods_u;
	private ArrayList<ProdottiVendita> prods_v;
	private ArrayList<Appuntamenti> promemoria;
	private ArrayList<Appuntamenti> storico;
	private ArrayList<Appuntamenti> saleOccupate;
	private ArrayList<Entrate> entrate;
	private ArrayList<Uscite> uscite;
	private String CFuser;
	private static SmartVetModel jSmartVet;

	public SmartVetModel() {

//expert pattern

		this.clienti = new ArrayList<Clienti>();
		this.vets = new ArrayList<Veterinari>();
		this.forn = new ArrayList<Fornitori>();
		this.paz = new ArrayList<Paziente>();
		this.app = new ArrayList<Appuntamenti>();
		this.farmaci = new ArrayList<LottoFarmaci>();
		this.prods_u = new ArrayList<ProdottiUtili>();
		this.prods_v = new ArrayList<ProdottiVendita>();
		this.promemoria = new ArrayList<Appuntamenti>();
		this.scadenza = new ArrayList<LottoFarmaci>();
		this.CFuser = new String();
		this.storico = new ArrayList<Appuntamenti>();
		this.entrate = new ArrayList<Entrate>();
		this.uscite = new ArrayList<Uscite>();
	}

	/**
	 * ritorna istanza del modello
	 */
	public static SmartVetModel getInstance() {

		if (jSmartVet == null) {

			jSmartVet = new SmartVetModel();

		}

		return jSmartVet;

	}

	/**
	 * popola arrayList dei clienti
	 */
	public void populateClienti(ArrayList<Clienti> clienti) {

		this.clienti = clienti;
	}

	/**
	 * popola arrayList dei veterinari
	 */
	public void populateVeterinari(ArrayList<Veterinari> vets) {
		this.vets = vets;

	}

	/**
	 * popola arrayList dei fornitori
	 */
	public void populateFornitori(ArrayList<Fornitori> forn) {

		this.forn = forn;

	}

	/**
	 * popola arrayList dei pazienti
	 */
	public void populatePazienti(ArrayList<Paziente> paz) {

		this.paz = paz;

	}

	public void populateAppuntamenti(ArrayList<Appuntamenti> app) {

		this.app = app;

	}

	/**
	 * popola arrayList del promemoria appunatmenti oggi
	 */
	public void populatePromemoriaOggi(ArrayList<Appuntamenti> promemoria) {

		this.promemoria = promemoria;
	}

	/**
	 * popola arrayList dei cfaramci
	 */
	public void populateLottoFarmaci(ArrayList<LottoFarmaci> farmaci) {

		this.farmaci = farmaci;

	}

	/**
	 * popola arrayList dei farmaci in scadenza questo mese
	 */
	public void populateFarmaciScadenza(ArrayList<LottoFarmaci> scadenza) {
		this.scadenza = scadenza;
	}

	/**
	 * popola arrayList dei prodotti utili
	 */
	public void populateProdottiUtili(ArrayList<ProdottiUtili> prods_u) {

		this.prods_u = prods_u;

	}

	/**
	 * popola arrayList dei prodotti vendibili
	 */
	public void populateProdottivendibili(ArrayList<ProdottiVendita> prods_v) {

		this.prods_v = prods_v;

	}

	/**
	 * popola Stringa CF dell'user loggato
	 */
	public void populateCFuser(String CFuser) {
		this.CFuser = CFuser;
	}

	/**
	 * popola arrayList dello storico appuntamenti
	 */
	public void populateStorico(ArrayList<Appuntamenti> storico) {
		this.storico = storico;
	}

	/**
	 * popola arrayList delle sale occupate
	 */
	public void populateSaleOccupate(ArrayList<Appuntamenti> saleOccupate) {
		this.saleOccupate = saleOccupate;
	}

	/**
	 * popola arrayList delle entrate
	 */
	public void populateEntrate(ArrayList<Entrate> entrate) {
		this.entrate = entrate;
	}

	/**
	 * popola arrayList delle uscite
	 */
	public void populateUscite(ArrayList<Uscite> uscite) {
		this.uscite = uscite;
	}

	/**
	 * ritorna ArrayList<Clienti>
	 */
	public ArrayList<Clienti> getClientiArray() {
		return clienti;
	}

	/**
	 * ritorna ArrayList<Veterinari>
	 */
	public ArrayList<Veterinari> getVeterinariArray() {
		return vets;
	}

	/**
	 * ritorna ArrayList<Pazienti>
	 */
	public ArrayList<Paziente> getPazientiArray() {
		return paz;
	}

	/**
	 * ritorna ArrayList<Fornitori>
	 */
	public ArrayList<Fornitori> getFornitoriArray() {
		return forn;
	}

	/**
	 * ritorna ArrayList<appunatmenti>
	 */
	public ArrayList<Appuntamenti> getAppuntamentiArray() {
		return app;
	}

	/**
	 * ritorna ArrayList<Appuntamenti> di oggi
	 */
	public ArrayList<Appuntamenti> getPromemoriaOggiArray() {
		return promemoria;
	}

	/**
	 * ritorna ArrayList<LottoFarmaci>
	 */
	public ArrayList<LottoFarmaci> getLottoFarmaciArray() {
		return farmaci;
	}

	/**
	 * ritorna ArrayList<LottoFarmaci> in scadenza
	 */
	public ArrayList<LottoFarmaci> getFarmaciScadenzaArray() {
		return scadenza;
	}

	/**
	 * ritorna ArrayList<ProdottiUtili>
	 */
	public ArrayList<ProdottiUtili> getProdottiUtiliArray() {
		return prods_u;
	}

	/**
	 * ritorna ArrayList<prodottiVendita>
	 */
	public ArrayList<ProdottiVendita> getProdottiVenditaArray() {
		return prods_v;
	}

	/**
	 * ritorna String CF user loggato
	 */
	public String getCFuser() {
		return CFuser;
	}

	/**
	 * ritorna ArrayList<Appuntamenti> storico
	 */
	public ArrayList<Appuntamenti> getStoricoArray() {
		return storico;
	}

	/**
	 * ritorna ArrayList<Appuntamenti> delle sale occupate
	 */
	public ArrayList<Appuntamenti> getSaleOccupateArray() {
		return saleOccupate;
	}

	/**
	 * ritorna ArrayList<Uscite>
	 */
	public ArrayList<Uscite> getUsciteArray() {
		return uscite;
	}

	/**
	 * ritorna ArrayList<Entrate>
	 */
	public ArrayList<Entrate> getEntrateArray() {
		return entrate;
	}

}
