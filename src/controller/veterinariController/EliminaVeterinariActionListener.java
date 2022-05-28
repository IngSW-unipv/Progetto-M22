package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class EliminaVeterinariActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {

		DefaultTableModel modello = (DefaultTableModel) view.getVeterinariPanel().getTab().getTable().getModel();

		int elementoSelezionato = view.getVeterinariPanel().getTab().getTable().getSelectedRow();
		modello.removeRow(elementoSelezionato);

		dbControl.deleteVeterinario(model.getVeterinariArray().remove(elementoSelezionato));
		model.getVeterinariArray().remove(elementoSelezionato);

	}

	public EliminaVeterinariActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}