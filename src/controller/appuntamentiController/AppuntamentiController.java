package controller.appuntamentiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Collega gli appuntamenti del model con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class AppuntamentiController {

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
	public AppuntamentiController(SmartVetModel model, MainView view) {

		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();

		if (model.getCFuser().equals("direzione")) {

			fillTable();
			view.getAppuntamentiPanel().addComboBoxVets();
			fillComboBoxVets();
		}

		else {

			fillTableDueToVeterinario();
		}

		fillComboBoxPaz();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();
	}

	/**
	 * si attiva solo se entra l'account direzione. visualizza la tabella
	 * appuntamenti di tutti gli appuntamenti di ogni veterinario dal giorno
	 * corrente in poi
	 * 
	 * @return void
	 */

	private void fillTable() {

		Object rowData[][] = new Object[model.getAppuntamentiArray().size()][8];
		DefaultTableModel modello = (DefaultTableModel) view.getAppuntamentiPanel().getTab().getTable().getModel();

		for (int i = 0; i < model.getAppuntamentiArray().size(); i++) {

			rowData[i][0] = model.getAppuntamentiArray().get(i).getPaziente().getIDpaz();
			rowData[i][1] = model.getAppuntamentiArray().get(i).getSala();
			rowData[i][2] = model.getAppuntamentiArray().get(i).getTipo();
			rowData[i][3] = model.getAppuntamentiArray().get(i).getData();
			rowData[i][4] = model.getAppuntamentiArray().get(i).getTime();
			if (model.getAppuntamentiArray().get(i).getVeterinario() != null) {
			rowData[i][5] = model.getAppuntamentiArray().get(i).getVeterinario().getCF();
			}
			else {
				rowData[i][5] = null;
			}
			rowData[i][6] = model.getAppuntamentiArray().get(i).getCosto();
			rowData[i][7] = model.getAppuntamentiArray().get(i).getNote();

			modello.addRow(rowData[i]);
		}
	}

	/**
	 * visualizza la tabella appuntamenti solo degli appuntamenti dal giorno
	 * corrente in poi del veterinario che si è loggato
	 * 
	 * @return void
	 */
	private void fillTableDueToVeterinario() {

		Object rowData[][] = new Object[model.getAppuntamentiArray().size()][8];
		DefaultTableModel modello = (DefaultTableModel) view.getAppuntamentiPanel().getTab().getTable().getModel();

		for (int i = 0; i < model.getAppuntamentiArray().size(); i++) {

			rowData[i][0] = model.getAppuntamentiArray().get(i).getPaziente().getIDpaz();
			rowData[i][1] = model.getAppuntamentiArray().get(i).getSala();
			rowData[i][2] = model.getAppuntamentiArray().get(i).getTipo();
			rowData[i][3] = model.getAppuntamentiArray().get(i).getData();
			rowData[i][4] = model.getAppuntamentiArray().get(i).getTime();
			if (model.getAppuntamentiArray().get(i).getVeterinario() != null) {
				rowData[i][5] = model.getAppuntamentiArray().get(i).getVeterinario().getCF();
				}
				else {
					rowData[i][5] = null;
				}
			rowData[i][6] = model.getAppuntamentiArray().get(i).getCosto();
			rowData[i][7] = model.getAppuntamentiArray().get(i).getNote();

			modello.addRow(rowData[i]);
		}
	}

	/**
	 * Aggiunge action listener al menu per aprire pannello appuntamenti da
	 * dashboard
	 * 
	 * @return void
	 */
	private void addActionListenersMenu() {
		view.getDashboard().getMenu().getMenuItemAppuntamenti().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getAppuntamentiPanel());
				view.getAppuntamentiPanel().setVisible(true);
			}
		});

	}

	/**
	 * Aggiunge action listenerper aggiungere, eliminare modificare, aggiornare,
	 * fatturare appuntamenti
	 * 
	 * @return void
	 */
	private void addActionListenerButtons() {
		AggiungiAppuntamentiActionListener addAppuntamenti = new AggiungiAppuntamentiActionListener(model, view,
				dbControl);

		view.getAppuntamentiPanel().getBtnAggiungi().addActionListener(addAppuntamenti);

		EliminaAppuntamentiActionListener deleteAppuntamenti = new EliminaAppuntamentiActionListener(model, view,
				dbControl);
		view.getAppuntamentiPanel().getBtnElimina().addActionListener(deleteAppuntamenti);

		ModificaAppuntamentiActionListener modificaAppuntamenti = new ModificaAppuntamentiActionListener(model, view);
		view.getAppuntamentiPanel().getBtnModifica().addActionListener(modificaAppuntamenti);

		AggiornaAppuntamentiActionListener aggiornaAppuntamenti = new AggiornaAppuntamentiActionListener(model,
				dbControl, view);
		view.getAppuntamentiPanel().getBtnAggiorna().addActionListener(aggiornaAppuntamenti);

		FatturaAppuntamentiActionListener fattura = new FatturaAppuntamentiActionListener(model, view, dbControl);
		view.getAppuntamentiPanel().getBtnFattura().addActionListener(fattura);

	}

	/**
	 * riempie la comboBox con tutti i pazienti presenti nel db
	 * 
	 * @return void
	 */
	@SuppressWarnings("unchecked")
	private void fillComboBoxPaz() {

		for (int i = 0; i < model.getPazientiArray().size(); i++) {

			view.getAppuntamentiPanel().getIDpazText().addItem(dbControl.selectID_PAZ(i));
		}

		for (int i = 0; i < dbControl.selectallIDsale().length; i++) {

			view.getAppuntamentiPanel().getSalaText().addItem(dbControl.selectallIDsale()[i]);
		}
	}

	/**
	 * riempie la comboBox con tutti i veterinari presenti nel db
	 * 
	 * @return void
	 */
	private void fillComboBoxVets() {
		ArrayList<String> listaCFvet = new ArrayList<String>();

		for (int i = 0; i < model.getVeterinariArray().size(); i++) {

			listaCFvet.add(model.getVeterinariArray().get(i).getCF());

			if (listaCFvet.get(i) != null && !(listaCFvet.get(i).equals("direzione"))) {

				view.getAppuntamentiPanel().getCFvetText().addItem(listaCFvet.get(i));
			}
		}
	}

	/**
	 * aggiunge action listener per tornare alla dashboard
	 * 
	 * @return void
	 */
	private void addActionListenerHome() {
		view.getAppuntamentiPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getAppuntamentiPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
