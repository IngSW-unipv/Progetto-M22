package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

/**
 * Collega i clienti del model con il database e la view
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class ClientiController {

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
	public ClientiController(SmartVetModel model, MainView view) {
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
	 * Visualizza clienti su tabella clienti
	 * 
	 * @return void
	 */
	public void fillTable() {
		int righe = model.getClientiArray().size();
		String rowData[][] = new String[righe][7];

		DefaultTableModel modello = (DefaultTableModel) view.getClientiPanel().getTab().getTable().getModel();

		for (int i = 0; i < righe; i++) {

			rowData[i][0] = model.getClientiArray().get(i).getNome();
			rowData[i][1] = model.getClientiArray().get(i).getCognome();
			rowData[i][2] = model.getClientiArray().get(i).getCF();
			rowData[i][3] = model.getClientiArray().get(i).getEmail();
			rowData[i][4] = model.getClientiArray().get(i).getCellulare();
			rowData[i][5] = model.getClientiArray().get(i).getCitta();
			rowData[i][6] = model.getClientiArray().get(i).getIndirizzo();

			modello.addRow(rowData[i]);
		}
	}

	/**
	 * Aggiunge action listener al menu per aprire pannello clienti da dashboard
	 * 
	 * @return void
	 */
	public void addActionListenersMenu() {
		view.getDashboard().getMenu().getMntmClienti().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getDashboard().setVisible(false);
				view.add(view.getClientiPanel());
				view.getClientiPanel().setVisible(true);
			}
		});

	}

	/**
	 * Aggiunge action listener ai bottoni per aggiungere eliminare, modificare,
	 * aggiornare clienti in clientipanel selezionata
	 * 
	 * @return void
	 */
	public void addActionListenerButtons() {
		AggiungiClienteActionListener addCliente = new AggiungiClienteActionListener(model, view, dbControl);

		view.getClientiPanel().getBtnAggiungi().addActionListener(addCliente);

		EliminaClientiActionListener deleteCliente = new EliminaClientiActionListener(view, dbControl, model);
		view.getClientiPanel().getBtnElimina().addActionListener(deleteCliente);

		ModificaClientiActionListener modificaCliente = new ModificaClientiActionListener(model, view);
		view.getClientiPanel().getBtnModifica().addActionListener(modificaCliente);

		AggiornaClientiActionListener aggiornaCliente = new AggiornaClientiActionListener(view, dbControl, model);
		view.getClientiPanel().getBtnAggiorna().addActionListener(aggiornaCliente);

	}

	/**
	 * Aggiunge action listener bottone per ritornare alla dashboard
	 * 
	 * @return void
	 */
	public void addActionListenerHome() {
		view.getClientiPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getClientiPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
