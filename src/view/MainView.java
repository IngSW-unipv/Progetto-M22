package view;

import javax.swing.JFrame;

import view.clienti.ClientiPanel;
import view.dashboard.DashBoardView;
import view.magazzino.farmaci.FarmaciPanel;

public class MainView extends JFrame {

	private DashBoardView dashboard;
	private ClientiPanel clientiPanel;
	private FarmaciPanel farmaciPanel;

	public MainView() {

		setVisible(true);
		setBounds(500, 500, 2700, 2200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		dashboard = new DashBoardView();
		getContentPane().add(dashboard);

		clientiPanel = new ClientiPanel();
		farmaciPanel = new FarmaciPanel();

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

}
