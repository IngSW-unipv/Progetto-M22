package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class ClientiController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public ClientiController(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;

		fillTable();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();
	}

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

	public void addActionListenersMenu() {
		view.getDashboard().getMenu().getMntmClienti().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getDashboard().setVisible(false);
				view.add(view.getClientiPanel());
				view.getClientiPanel().setVisible(true);
			}
		});

	}

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
