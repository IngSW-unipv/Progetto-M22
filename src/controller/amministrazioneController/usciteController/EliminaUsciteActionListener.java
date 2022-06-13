package controller.amministrazioneController.usciteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class EliminaUsciteActionListener implements ActionListener {
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel modello = (DefaultTableModel) view.getUscitePanel().getTab().getTable().getModel();

		int elementoSelezionato = view.getUscitePanel().getTab().getTable().getSelectedRow();

		modello.removeRow(elementoSelezionato);

		int COD = dbControl.selectIDuscite(elementoSelezionato);

		dbControl.deleteUscite(COD);

		model.getUsciteArray().remove(elementoSelezionato);
	}

	public EliminaUsciteActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
