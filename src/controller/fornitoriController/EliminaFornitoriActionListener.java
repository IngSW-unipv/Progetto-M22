package controller.fornitoriController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.fornitori.Fornitori;
import model.anagrafica.veterinari.Veterinari;

public class EliminaFornitoriActionListener implements ActionListener {
	
	private JTable table;
	private DbControllerSingleton dbControl;
	private ArrayList<Fornitori> fo;

	@Override
	public void actionPerformed(ActionEvent e) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int elementoSelezionato = table.getSelectedRow();
		model.removeRow(elementoSelezionato);

		dbControl.deleteFornitore(fo.get(elementoSelezionato));
		fo.remove(elementoSelezionato);

	}

	public EliminaFornitoriActionListener(JTable table, DbControllerSingleton dbControl, ArrayList<Fornitori> fo) {
		this.table = table;
		this.dbControl = dbControl;
		this.fo = fo;
	}

}