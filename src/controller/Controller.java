package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controller.amministrazioneController.entrateController.EntrateController;
import controller.amministrazioneController.usciteController.UsciteController;
import controller.appuntamentiController.occupazioneSaleController.OccupazioneSaleController;
import controller.clientiController.ClientiController;
import controller.farmaciController.FarmaciController;
import controller.fornitoriController.FornitoriController;
import controller.loginController.LoginController;
import controller.loginController.RegistratiController;
import controller.pazientiController.PazientiController;
import controller.prodottiUtiliController.ProdottiUtiliController;
import controller.prodottiVenditaController.ProdottiVenditaController;
import controller.veterinariController.VeterinariController;
import database.connectionSQL.DbControllerSingleton;
import database.connectionSQL.DbSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Collega il model con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class Controller {

	private DbSingleton db;
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private ClientiController clientiController;
	private VeterinariController veterinariController;
	private FornitoriController fornitoriController;
	private FarmaciController farmaciController;
	private PazientiController pazientiController;
	private ProdottiUtiliController prodottiUtiliController;
	private LoginController loginController;
	private OccupazioneSaleController occupazioneSaleController;
	private ProdottiVenditaController prodottiVenditaController;
	private RegistratiController registratiController;
	private EntrateController entrateController;
	private UsciteController usciteController;

	/**
	 * costruttore
	 * inizializza tutti i componenti
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public Controller(SmartVetModel m, MainView v) {

		model = m;
		view = v;

		initComponents();

	}

	/**
	 * istanzia tutti i controller più piccoli
	 * 
	 * @return void
	 */

	private void initComponents() {

		chiudiConnessioneDB();
		
		dbControl = DbControllerSingleton.getInstance();

		loginController = new LoginController(view, model);

		populateArrays();

		clientiController = new ClientiController(view, model);

		veterinariController = new VeterinariController(model, view);

		fornitoriController = new FornitoriController(model, view);

		farmaciController = new FarmaciController(view, model);

		pazientiController = new PazientiController(view, model);

		prodottiUtiliController = new ProdottiUtiliController(model, view);

		prodottiVenditaController = new ProdottiVenditaController(model, view);

		occupazioneSaleController = new OccupazioneSaleController(model, view);

		registratiController = new RegistratiController(view, model);

		entrateController = new EntrateController(model, view);

		usciteController = new UsciteController(view, model);
	}

	/**
	 * popola tutti gli array del model
	 * con i record del database presenti
	 * 
	 * @return void
	 */
	private void populateArrays() {

		model.populateClienti(dbControl.selectAllClienti());
		model.populateFornitori(dbControl.selectAllFornitori());
		model.populatePazienti(dbControl.selectAllPazienti());
		model.populateVeterinari(dbControl.selectAllVeterinari());
		model.populateProdottiUtili(dbControl.selectAllProdottiUtili());
		model.populateProdottivendibili(dbControl.selectAllProdottiVendita());
		model.populateLottoFarmaci(dbControl.selectAllLottoFarmaci());
		model.populateFarmaciScadenza(dbControl.selectFarmaciScadenza());
		model.populateSaleOccupate(dbControl.selectAllAppuntamenti());
		model.populateEntrate(dbControl.selectAllEntrate());
		model.populateUscite(dbControl.selectAllUscite());
	}
	
	private void chiudiConnessioneDB() {

		view.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
			db = DbSingleton.getInstance();
			System.out.println("ho chiuso db connection");
			db.closeConnection();
			System.exit(0);
			}
		});
	}
}
