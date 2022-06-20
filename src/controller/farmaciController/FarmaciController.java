package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Collega i farmaci del model con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class FarmaciController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param view      grafica
	 */
	public FarmaciController(MainView view, SmartVetModel model) {
		super();
		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();

		addActionListenersMenu();
		fillTable();
		fillComboBox();
		addActionListenerButtons();
		addActionListenerHome();
	}

	/**
	 * Visualizza farmaci su tabella farmaci
	 * 
	 * @return void
	 */

	private void fillTable() {
		Object rowData[][] = new Object[model.getLottoFarmaciArray().size()][6];

		DefaultTableModel modello = (DefaultTableModel) view.getFarmaciPanel().getTabellaFarmaci().getTable()
				.getModel();

		for (int i = 0; i < model.getLottoFarmaciArray().size(); i++) {

			rowData[i][0] = model.getLottoFarmaciArray().get(i).getIDLotto();
			rowData[i][1] = model.getLottoFarmaciArray().get(i).getMode();
			rowData[i][2] = model.getLottoFarmaciArray().get(i).getType();
		
			rowData[i][4] = model.getLottoFarmaciArray().get(i).getDataScadenza();
			rowData[i][5] = model.getLottoFarmaciArray().get(i).getQuantita();

			if (model.getLottoFarmaciArray().get(i).getFornitore() == null) {
				rowData[i][3] = null;
			}

			else
				rowData[i][3] = model.getLottoFarmaciArray().get(i).getFornitore().getPIVA();

			modello.addRow(rowData[i]);
		}
	}

	/**
	 * riempie la comboBox con tutti i fornitori presenti nel db
	 * 
	 * @return void
	 */
	@SuppressWarnings("unchecked")
	private void fillComboBox() {

		ArrayList<String> listaPIVA = new ArrayList<String>();

		for (int i = 0; i < model.getFornitoriArray().size(); i++) {

			listaPIVA.add(model.getFornitoriArray().get(i).getPIVA());

			if (listaPIVA != null) {
				view.getFarmaciPanel().getFornitoriBox().addItem(listaPIVA.get(i));
			}
		}
	}

	/**
	 * Aggiunge action listener al menu per aprire pannello farmaci da dashboard
	 * 
	 * @return void
	 */
	private void addActionListenersMenu() {

		view.getDashboard().getMenu().getMntmFarmaci().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getFarmaciPanel());
				view.getFarmaciPanel().setVisible(true);
			}
		});

	}

	/**
	 * Aggiunge action listener per aggiungere, eliminare modificare, aggiornare,
	 * fatturare farmaci
	 * 
	 * @return void
	 */
	private void addActionListenerButtons() {

		AggiungiFarmaciActionListener addFarmaci = new AggiungiFarmaciActionListener(model, view, dbControl);
		view.getFarmaciPanel().getBtnAggiungi().addActionListener(addFarmaci);

		EliminaFarmaciActionListener deleteFarmaci = new EliminaFarmaciActionListener(model, view, dbControl);
		view.getFarmaciPanel().getBtnElimina().addActionListener(deleteFarmaci);

		ModificaFarmaciActionListener modificaFarmaci = new ModificaFarmaciActionListener(model, view);
		view.getFarmaciPanel().getBtnModifica().addActionListener(modificaFarmaci);

		AggiornaFarmaciActionListener aggiornaFarmaci = new AggiornaFarmaciActionListener(model, dbControl, view);
		view.getFarmaciPanel().getBtnAggiorna().addActionListener(aggiornaFarmaci);

		FatturaFarmaciActionListener fatturaFarmaci = new FatturaFarmaciActionListener(model, view, dbControl);
		view.getFarmaciPanel().getBtnFattura().addActionListener(fatturaFarmaci);

		PopUpGoBtnActionListener go = new PopUpGoBtnActionListener(model, view, dbControl, fatturaFarmaci);
		fatturaFarmaci.getPopup().getBtnGo().addActionListener(go);

	}

	/**
	 * aggiunge action listener per tornare alla dashboard
	 * 
	 * @return void
	 */
	private void addActionListenerHome() {

		view.getFarmaciPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getFarmaciPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
