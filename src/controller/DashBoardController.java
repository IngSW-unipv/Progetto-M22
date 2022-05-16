package controller;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.anagrafica.veterinari.Veterinari;
import model.appuntamenti.Appuntamenti;

public class DashBoardController {
	ArrayList<Veterinari> vet;
	JComboBox combobox;
	JScrollPane pane;
	ArrayList<Appuntamenti> app;
	String CF;

	public DashBoardController(ArrayList<Veterinari> vet, JComboBox combobox, JScrollPane pane,
			ArrayList<Appuntamenti> app) {
		this.vet = vet;
		this.combobox = combobox;
		this.pane = pane;
		this.app = app;

		inizializzaComboBoxVet(vet, combobox, pane, app);
	}

	public void inizializzaComboBoxVet(ArrayList<Veterinari> vet, JComboBox combobox, JScrollPane pane,
			ArrayList<Appuntamenti> app) {

		ArrayList<String> lista_CF = new ArrayList<String>();

		for (int i = 0; i < vet.size(); i++) {

			System.out.println(vet.get(i).getCF());
			lista_CF.add(vet.get(i).getCF());
			combobox.addItem(lista_CF.get(i));
		}

	}

}