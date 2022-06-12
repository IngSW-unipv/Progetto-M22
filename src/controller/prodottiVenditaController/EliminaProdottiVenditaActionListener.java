package controller.prodottiVenditaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class EliminaProdottiVenditaActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		DefaultTableModel modello = (DefaultTableModel) view.getProdottiVenditaPanel().getTabellaProdottiVenditaPanel()
				.getTable().getModel();

		int elementoSelezionato = view.getProdottiVenditaPanel().getTabellaProdottiVenditaPanel().getTable()
				.getSelectedRow();
		modello.removeRow(elementoSelezionato);

		int COD = dbControl.selectIDProdottiVendita(elementoSelezionato);

		dbControl.deleteProdottiVendita(COD);

		model.getProdottiVenditaArray().remove(elementoSelezionato);
	}

	public EliminaProdottiVenditaActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}
}
