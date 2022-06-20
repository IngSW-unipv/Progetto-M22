package controller.amministrazioneController.usciteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Collega le uscite del model con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */

public class UsciteController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * costruttore
	 * 
	 * @param view grafica
	 */
	public UsciteController(MainView view, SmartVetModel model) {

		super();
		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();

		fillTable();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();
	}

	/**
	 * Visualizza le uscite su tabella uscite in termini di prezzo, causa, tipo e
	 * data
	 * 
	 * @return void
	 */
	private void fillTable() {
		Object rowData[][] = new Object[model.getUsciteArray().size()][3];

		DefaultTableModel modello = (DefaultTableModel) view.getUscitePanel().getTab().getTable().getModel();

		for (int i = 0; i < model.getUsciteArray().size(); i++) {

			rowData[i][0] = model.getUsciteArray().get(i).getCausa();
			rowData[i][1] = model.getUsciteArray().get(i).getTipo();
			rowData[i][2] = model.getUsciteArray().get(i).getPrezzo();
			modello.addRow(rowData[i]);
		}
	}

	/**
	 * Aggiunge action listener al menu per aprire pannello entrate da dashboard
	 * 
	 * @return void
	 */

	private void addActionListenersMenu() {

		view.getDashboard().getMenu().getMntmUscite().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getUscitePanel());
				view.getUscitePanel().setVisible(true);
			}
		});

	}

	/**
	 * Aggiunge action listener al bottone per eliminare e aggiungere uscita
	 * selezionata
	 * 
	 * @return void
	 */

	private void addActionListenerButtons() {

		AggiungiUsciteActionListener addUscite = new AggiungiUsciteActionListener(model, view, dbControl);
		view.getUscitePanel().getBtnAggiungi().addActionListener(addUscite);

		EliminaUsciteActionListener deleteUscite = new EliminaUsciteActionListener(model, view, dbControl);
		view.getUscitePanel().getBtnElimina().addActionListener(deleteUscite);

	}

	/**
	 * Aggiunge action listener bottone per ritornare alla dashboard
	 * 
	 * @return void
	 */

	private void addActionListenerHome() {

		view.getUscitePanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getUscitePanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}