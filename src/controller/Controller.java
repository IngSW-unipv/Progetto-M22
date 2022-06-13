package controller;

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
	private UsciteController usciteController;

	public Controller(SmartVetModel m, MainView v) {

		model = m;
		view = v;

		initComponents();

	}

	private void initComponents() {

		dbControl = DbControllerSingleton.getInstance();

		loginController = new LoginController(view, model);

		populateArrays();

		clientiController = new ClientiController(model, view);

		veterinariController = new VeterinariController(model, view);

		fornitoriController = new FornitoriController(model, view);

		farmaciController = new FarmaciController(model, view);

		pazientiController = new PazientiController(model, view);

		prodottiUtiliController = new ProdottiUtiliController(model, view);

		prodottiVenditaController = new ProdottiVenditaController(model, view);

		occupazioneSaleController = new OccupazioneSaleController(model, view);

		registratiController = new RegistratiController(view, model);

		entrateController = new EntrateController(model, view);

		usciteController = new UsciteController(model, view);
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
		model.populateEntrate(dbControl.selectAllEntrate());
		model.populateUscite(dbControl.selectAllUscite());
	}

}
