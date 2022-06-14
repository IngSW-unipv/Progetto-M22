package controller.amministrazioneController.entrateController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/** 
 * Collega le entrate del model con il database e la view
 * @author      MMA
 * @version     1.0                 (current version number of program)
 */



public class EntrateController {
	
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * costruttore
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public EntrateController(SmartVetModel model, MainView view) {
		
		super();
		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();

		addActionListenersMenu();
		fillTable();
		addActionListenerButtons();
		addActionListenerHome();
	}

	/**
	* Visualizza le entrate su tabella entrate
	* in termini di prezzo, causa, tipo e data
	* @return void
	*/
	
	public void fillTable() {

		Object rowData[][] = new Object[model.getEntrateArray().size()][4];

		DefaultTableModel modello = (DefaultTableModel) view.getEntratePanel().getTab().getTable().getModel();

		for (int i = 0; i < model.getEntrateArray().size(); i++) {

			rowData[i][0] = model.getEntrateArray().get(i).getCausa();
			rowData[i][1] = model.getEntrateArray().get(i).getTipo();
			rowData[i][2] = model.getEntrateArray().get(i).getPrezzo();
			rowData[i][3] = model.getEntrateArray().get(i).getData();

			modello.addRow(rowData[i]);
		}
	}

	/**
	* Aggiunge action listener al menu per aprire pannello entrate da dashboard
	* @return void
	*/
	public void addActionListenersMenu() {

		view.getDashboard().getMenu().getMntmEntrate().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getEntratePanel());
				view.getEntratePanel().setVisible(true);
			} 
		});

	}

	/**
	* Aggiunge action listener al bottone per eliminare entrata selezionata
	* @return void
	*/
	public void addActionListenerButtons() {

		EliminaEntrateActionListener deleteEntrate = new EliminaEntrateActionListener(model, view, dbControl);
		view.getEntratePanel().getBtnElimina().addActionListener(deleteEntrate);

	}
	/**
	* Aggiunge bottone per ritornare alla dashboard
	* @return void
	*/

	public void addActionListenerHome() {

		view.getEntratePanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getEntratePanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
