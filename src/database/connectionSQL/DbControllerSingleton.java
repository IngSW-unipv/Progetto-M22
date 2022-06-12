package database.connectionSQL;

import java.sql.Connection;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.clientiDAO.ClientiDAO;
import database.classiDAO.anagraficaDAO.fornitoriDAO.FornitoriDAO;
import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import database.classiDAO.appuntamentiDAO.AppuntamentiDAO;
import database.classiDAO.appuntamentiDAO.SalaDAO;
import database.classiDAO.appuntamentiDAO.StoricoDAO;
import database.classiDAO.loginDAO.LoginDAO;
import database.classiDAO.magazzinoDAO.farmaciDAO.LottoFarmaciDAO;
import database.classiDAO.magazzinoDAO.prodottiUtiliDAO.ProdottiUtiliDAO;
import database.classiDAO.magazzinoDAO.prodottiVenditaDAO.ProdottiVenditaDAO;
import database.classiDAO.pazientiDAO.PazienteDAO;
import model.anagrafica.clienti.Clienti;
import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import model.magazzino.farmaci.LottoFarmaci;
import model.magazzino.prodottiUtili.ProdottiUtili;
import model.magazzino.prodottiVendita.ProdottiVendita;
import model.pazienti.Paziente;

public class DbControllerSingleton {

	private static DbControllerSingleton instance;

	private String schema;
	private Connection c;
	private ClientiDAO clienti = new ClientiDAO();
	private FornitoriDAO fornitori = new FornitoriDAO();
	private VeterinariDAO vets = new VeterinariDAO();
	private PazienteDAO paz = new PazienteDAO();
	private AppuntamentiDAO app = new AppuntamentiDAO();
	private LottoFarmaciDAO farm = new LottoFarmaciDAO();
	private ProdottiUtiliDAO prods_u = new ProdottiUtiliDAO();
	private ProdottiVenditaDAO prods_v = new ProdottiVenditaDAO();
	private SalaDAO sale = new SalaDAO();
	private LoginDAO log = new LoginDAO();
	private StoricoDAO storico = new StoricoDAO();

	public DbControllerSingleton() {

		super();
		this.schema = "clinica";
		c = ConnectionSQL.startConnection(c, schema);
	}

	public static DbControllerSingleton getInstance() {

		if (instance == null) {

			instance = new DbControllerSingleton();
		}

		return instance;
	}
	
	
	

	// CLIENTI
	public ArrayList<Clienti> selectAllClienti() {

		return clienti.selectAll();
	}

	public Clienti selectClienteFromCF(String CF) {
		return clienti.select_cliente_from_CF(CF);
	}

	public boolean addNuovoCliente(Clienti cl) {
		return clienti.insertClienti(cl);
	}

	public void deleteCliente(Clienti cl) {
		clienti.deleteClienti(cl);
	}
	
	
	
	

	// FORNITORI
	public ArrayList<Fornitori> selectAllFornitori() {
		return fornitori.selectAll();
	}

	public Fornitori selectFornitoreFromPiva(String PIVA) {
		return fornitori.select_Forn(PIVA);
	}

	public void deleteFornitore(Fornitori fo) {
		fornitori.deleteFornitori(fo);
	}
	

	public boolean addNuovoFornitore(Fornitori fo) {
		return fornitori.insertFornitore(fo);
	}
	
	
	
	
	

	// VETERINARI
	public ArrayList<Veterinari> selectAllVeterinari() {
		return vets.selectAll();
	}

	public Veterinari selectVeterinarioFromCF(String CF) {
		return vets.select_Veterinari_from_CF(CF);
	}

	public boolean addNuovoVeterinario(Veterinari vet) {
		return vets.insertVeterinari(vet);
	}

	public void deleteVeterinario(Veterinari vet) {
		vets.deleteVeterinari(vet);
	}
	
	
	
	
	

	// PAZIENTI
	public ArrayList<Paziente> selectAllPazienti() {
		return paz.selectAll();
	}

	public int[] selectAllIDpaz() {
		return paz.selectAllIDpaz();
	}

	public void updatePaziente(Paziente paziente) {
		paz.updatePaziente(paziente);
	}

	public boolean addNuovoPaziente(Paziente pazNew) {
		return paz.insertPaziente(pazNew);
	}

	public void deletePazienti(int id) {
		paz.deletePazienti(id);
	}

	public int selectID_PAZ(int rigaSelezionata) {
		return paz.selectID_PAZ(rigaSelezionata);
	}

	public Paziente selectPazienteFromID(int ID) {
		return paz.selectPazientefromID(ID);
	}
	

	
	
	
	
	

	// APPUNTAMENTI
	public ArrayList<Appuntamenti> selectAllAppuntamenti() {
		return app.selectAll();
	}

	public ArrayList<Appuntamenti> selectAllPromemoriaOggi(String CF_vet) {
		return app.appuntamentiOggi(CF_vet);
	}

	public int selectIDappuntamenti(int rigaSelezionata) {
		return app.selectIDappuntamenti(rigaSelezionata);
	}

	public ArrayList<Appuntamenti> selectAllAppuntamentiDuetovet(String CFvet) {
		return app.selectAllDueToVeterinario(CFvet);
	}


	public void deleteAppuntamenti(int cod) {
		app.deleteAppuntamenti(cod);
	}

	public void updateAppuntamenti(Appuntamenti p) {
		app.updateAppuntamenti( p);
	}

	public boolean addNuovoAppuntamento(Appuntamenti p) {
		return app.insertAppuntamenti(p);
	}

	
	
	
	
	// STORICO
	
	public ArrayList<Appuntamenti> selectAllStorico() {
		return storico.selectAll();
	}
	
	public ArrayList<Appuntamenti> selectAllStoricoDuetovet(String CFvet) {
		return storico.selectAllDueToVeterinario(CFvet);
	}
	
	
	
	
	
	
	
	

	// FARMACI
	public ArrayList<LottoFarmaci> selectAllLottoFarmaci() {
		return farm.selectAll();
	}

	public ArrayList<LottoFarmaci> selectFarmaciScadenza() {
		return farm.getFarmaciScadenza();
	}

	public void deleteLotto(LottoFarmaci lf) {
		farm.deleteFarmaci(lf);
	}

	public boolean addLottoFarmaci(LottoFarmaci f) {
		return farm.insertFarmaci(f);
	}
	
	
	
	
	
	
	

	// PRODOTTI UTILI
	public ArrayList<ProdottiUtili> selectAllProdottiUtili() {
		return prods_u.selectAll();
	}

	public boolean addProdottiUtili(ProdottiUtili prod) {
		return prods_u.insertProdottiUtili(prod);
	}

	public int selectCODProdottiUtili(int rigaSelezionata) {
		return prods_u.selectCODprodotto(rigaSelezionata);
	}

	public void deleteProdottiUtili(int cod) {
		prods_u.deleteProdottiUtili(cod);
	}

	public void updateProdottiUtili(ProdottiUtili p) {
		prods_u.updateProdottiUtili(p);
	}
	
	
	
	
	
	
	

	// PRODOTTI VENDITA
	public ArrayList<ProdottiVendita> selectAllProdottiVendita() {
		return prods_v.selectAll();
	}
	
	public boolean addProdottiVendita(ProdottiVendita p) {
		return prods_v.insertProdottiVendita(p);
	}

	public void updateProdottiVendita(ProdottiVendita p) {
		prods_v.updateProdottiVendita(p);
	}

	public void deleteProdottiVendita(int cod) {
		prods_v.deleteProdottiVenditai(cod);
	}

	public int selectIDProdottiVendita(int rigaSelezionata) {
		return prods_v.selectCODprodotto(rigaSelezionata);
	}

	
	
	
	
	// SALE
	public String[] selectallIDsale() {
		return sale.selectSale();
	}
	
	
	
	
	

	// LOGIN
	public boolean isMatchingLogin(String user, String pw) {
		return log.isMatching(user, pw);
	}

	public String getCFuserLoggedIn(String user, String pw) {
		return log.getCFuserLoggedIn(user, pw);
	}
	
	
	
	
	

}
