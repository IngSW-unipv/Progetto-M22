package database.connectionSQL;

import java.sql.Connection;
import java.util.ArrayList;

import database.classiDAO.amministrazione.EntrateDAO;
import database.classiDAO.amministrazione.UsciteDAO;
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
 * Collega il database col model: effettua tutte le query
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
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
	private EntrateDAO entrate = new EntrateDAO();
	private UsciteDAO uscite = new UsciteDAO();

	// costruttore 
	private DbControllerSingleton() {

		super();
		this.schema = "clinica";
	}

	/**
	 * restituisce istanza DbController
	 */
	public static DbControllerSingleton getInstance() {

		if (instance == null) {

			instance = new DbControllerSingleton();
		}

		return instance;
	}
	
	
	
	
	// CLIENTI
	
	/**
	 * ritornaArrayList<Clienti> di tutti i clienti
	 */
	
	public ArrayList<Clienti> selectAllClienti() {

		return clienti.selectAll();
	}

	/**
	 * ritorna Clienti =  cliente selezionato dal CF passato come parametro
	 */
	public Clienti selectClienteFromCF(String CF) {
		return clienti.select_cliente_from_CF(CF);
	}

	/**
	 * aggiunge nuovo cliente passato come parametro
	 * @return boolean = true se è riuscito insert
	 */
	public boolean addNuovoCliente(Clienti cl) {
		return clienti.insertClienti(cl);
	}

	/**
	 * elimina cliente passato come parametro
	 */
	public void deleteCliente(Clienti cl) {
		clienti.deleteClienti(cl);
	}
	
	
	
	

	// FORNITORI
	
	/**
	 * ritorna ArrayList<Fornitori> di tutti i fornitori
	 */
	public ArrayList<Fornitori> selectAllFornitori() {
		return fornitori.selectAll();
	}

	/**
	 * ritorna Fornitori = fornitore selezionato dal CF passato
	 */
	public Fornitori selectFornitoreFromPiva(String PIVA) {
		return fornitori.select_Forn(PIVA);
	}

	
	/**
	**
	 * elimina cliente passato come parametro
	 */
	public void deleteFornitore(Fornitori fo) {
		fornitori.deleteFornitori(fo);
	}
	
	/**
	 * aggiunge nuovo fornitore passato come parametro
	 * @return boolean = true se è riuscito insert
	 */
	public boolean addNuovoFornitore(Fornitori fo) {
		return fornitori.insertFornitore(fo);
	}
	
	
	
	
	

	// VETERINARI
	
	/**
	 * ritorna ArrayList<Veterinari> di tutti i veterinari
	 */
	public ArrayList<Veterinari> selectAllVeterinari() {
		return vets.selectAll();
	}

	/**
	 * ritorna Veterinari = veterinario selezionato dal CF passato
	 */
	public Veterinari selectVeterinarioFromCF(String CF) {
		return vets.select_Veterinari_from_CF(CF);
	}

	/**
	 * aggiunge nuovo veterinario passato come parametro
	 * @return boolean = true se è riuscito insert
	 */
	public boolean addNuovoVeterinario(Veterinari vet) {
		return vets.insertVeterinari(vet);
	}

	/**
	**
	 * elimina veterinario passato come parametro
	 */
	public void deleteVeterinario(Veterinari vet) {
		vets.deleteVeterinari(vet);
	}
	
	
	
	
	

	// PAZIENTI
	
	/**
	 * ritorna ArrayList<Paziente> di tutti i pazienti
	 */
	public ArrayList<Paziente> selectAllPazienti() {
		return paz.selectAll();
	}

	/**
	 * aggiorna paziente passato come parametro
	 */
	public void updatePaziente(Paziente paziente) {
		paz.updatePaziente(paziente);
	}

	/**
	 * aggiunge nuovo paziente passato come parametro
	 * @return boolean = true se è riuscito insert
	 */
	public boolean addNuovoPaziente(Paziente pazNew) {
		return paz.insertPaziente(pazNew);
	}

	/**
	 **
	 * elimina paziente passato come parametro
	 */
	public void deletePazienti(int id) {
		paz.deletePazienti(id);
	}

	/**
	 **
	 * ritorna int ID paziente tramite riga selezionata da tabella
	 * passata come paraemtro
	 */
	public int selectID_PAZ(int rigaSelezionata) {
		return paz.selectID_PAZ(rigaSelezionata);
	}

	/**
	 * ritorna Paziente = paziente selezionato dall'ID passato
	 * come parametro
	 */
	public Paziente selectPazienteFromID(int ID) {
		return paz.selectPazientefromID(ID);
	}
	

	
	
	
	
	

	// APPUNTAMENTI
	 
	/**
	* ritorna ArrayList<Appuntamenti> di tutti gli appuntamenti
	* da giorno corrente in poi
	*/
	public ArrayList<Appuntamenti> selectAllAppuntamenti() {
		return app.selectAll();
	}

	/**
	* ritorna ArrayList<Appuntamenti> di tutti gli appuntamenti di oggi
	* in base al veterinario che ha CF passato come parametro
	*/
	public ArrayList<Appuntamenti> selectAllPromemoriaOggiDueToVet(String CF_vet) {
		return app.appuntamentiOggiDueToVet(CF_vet);
	}
	
	/**
	* ritorna ArrayList<Appuntamenti> di tutti gli appuntamenti di oggi
	* di tutti i veterinari
	*/
	public ArrayList<Appuntamenti> selectAllPromemoriaOggi() {
		return app.appuntamentiOggi();
	}

	/**
	 **
	 * ritorna int ID appunatmento tramite riga selezionata da tabella
	 * passata come paraemtro
	 */
	public int selectIDappuntamenti(int rigaSelezionata) {
		return app.selectIDappuntamenti(rigaSelezionata);
	} 

	/**
	* ritorna ArrayList<Appuntamenti> di tutti gli appuntamenti
	* dal giorno corrente in poi del veterinario
	* che ha CF passato come parametro
	*/
	public ArrayList<Appuntamenti> selectAllAppuntamentiDuetovet(String CFvet) {
		return app.selectAllDueToVeterinario(CFvet);
	}

	/**
	 **
	 * elimina appuntamento passato come parametro
	 */
	public void deleteAppuntamenti(int cod) {
		app.deleteAppuntamenti(cod);
	}

	/**
	 * aggiorna appuntamento passato come parametro
	 */
	public void updateAppuntamenti(Appuntamenti p) {
		app.updateAppuntamenti( p);
	}

	/**
	 * aggiunge nuovo appuntamento passato come parametro
	 * @return boolean = true se è riuscito insert
	 */
	public boolean addNuovoAppuntamento(Appuntamenti p) {
		return app.insertAppuntamenti(p);
	}

	
	
	
	
	// STORICO
	/**
	* ritorna ArrayList<Appuntamenti> di tutti gli appuntamenti di ogni giorno
	* di ogni vet
	*/
	public ArrayList<Appuntamenti> selectAllStorico() {
		return storico.selectAll();
	}
	
	/**
	* ritorna ArrayList<Appuntamenti> di tutti gli appuntamenti di ogni giorno
	* in base al vet passato come parametro
	*/
	public ArrayList<Appuntamenti> selectAllStoricoDuetovet(String CFvet) {
		return storico.selectAllDueToVeterinario(CFvet);
	}
	
	
	
	
	
	
	
	

	// FARMACI
	
	/**
	* ritorna ArrayList<LottoFarmaci> di tutti i farmaci
	*/
	public ArrayList<LottoFarmaci> selectAllLottoFarmaci() {
		return farm.selectAll();
	}

	/**
	* ritorna ArrayList<LottoFarmaci> di tutti i farmaci in scadenza questo mese
	*/
	public ArrayList<LottoFarmaci> selectFarmaciScadenza() {
		return farm.getFarmaciScadenza();
	}

	
	/**
	 **
	 * elimina lotto passato come parametro
	 */
	public void deleteLotto(LottoFarmaci lf) {
		farm.deleteFarmaci(lf);
	}

	/**
	 * aggiunge nuovo lotto passato come parametro
	 * @return boolean = true se è riuscito insert
	 */
	public boolean addLottoFarmaci(LottoFarmaci f) {
		return farm.insertFarmaci(f);
	}
	
	
	
	
	
	
	

	// PRODOTTI UTILI
	
	/**
	* ritorna ArrayList<ProdottiUtili> di tutti i prodotti utili
	*/
	public ArrayList<ProdottiUtili> selectAllProdottiUtili() {
		return prods_u.selectAll();
	}

	/**
	 * aggiunge nuovo prodotto utilr passato come parametro
	 * @return boolean = true se è riuscito insert
	 */
	public boolean addProdottiUtili(ProdottiUtili prod) {
		return prods_u.insertProdottiUtili(prod);
	}

	/**
	 **
	 * ritorna int cod prodotto utilr tramite riga selezionata da tabella
	 * passata come parametro
	 */
	public int selectCODProdottiUtili(int rigaSelezionata) {
		return prods_u.selectCODprodotto(rigaSelezionata);
	}

	
	/**
	 **
	 * elimina prodotto utile che ha cod passato come parametro
	 */
	public void deleteProdottiUtili(int cod) {
		prods_u.deleteProdottiUtili(cod);
	}


	/**
	 * aggiorna prodotto utile passato come parametro
	 */
	public void updateProdottiUtili(ProdottiUtili p) {
		prods_u.updateProdottiUtili(p);
	}
	
	
	
	
	
	
	

	// PRODOTTI VENDITA
	
	/**
	* ritorna ArrayList<ProdottiVendita> di tutti i prodotti vendita
	*/
	public ArrayList<ProdottiVendita> selectAllProdottiVendita() {
		return prods_v.selectAll();
	}
	
	/**
	 * aggiunge nuovo prodotto vendita passato come parametro
	 * @return boolean = true se è riuscito insert
	 */
	public boolean addProdottiVendita(ProdottiVendita p) {
		return prods_v.insertProdottiVendita(p);
	}


	/**
	 * aggiorna prodotto vendita passato come parametro
	 */
	public void updateProdottiVendita(ProdottiVendita p) {
		prods_v.updateProdottiVendita(p);
	}

	
	/**
	 **
	 * elimina prodotto vendita che ha cod passato come parametro
	 */
	public void deleteProdottiVendita(int cod) {
		prods_v.deleteProdottiVendita(cod);
	}

	/**
	 **
	 * ritorna int cod prodotto vendita tramite riga selezionata da tabella
	 * passata come parametro
	 */
	public int selectIDProdottiVendita(int rigaSelezionata) {
		return prods_v.selectCODprodotto(rigaSelezionata);
	}

	
	
	
	
	// SALE
	
	/**
	* ritorna String[] vettore di stringhe di tutte le sale
	*/
	public String[] selectallIDsale() {
		return sale.selectSale();
	} 
	
	
	
	
	

	// LOGIN
	
	/**
	* verifica se account è presente nel db
	* @return boolean = true se presente 
	*/
	public boolean isMatchingLogin(String user, String pw) {
		return log.isMatching(user, pw);
	}

	/**
	* ritorna String CF del veterinario loggato
	*/
	public String getCFuserLoggedIn(String user, String pw) {
		return log.getCFuserLoggedIn(user, pw);
	}
	
	/**
	 * aggiunge nuovo utente passato come parametro
	 * @return void
	 */
	public void insertNuovoUtente(String user, String pw, String CFvet) {
		log.insertNuovoUtente(user, pw, CFvet);
	}
	

	
	
	
	// ENTRATE
	
	/**
	* ritorna ArrayList<Entrate> di tutte le entrate
	*/
	public ArrayList<Entrate> selectAllEntrate() {
		return entrate.selectAll();
	}
	
	/**
	 * aggiunge nuova entrata passata come parametro
	 * @return boolean = true se è riuscito insert
	 */
	public boolean insertEntrate(Entrate entrata) {
		return entrate.insertEntrate(entrata);
	}
	
	/**
	 **
	 * elimina entrata che ha id passato come parametro
	 */
	public void deleteEntrate(int ID) {
		entrate.deleteEntrate(ID);
	}
	
	/**
	 **
	 * ritorna int id entrata tramite riga selezionata da tabella
	 * passata come parametro
	 */
	public int selectIDentrate(int rigaSelezionata) {
		return entrate.selectIDentrata(rigaSelezionata);
	}
	
	
	
	// USCITE
	
	/**
	* ritorna ArrayList<Uscite> di tutte le uscite
	*/
	public ArrayList<Uscite> selectAllUscite() {
		return uscite.selectAll();
	} 
	
	/**
	 * aggiunge nuova uscita passato come parametro
	 * @return boolean = true se è riuscito insert
	 */
	public boolean insertUscite(Uscite uscita) {
		return uscite.insertUscite(uscita);
	}
	
	/**
	 **
	 * elimina uscita che ha id passato come parametro
	 */
	public void deleteUscite(int ID) {
		uscite.deleteUscite(ID);
	} 
	
	/**
	 **
	 * ritorna int id uscita tramite riga selezionata da tabella
	 * passata come parametro
	 */
	public int selectIDuscite(int rigaSelezionata) {
		return uscite.selectIDuscita(rigaSelezionata);
	}
	
	
	
	

}
