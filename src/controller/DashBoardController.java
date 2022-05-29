package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.SmartVetModel;
import view.MainView;

public class DashBoardController {
	private SmartVetModel model;
	private MainView view;

	public DashBoardController(SmartVetModel model, MainView view) {
		this.model = model;
		this.view = view;

		inizializzaComboBoxVet();
		fillTableFarmaciScadenza();
	}

	public void inizializzaComboBoxVet() {

		ArrayList<String> lista_CF = new ArrayList<String>();

		for (int i = 0; i < model.getVeterinariArray().size(); i++) {

			lista_CF.add(model.getVeterinariArray().get(i).getCF());
			
			view.getDashboard().getComboBox1().addItem(lista_CF.get(i));
		}
	}

	public void fillTableFarmaciScadenza() {

		DefaultTableModel modello = (DefaultTableModel) view.getDashboard().getTabellaFarmaciView().getTable()
				.getModel();
		Object rowData[] = new Object[5];
		for (int i = 0; i < model.getFarmaciScadenzaArray().size(); i++) {
			
			rowData[0] = model.getFarmaciScadenzaArray().get(i).getIDLotto();
			rowData[4] = model.getFarmaciScadenzaArray().get(i).getType();
			rowData[2] = model.getFarmaciScadenzaArray().get(i).getDataScadenza();
			rowData[3] = model.getFarmaciScadenzaArray().get(i).getQuantita();
			rowData[1] = model.getFarmaciScadenzaArray().get(i).getMode();

			modello.addRow(rowData);
		}
	}
	
	
}