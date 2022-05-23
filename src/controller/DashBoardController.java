package controller;

import java.util.ArrayList;

import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;
import view.dashboard.DashBoardView;

public class DashBoardController {
	private ArrayList<Veterinari> vet;
	private DashBoardView dash;

	public DashBoardController(ArrayList<Veterinari> vet, DashBoardView dash) {
		this.vet = vet;
		this.dash = dash;

		inizializzaComboBoxVet();
	}

	public void inizializzaComboBoxVet() {

		ArrayList<String> lista_CF = new ArrayList<String>();

		for (int i = 0; i < vet.size(); i++) {

			lista_CF.add(vet.get(i).getCF());
			dash.getComboBox1().addItem(lista_CF.get(i));
		}
	}

}