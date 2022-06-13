package controller;

import controller.appuntamentiController.occupazioneSaleController.OccupazioneSaleController;
import controller.clientiController.ClientiController;
import controller.entrateController.EntrateController;
import controller.farmaciController.FarmaciController;
import controller.fornitoriController.FornitoriController;
import controller.loginController.LoginController;
import controller.loginController.RegistratiController;
import controller.pazientiController.PazientiController;
import controller.prodottiUtiliController.ProdottiUtiliController;
import controller.prodottiVenditaController.ProdottiVenditaController;
import controller.veterinariController.VeterinariController;
import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class Controller {

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

	public Controller(SmartVetModel m, MainView v) {

		model = m;
		view = v;

		initComponents();

	}

	private void initComponents() {

		dbControl = new DbControllerSingleton();

		loginController = new LoginController(view, model, dbControl);

		populateArrays();

		clientiController = new ClientiController(model, view, dbControl);

		veterinariController = new VeterinariController(model, view, dbControl);

		fornitoriController = new FornitoriController(model, view, dbControl);

		farmaciController = new FarmaciController(model, view, dbControl);

		pazientiController = new PazientiController(model, view, dbControl);

		// appuntamentiController = new AppuntamentiController(model, view, dbControl);

		prodottiUtiliController = new ProdottiUtiliController(model, view, dbControl);

		prodottiVenditaController = new ProdottiVenditaController(model, view, dbControl);

		occupazioneSaleController = new OccupazioneSaleController(model, view, dbControl);

		registratiController = new RegistratiController(view, model, dbControl);
		// storicoController = new StoricoController(model, view, dbControl);

		entrateController = new EntrateController(model, view);
	}

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
	}

}
