package controller.appuntamentiController.occupazioneSaleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class OccupazioneSaleController {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public OccupazioneSaleController(SmartVetModel model, MainView view) {

		this.model = model;
		this.view = view;
		dbControl = DbControllerSingleton.getInstance();

		fillTable();
		addActionListenersMenu();
		addActionListenerHome();
	}

	public void fillTable() {

		Object rowData[][] = new Object[model.getSaleOccupateArray().size()][5];
		DefaultTableModel modello = (DefaultTableModel) view.getSaleOccupatePanel().getTable().getModel();

		for (int i = 0; i < model.getSaleOccupateArray().size(); i++) {

			rowData[i][0] = model.getSaleOccupateArray().get(i).getPaziente().getIDpaz();
			rowData[i][1] = model.getSaleOccupateArray().get(i).getSala();
			rowData[i][2] = model.getSaleOccupateArray().get(i).getTipo();
			rowData[i][3] = model.getSaleOccupateArray().get(i).getData();
			rowData[i][4] = model.getSaleOccupateArray().get(i).getTime();

			modello.addRow(rowData[i]);
		}
	}

	public void addActionListenerHome() {
		view.getSaleOccupatePanel().getBtnHome().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.getSaleOccupatePanel().setVisible(false);
				view.add(view.getDashboard());
				view.getDashboard().setVisible(true);
			}
		});
	}

	public void addActionListenersMenu() {
		view.getDashboard().getMenu().getMntmSaleOccupate().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				view.getDashboard().setVisible(false);
				view.add(view.getSaleOccupatePanel());
				view.getSaleOccupatePanel().setVisible(true);
			}
		});

	}
}
