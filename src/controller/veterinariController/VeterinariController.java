package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class VeterinariController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public VeterinariController(SmartVetModel model, MainView view) {
		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();

		fillTable();
		addActionListenersMenu();
		addActionListenerButtons();
		addActionListenerHome();
	}

	public void fillTable() {
		Object rowData[][] = new Object[model.getVeterinariArray().size()][12];
		DefaultTableModel modello = (DefaultTableModel) view.getVeterinariPanel().getTab().getTable().getModel();
		for (int i = 0; i < model.getVeterinariArray().size(); i++) {

			rowData[i][0] = model.getVeterinariArray().get(i).getNome();
			rowData[i][1] = model.getVeterinariArray().get(i).getCognome();
			rowData[i][2] = model.getVeterinariArray().get(i).getCF();
			rowData[i][3] = model.getVeterinariArray().get(i).getEmail();
			rowData[i][4] = model.getVeterinariArray().get(i).getCellulare();
			rowData[i][5] = model.getVeterinariArray().get(i).getCitta();
			rowData[i][6] = model.getVeterinariArray().get(i).getIndirizzo();
			rowData[i][7] = model.getVeterinariArray().get(i).getPIVA();
			rowData[i][8] = model.getVeterinariArray().get(i).getContratto();
			rowData[i][9] = model.getVeterinariArray().get(i).getStipendio();
			rowData[i][10] = model.getVeterinariArray().get(i).getCommissioni();
			rowData[i][11] = model.getVeterinariArray().get(i).getIBAN();

			modello.addRow(rowData[i]);
		}
	}

	public void addActionListenersMenu() {
		view.getDashboard().getMenu().getMntmDipendenti().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getDashboard().setVisible(false);
				view.add(view.getVeterinariPanel());
				view.getVeterinariPanel().setVisible(true);
			}
		});

	}

	public void addActionListenerButtons() {
		AggiungiVeterinarioActionListener addVeterinario = new AggiungiVeterinarioActionListener(model, view,
				dbControl);

		view.getVeterinariPanel().getBtnAggiungi().addActionListener(addVeterinario);

		EliminaVeterinariActionListener deleteVeterinario = new EliminaVeterinariActionListener(model, view, dbControl);
		view.getVeterinariPanel().getBtnElimina().addActionListener(deleteVeterinario);

		ModificaVeterinariActionListener modificaVeterinario = new ModificaVeterinariActionListener(model, view);
		view.getVeterinariPanel().getBtnModifica().addActionListener(modificaVeterinario);

		AggiornaVeterinariActionListener aggiornaVeterinario = new AggiornaVeterinariActionListener(model, dbControl, view);
		view.getVeterinariPanel().getBtnAggiorna().addActionListener(aggiornaVeterinario);

	}

	public void addActionListenerHome() {
		view.getVeterinariPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getVeterinariPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
