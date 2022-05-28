package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class EliminaFornitoriActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {

		DefaultTableModel modello = (DefaultTableModel) view.getFornitoriPanel().getTab().getTable().getModel();

		int elementoSelezionato = view.getFornitoriPanel().getTab().getTable().getSelectedRow();
		modello.removeRow(elementoSelezionato);

		dbControl.deleteFornitore(model.getFornitoriArray().get(elementoSelezionato));
		model.getFornitoriArray().remove(elementoSelezionato);

	}

	public EliminaFornitoriActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}