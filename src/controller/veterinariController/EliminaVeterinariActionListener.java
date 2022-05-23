package controller.veterinariController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.veterinari.Veterinari;

public class EliminaVeterinariActionListener implements ActionListener {
	
	private JTable table;
	private DbControllerSingleton dbControl;
	private ArrayList<Veterinari> vet;

	@Override
	public void actionPerformed(ActionEvent e) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int elementoSelezionato = table.getSelectedRow();
		model.removeRow(elementoSelezionato);

		dbControl.deleteVeterinario(vet.get(elementoSelezionato));
		vet.remove(elementoSelezionato);

	}

	public EliminaVeterinariActionListener(JTable table, DbControllerSingleton dbControl, ArrayList<Veterinari> vet) {
		this.table = table;
		this.dbControl = dbControl;
		this.vet = vet;
	}

}