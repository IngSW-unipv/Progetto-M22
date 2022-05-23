package model;

import java.util.ArrayList;

import model.anagrafica.clienti.Clienti;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.magazzino.farmaci.LottoFarmaci;
import model.magazzino.prodottiUtili.ProdottiUtili;
import model.magazzino.prodottiVendita.ProdottiVendita;
import model.pazienti.Paziente;
import model.anagrafica.fornitori.*;

public class SmartVetModel {
// ArrayList di tutto
// metodi di array di tutto sto cazzo
//popola

	private ArrayList<Clienti> clienti;
	private ArrayList<Veterinari> vets;
	private ArrayList<Fornitori> forn;
	private ArrayList<Paziente> paz;
	private ArrayList<Appuntamenti> app;
	private ArrayList<LottoFarmaci> farmaci;
	private ArrayList<ProdottiUtili> prods_u;
	private ArrayList<ProdottiVendita> prods_v;
	private ArrayList<Appuntamenti> promemoria;

	private static SmartVetModel jSmartVet;

	public SmartVetModel() {

//exoert pattern

		this.clienti = new ArrayList<Clienti>();
		this.vets = new ArrayList<Veterinari>();
		this.forn = new ArrayList<Fornitori>();
		this.paz = new ArrayList<Paziente>();
		this.app = new ArrayList<Appuntamenti>();
		this.farmaci = new ArrayList<LottoFarmaci>();
		this.prods_u = new ArrayList<ProdottiUtili>();
		this.prods_v = new ArrayList<ProdottiVendita>();
		this.promemoria = new ArrayList<Appuntamenti>();
	}

	public static SmartVetModel getInstance() {

		if (jSmartVet == null) {

			jSmartVet = new SmartVetModel();

		}

		return jSmartVet;

	}

	public void populateClienti(ArrayList<Clienti> clienti) {

		this.clienti = clienti;
	}


	public void populateVeterinari(ArrayList<Veterinari> vets) {
		this.vets = vets;

	}

	public void populateFornitori(ArrayList<Fornitori> forn) {

		this.forn = forn;

	}

	public void populatePazienti(ArrayList<Paziente> paz) {

		this.paz = paz;

	}

	public void populateAppuntamenti(ArrayList<Appuntamenti> app) {

		this.app = app;

	}

	public void populatePromemoriaOggi(ArrayList<Appuntamenti> promemoria) {

		this.promemoria = promemoria;
	}

	public void populateLottoFarmaci(ArrayList<LottoFarmaci> farmaci) {

		this.farmaci = farmaci;

	}

	public void populateProdottiUtili(ArrayList<ProdottiUtili> prods_u) {

		this.prods_u = prods_u;

	}

	public void populateProdottivendibili(ArrayList<ProdottiVendita> prods_v) {

		this.prods_v = prods_v;

	}

	public ArrayList<Clienti> getClientiArray() {
		return clienti;
	}


	public ArrayList<Veterinari> getVeterinariArray() {
		return vets;
	}

	public ArrayList<Paziente> getPazientiArray() {
		return paz;
	}

	public ArrayList<Fornitori> getFornitoriArray() {
		return forn;
	}

	public ArrayList<Appuntamenti> getAppuntamentiArray() {
		return app;
	}

	public ArrayList<Appuntamenti> getPromemoriaOggiArray() {
		return promemoria;
	}

	public ArrayList<LottoFarmaci> getLottoFarmaciArray() {
		return farmaci;
	}

	public ArrayList<ProdottiUtili> getProdottiUtiliArray() {
		return prods_u;
	}

	public ArrayList<ProdottiVendita> getProdottiVenditaArray() {
		return prods_v;
	}

}
