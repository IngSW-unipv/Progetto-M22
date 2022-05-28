package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import view.clienti.ClientiPanel;
import view.dashboard.DashBoardView;
import view.fornitori.FornitoriPanel;
import view.magazzino.farmaci.FarmaciPanel;
import view.veterinari.VeterinariPanel;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private DashBoardView dashboard;
	private ClientiPanel clientiPanel;
	private FornitoriPanel fornitoriPanel;
	private FarmaciPanel farmaciPanel;
	private VeterinariPanel veterinariPanel;

	public MainView() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); //restituisce la dimensione dello schermo come oggetto Dimension
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		//centra il frame nello schermo
		setSize(screenWidth, screenHeight); 
		setLocation(screenWidth/4, screenHeight/4); //consente di riposizionare il frame

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		dashboard = new DashBoardView();
		getContentPane().add(dashboard);

		clientiPanel = new ClientiPanel();
		fornitoriPanel = new FornitoriPanel();
		farmaciPanel = new FarmaciPanel();
		veterinariPanel = new VeterinariPanel();

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

}
