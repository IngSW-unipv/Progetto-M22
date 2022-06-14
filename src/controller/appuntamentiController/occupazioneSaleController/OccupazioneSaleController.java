package controller.appuntamentiController.occupazioneSaleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * collega le sale occupate del model con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class OccupazioneSaleController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public OccupazioneSaleController(SmartVetModel model, MainView view) {
		
		this.view = view;
		this.model = model;
		dbControl = DbControllerSingleton.getInstance();

		fillTable();
		addActionListenersMenu();
		addActionListenerHome();
	}

	/**
	 * * Visualizza tutte le sale occupate dal giorno stesso in poi e in quale
	 * orario su tabella sale (da ogni veterinario)
	 * 
	 * @return void
	 */
	public void fillTable() {

		Object rowData[][] = new Object[model.getSaleOccupateArray().size()][5];
		DefaultTableModel modello = (DefaultTableModel) view.getSaleOccupatePanel().getTable().getModel();

		for (int i = 0; i < model.getSaleOccupateArray().size(); i++) {

			rowData[i][0] = model.getSaleOccupateArray().get(i).getPaziente().getIDpaz();
			rowData[i][1] = model.getSaleOccupateArray().get(i).getSala();
			rowData[i][2] = model.getSaleOccupateArray().get(i).getTipo();
			rowData[i][3] = model.getSaleOccupateArray().get(i).getData();
			rowData[i][4] = model.getSaleOccupateArray().get(i).getTime();

			modello.addRow(rowData[i]);
		}
	}

	/**
	 * Aggiunge action listener bottone per ritornare alla dashboard
	 * 
	 * @return void
	 */

	public void addActionListenerHome() {
		view.getSaleOccupatePanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getSaleOccupatePanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

	/**
	 * Aggiunge action listener al menu per aprire pannello sale da dashboard
	 * 
	 * @return void
	 */

	public void addActionListenersMenu() {
		view.getDashboard().getMenu().getMntmSaleOccupate().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getSaleOccupatePanel());
				view.getSaleOccupatePanel().setVisible(true);
			}
		});

	}
}
