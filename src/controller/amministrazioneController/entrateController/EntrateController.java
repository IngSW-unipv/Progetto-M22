package controller.amministrazioneController.entrateController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class EntrateController {
	
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

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

	public void addActionListenersMenu() {

		view.getDashboard().getMenu().getMntmEntrate().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getEntratePanel());
				view.getEntratePanel().setVisible(true);
			} 
		});

	}

	public void addActionListenerButtons() {

		EliminaEntrateActionListener deleteEntrate = new EliminaEntrateActionListener(model, view, dbControl);
		view.getEntratePanel().getBtnElimina().addActionListener(deleteEntrate);

	}

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
