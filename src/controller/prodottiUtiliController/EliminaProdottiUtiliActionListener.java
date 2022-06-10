package controller.prodottiUtiliController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class EliminaProdottiUtiliActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		DefaultTableModel modello = (DefaultTableModel) view.getProdottiUtiliPanel().getTabellaProdottiUtili()
				.getTable().getModel();

		int elementoSelezionato = view.getProdottiUtiliPanel().getTabellaProdottiUtili().getTable().getSelectedRow();

		modello.removeRow(elementoSelezionato);

		int COD = dbControl.selectCODProdottiUtili(elementoSelezionato);

		dbControl.deleteProdottiUtili(COD);

		model.getProdottiUtiliArray().remove(elementoSelezionato);
	}

	public EliminaProdottiUtiliActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}
}
