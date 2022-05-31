package model;

import java.util.ArrayList;

import model.anagrafica.clienti.Clienti;
import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.magazzino.farmaci.LottoFarmaci;
import model.magazzino.prodottiUtili.ProdottiUtili;
import model.magazzino.prodottiVendita.ProdottiVendita;
import model.pazienti.Paziente;

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
	private ArrayList<LottoFarmaci> scadenza;
	private ArrayList<ProdottiUtili> prods_u;
	private ArrayList<ProdottiVendita> prods_v;
	private ArrayList<Appuntamenti> promemoria;

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

	public void populateFarmaciScadenza(ArrayList<LottoFarmaci> scadenza) {
		this.scadenza = scadenza;
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

	public void addNewCliente(Clienti cl) {
		clienti.add(cl);
	}

	public void EliminaCliente(Clienti cl) {
		clienti.remove(cl);
	}

	public ArrayList<Veterinari> getVeterinariArray() {
		return vets;
	}

	public boolean addNewVet(Veterinari vet) {
		return vets.add(vet);
	}

	public ArrayList<Paziente> getPazientiArray() {
		return paz;
	}

	public ArrayList<Fornitori> getFornitoriArray() {
		return forn;
	}

	public boolean addNewForn(Fornitori forni) {
		return forn.add(forni);
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

	public ArrayList<LottoFarmaci> getFarmaciScadenzaArray() {
		return scadenza;
	}

	public ArrayList<ProdottiUtili> getProdottiUtiliArray() {
		return prods_u;
	}

	public ArrayList<ProdottiVendita> getProdottiVenditaArray() {
		return prods_v;
	}

	public void updateLotto(ArrayList<Fornitori> forns, ArrayList<LottoFarmaci> farms) {

		for (int j = 0; j < farms.size(); j++) { 
			for (int i = 0; i < forns.size(); i++) {
			
				if (farms.get(j).getFornitore() != forns.get(i))
						farms.get(j).setFornitore(null);
			}
		}

	}
	
	public void updatePazienti(ArrayList<Veterinari> vet, ArrayList<Paziente> paz) {

		for (int j = 0; j < paz.size(); j++) { 
			for (int i = 0; i < vet.size(); i++) {
			
				if (paz.get(j).getVeterinario() != vet.get(i))
						paz.get(j).setVeterinario(null);
			}
		}

	}

	public ArrayList<Paziente> getPazientiPanelArray() {
		// TODO Auto-generated method stub
		return paz;
	}
	
	
}
