package database.connectionSQL;

import java.sql.Connection;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.clientiDAO.ClientiDAO;
import database.classiDAO.anagraficaDAO.fornitoriDAO.FornitoriDAO;
import database.classiDAO.anagraficaDAO.veterinariDAO.VeterinariDAO;
import database.classiDAO.appuntamentiDAO.AppuntamentiDAO;
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

	private static final String String = null;

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

	public DbControllerSingleton() { // va bene public o get?

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

	public ArrayList<Clienti> selectAllClienti() {

		return clienti.selectAll();
	}


	public ArrayList<Fornitori> selectAllFornitori() {
		return fornitori.selectAll();
	}

	public ArrayList<Veterinari> selectAllVeterinari() {
		return vets.selectAll();
	}

	public ArrayList<Paziente> selectAllPazienti() {
		return paz.selectAll();
	}

	public ArrayList<Appuntamenti> selectAllAppuntamenti() {
		return app.selectAll();
	}

	public ArrayList<Appuntamenti> selectAllPromemoriaOggi(String CF_vet) {
		return app.appuntamentiOggi(CF_vet);
	}

	public ArrayList<LottoFarmaci> selectAllLottoFarmaci() {
		return farm.selectAll();
	}

	public Fornitori selectFornitoreFromPiva(String PIVA) {
		return farm.select_Forn(PIVA);
	}

	public boolean addNuovoLotto(LottoFarmaci lf) {
		return farm.insertFarmaci(lf);
	}

	public void deleteLotto(LottoFarmaci lf) {
		farm.deleteFarmaci(lf);
	}

	public ArrayList<ProdottiUtili> selectAllProdottiUtili() {
		return prods_u.selectAll();
	}

	public ArrayList<ProdottiVendita> selectAllProdottiVendita() {
		return prods_v.selectAll();
	}

	public void deleteFornitore(Fornitori fo) {
		// TODO Auto-generated method stub
		fornitori.deleteFornitori(fo);
	}

	public boolean addNuovoFornitore(Fornitori fo) {

		return fornitori.insertFornitore(fo);

	}

	
	public boolean addNuovoCliente(Clienti cl) {

		return clienti.insertClienti(cl);

	}

	public void deleteCliente(Clienti cl) {

		clienti.deleteClienti(cl);
	}

	public boolean addNuovoVeterinario(Veterinari vet) {
		return vets.insertVeterinari(vet) ;

	}
	
	public void deleteVeterinario(Veterinari vet) {
		vets.deleteVeterinari(vet);
	}
	
}
