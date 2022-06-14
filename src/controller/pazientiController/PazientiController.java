package controller.pazientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Collega i pazienti del model con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class PazientiController {

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
	public PazientiController(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();

		fillTable();
		fillComboBox();
		fillComboBox1();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();

	}
	
	/**
	 * Visualizza pazienti su tabella pazienti
	 * 
	 * @return void
	 */

	public void fillTable() {
		Object rowData[][] = new Object[model.getPazientiArray().size()][14];

		DefaultTableModel modello = (DefaultTableModel) view.getPazientiPanel().getTabellaPazienti().getTable()
				.getModel();

		for (int i = 0; i < model.getPazientiArray().size(); i++) {

			rowData[i][0] = model.getPazientiArray().get(i).getIDpaz();
			rowData[i][1] = model.getPazientiArray().get(i).getNome();
			rowData[i][2] = model.getPazientiArray().get(i).getSpecie();
			rowData[i][3] = model.getPazientiArray().get(i).getRazza();
			rowData[i][4] = model.getPazientiArray().get(i).getDataNascita();
			rowData[i][5] = model.getPazientiArray().get(i).getSesso();

			rowData[i][7] = model.getPazientiArray().get(i).getGruppoSanguigno();
			rowData[i][8] = model.getPazientiArray().get(i).getMicrochip();

			rowData[i][11] = model.getPazientiArray().get(i).getDataMorte();

			if (model.getPazientiArray().get(i).getVeterinario() == null) {
				rowData[i][6] = null;
			}

			else {
				rowData[i][6] = model.getPazientiArray().get(i).getVeterinario().getCF();

				rowData[i][10] = model.getPazientiArray().get(i).getPeso();
				rowData[i][9] = model.getPazientiArray().get(i).getSterilizzato();

				if (model.getPazientiArray().get(i).getCliente() == null) {
					rowData[i][12] = null;
				}

				else
					rowData[i][12] = model.getPazientiArray().get(i).getCliente().getCF();

			}

			rowData[i][13] = model.getPazientiArray().get(i).getNote();
			modello.addRow(rowData[i]);
		}

	}

	/**
	 * riempie la comboBox con tutti i veterinari presenti nel db
	 * 
	 * @return void
	 */
	@SuppressWarnings("unchecked")
	public void fillComboBox() {

		ArrayList<String> lista_CF = new ArrayList<String>();

		for (int i = 0; i < model.getVeterinariArray().size(); i++) {

			lista_CF.add(model.getVeterinariArray().get(i).getCF());

			if (lista_CF.get(i) != null) {
				view.getPazientiPanel().getVeterinariBox().addItem(lista_CF.get(i));

			}

			else {

			}

		}
	}

	/**
	 * riempie la comboBox con tutti i clienti presenti nel db
	 * 
	 * @return void
	 */
	@SuppressWarnings("unchecked")
	public void fillComboBox1() {

		ArrayList<String> lista_CF = new ArrayList<String>();

		for (int i = 0; i < model.getClientiArray().size(); i++) {

			lista_CF.add(model.getClientiArray().get(i).getCF());

			if (lista_CF.get(i) != null) {
				view.getPazientiPanel().getClientiBox().addItem(lista_CF.get(i));
			}
		}
	}

	/**
	 * Aggiunge action listener al menu per aprire pannello pazxienti da dashboard
	 * 
	 * @return void
	 */
	public void addActionListenersMenu() {

		view.getDashboard().getMenu().getMenuItemPazienti().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getPazientiPanel());
				view.getPazientiPanel().setVisible(true);
			}
		});

	}

	/**
	 * Aggiunge action listener per aggiungere, eliminare,
	 *  modificare, aggiornare pazienti
	 * 
	 * @return void
	 */
	public void addActionListenerButtons() {

		AggiungiPazientiActionListener addPazienti = new AggiungiPazientiActionListener(model, view, dbControl);
		view.getPazientiPanel().getBtnAggiungi().addActionListener(addPazienti);

		EliminaPazientiActionListener deletePazienti = new EliminaPazientiActionListener(model, view, dbControl);
		view.getPazientiPanel().getBtnElimina().addActionListener(deletePazienti);

		ModificaPazientiActionListener modificaPazienti = new ModificaPazientiActionListener(model, view);
		view.getPazientiPanel().getBtnModifica().addActionListener(modificaPazienti);

		AggiornaPazientiActionListener aggiornaPazienti = new AggiornaPazientiActionListener(model, dbControl, view);
		view.getPazientiPanel().getBtnAggiorna().addActionListener(aggiornaPazienti);

	}

	/**
	 * aggiunge action listener per tornare alla dashboard
	 * 
	 * @return void
	 */
	public void addActionListenerHome() {

		view.getPazientiPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getPazientiPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
