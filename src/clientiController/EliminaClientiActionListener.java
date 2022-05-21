package clientiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.anagrafica.clienti.Clienti;

public class EliminaClientiActionListener implements ActionListener {
	private JTable table;
	private DbControllerSingleton dbControl;
	private ArrayList<Clienti> cl;

	@Override
	public void actionPerformed(ActionEvent e) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		int elementoSelezionato = table.getSelectedRow();
		model.removeRow(elementoSelezionato);

		dbControl.deleteCliente(cl.get(elementoSelezionato));
		cl.remove(elementoSelezionato);

	}

	public EliminaClientiActionListener(JTable table, DbControllerSingleton dbControl, ArrayList<Clienti> cl) {
		this.table = table;
		this.dbControl = dbControl;
		this.cl = cl;
	}

}