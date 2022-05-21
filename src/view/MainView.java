package view;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.appuntamenti.Appuntamenti;
import view.clienti.ClientiPanel;
import view.dashboard.DashBoardView;
import view.dashboard.MenuView;
import view.dashboard.promemoria.PromemoriaView;

public class MainView extends JFrame {

	private DashBoardView dashboard;
	private ClientiPanel clientiPanel;

	public MainView() {

		setVisible(true);
		setBounds(500, 500, 2700, 2200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		dashboard = new DashBoardView();
		getContentPane().add(dashboard);

		clientiPanel = new ClientiPanel();

	}

	public DashBoardView getDashboard() {
		return dashboard;
	}

	public ClientiPanel getClientiPanel() {
		return clientiPanel;
	}

}
