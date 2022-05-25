package controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.anagrafica.veterinari.Veterinari;
import model.magazzino.farmaci.LottoFarmaci;
import view.dashboard.DashBoardView;

public class DashBoardController {
	private ArrayList<Veterinari> vet;
	private DashBoardView dash;
	private ArrayList<LottoFarmaci> f;

	public DashBoardController(ArrayList<Veterinari> vet, DashBoardView dash, ArrayList<LottoFarmaci> f) {
		this.vet = vet;
		this.dash = dash;
		this.f = f;

		inizializzaComboBoxVet();
		fillTableFarmaciScadenza();
	}

	public void inizializzaComboBoxVet() {

		ArrayList<String> lista_CF = new ArrayList<String>();

		for (int i = 0; i < vet.size(); i++) {

			lista_CF.add(vet.get(i).getCF());
			dash.getComboBox1().addItem(lista_CF.get(i));
		}
	}

	public void fillTableFarmaciScadenza() {
		DefaultTableModel model = (DefaultTableModel) dash.getTabellaFarmaciView().getTable().getModel();
		Object rowData[] = new Object[4];
		for (int i = 0; i < f.size(); i++) {

			rowData[0] = f.get(i).getIDLotto();
			rowData[1] = f.get(i).getDataScadenza();
			rowData[2] = f.get(i).getQuantita();
			rowData[3] = f.get(i).getMode();

			model.addRow(rowData);
		}
	}
}