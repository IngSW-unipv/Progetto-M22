package controller.appuntamentiController.StoricoController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class StoricoController {

	private SmartVetModel model;
	private MainView view;

	public StoricoController(SmartVetModel model, MainView view) {

		this.model = model;
		this.view = view;

		if (model.getCFuser().equals("direzione")) {

			fillTable();
		}

		else {

			fillTableDueToVeterinario();
		}

		addActionListenersMenu();
		addActionListenerHome();

	}

	public void fillTable() {

		Object rowData[][] = new Object[model.getStoricoArray().size()][8];
		DefaultTableModel modello = (DefaultTableModel) view.getStoricoPanel().getTable().getModel();

		for (int i = 0; i < model.getStoricoArray().size(); i++) {

			rowData[i][0] = model.getStoricoArray().get(i).getPaziente().getIDpaz();
			rowData[i][1] = model.getStoricoArray().get(i).getSala();
			rowData[i][2] = model.getStoricoArray().get(i).getTipo();
			rowData[i][3] = model.getStoricoArray().get(i).getData();
			rowData[i][4] = model.getStoricoArray().get(i).getTime();
			rowData[i][5] = model.getStoricoArray().get(i).getVeterinario().getCF();
			rowData[i][6] = model.getStoricoArray().get(i).getCosto();
			rowData[i][7] = model.getStoricoArray().get(i).getNote();

			modello.addRow(rowData[i]);
		}
	}

	public void fillTableDueToVeterinario() {

		Object rowData[][] = new Object[model.getStoricoArray().size()][8];
		DefaultTableModel modello = (DefaultTableModel) view.getStoricoPanel().getTable().getModel();

		for (int i = 0; i < model.getStoricoArray().size(); i++) {

			rowData[i][0] = model.getStoricoArray().get(i).getPaziente().getIDpaz();
			rowData[i][1] = model.getStoricoArray().get(i).getSala();
			rowData[i][2] = model.getStoricoArray().get(i).getTipo();
			rowData[i][3] = model.getStoricoArray().get(i).getData();
			rowData[i][4] = model.getStoricoArray().get(i).getTime();
			rowData[i][5] = model.getStoricoArray().get(i).getVeterinario().getCF();
			rowData[i][6] = model.getStoricoArray().get(i).getCosto();
			rowData[i][7] = model.getStoricoArray().get(i).getNote();

			modello.addRow(rowData[i]);
		}
	}

	public void addActionListenersMenu() {
		view.getDashboard().getMenu().getMenuItemStorico().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getDashboard().setVisible(false);
				view.add(view.getStoricoPanel());
				view.getStoricoPanel().setVisible(true);
			}
		});

	}

	public void addActionListenerHome() {
		view.getStoricoPanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getStoricoPanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

}
