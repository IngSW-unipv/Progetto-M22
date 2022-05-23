package view;

import javax.swing.JFrame;

import view.clienti.ClientiPanel;
import view.dashboard.DashBoardView;
import view.magazzino.farmaci.FarmaciPanel;
import view.veterinari.VeterinariPanel;

public class MainView extends JFrame {

	private DashBoardView dashboard;
	private ClientiPanel clientiPanel;
	private FarmaciPanel farmaciPanel;
	private VeterinariPanel veterinariPanel;

	public MainView() {

		setVisible(true);
		setBounds(500, 500, 2700, 2200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		dashboard = new DashBoardView();
		getContentPane().add(dashboard);

		clientiPanel = new ClientiPanel();
		farmaciPanel = new FarmaciPanel();
		//veterinariPanel = new VeterinariPanel();

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
	
	public VeterinariPanel getVeterinariPanel() {
		return veterinariPanel;
	}  

}
