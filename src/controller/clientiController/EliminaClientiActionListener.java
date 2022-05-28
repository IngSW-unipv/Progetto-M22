package controller.clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class EliminaClientiActionListener implements ActionListener {

	private MainView view;
	private DbControllerSingleton dbControl;
	private SmartVetModel model;

	@Override
	public void actionPerformed(ActionEvent e) {

		DefaultTableModel modello = (DefaultTableModel) view.getClientiPanel().getTab().getTable().getModel();

		int elementoSelezionato = view.getClientiPanel().getTab().getTable().getSelectedRow();
		modello.removeRow(elementoSelezionato);

		dbControl.deleteCliente(model.getClientiArray().get(elementoSelezionato));
		model.getClientiArray().get(elementoSelezionato);

	}

	public EliminaClientiActionListener(MainView view, DbControllerSingleton dbControl, SmartVetModel model) {
		super();
		this.view = view;
		this.dbControl = dbControl;
		this.model = model;
	}

}