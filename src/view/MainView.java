package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import view.appuntamenti.AppuntamentiPanel;
import view.appuntamenti.StoricoPanel;
import view.clienti.ClientiPanel;
import view.dashboard.DashBoardView;
import view.fornitori.FornitoriPanel;
import view.login.LoginView;
import view.login.RegistratiView;
import view.magazzino.farmaci.FarmaciPanel;
import view.magazzino.prodottiUtili.ProdottiUtiliPanel;
import view.magazzino.prodottiVendita.ProdottiVenditaPanel;
import view.occupazioneSale.OccupazioneSalePanel;
import view.pazienti.PazientiPanel;
import view.veterinari.VeterinariPanel;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private DashBoardView dashboard;
	private LoginView loginView;
	private ClientiPanel clientiPanel;
	private FornitoriPanel fornitoriPanel;
	private FarmaciPanel farmaciPanel;
	private VeterinariPanel veterinariPanel;
	private PazientiPanel pazientiPanel;
	private AppuntamentiPanel appuntamentiPanel;
	private ProdottiUtiliPanel prodottiUtiliPanel;
	private StoricoPanel storicoPanel;
	private OccupazioneSalePanel saleOccupatePanel;
	private ProdottiVenditaPanel prodottiVenditaPanel;
	private RegistratiView registratiView;

	public MainView() {

		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = kit.getScreenSize(); // restituisce la dimensione dello schermo come oggetto Dimension
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		// centra il frame nello schermo
		setSize(screenWidth / 3, screenHeight / 3);
		setLocationRelativeTo(null); // consente di riposizionare il frame
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		loginView = new LoginView();
		getContentPane().add(loginView);

		dashboard = new DashBoardView();

		// getContentPane().add(dashboard);

		clientiPanel = new ClientiPanel();
		fornitoriPanel = new FornitoriPanel();
		farmaciPanel = new FarmaciPanel();
		veterinariPanel = new VeterinariPanel();
		pazientiPanel = new PazientiPanel();
		appuntamentiPanel = new AppuntamentiPanel();
		prodottiUtiliPanel = new ProdottiUtiliPanel();
		storicoPanel = new StoricoPanel();
		saleOccupatePanel = new OccupazioneSalePanel();
		prodottiVenditaPanel = new ProdottiVenditaPanel();
		registratiView = new RegistratiView();
	}

	public DashBoardView getDashboard() {
		return dashboard;
	}

	public ClientiPanel getClientiPanel() {
		return clientiPanel;
	}

	public FarmaciPanel getFarmaciPanel() {
		return farmaciPanel;
	}

	public FornitoriPanel getFornitoriPanel() {
		return fornitoriPanel;
	}

	public VeterinariPanel getVeterinariPanel() {
		return veterinariPanel;
	}

	public PazientiPanel getPazientiPanel() {
		return pazientiPanel;
	}

	public AppuntamentiPanel getAppuntamentiPanel() {
		return appuntamentiPanel;
	}

	public ProdottiUtiliPanel getProdottiUtiliPanel() {
		return prodottiUtiliPanel;
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public StoricoPanel getStoricoPanel() {
		return storicoPanel;
	}

	public OccupazioneSalePanel getSaleOccupatePanel() {
		return saleOccupatePanel;
	}

	public ProdottiVenditaPanel getProdottiVenditaPanel() {
		return prodottiVenditaPanel;
	}

	public RegistratiView getRegistratiView() {
		return registratiView;
	}

}
