package view.dashboard.farmaciScadenza;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabellaFarmaciScadenzaView {

	private JTable table;

	public TabellaFarmaciScadenzaView(JScrollPane scrollPane) {

		// creo tabella farmaci scadenza
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Tipo", "Data scadenza", "Qt", "Assunzione" }));
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.setBounds(0, 0, 1000, 1500);

		// personalizzo per vet(0)
		/*
		 * DefaultTableModel model = (DefaultTableModel) table.getModel(); Object
		 * rowData[] = new Object[4]; for (int i = 0; i < farmaciScadenza.size(); i++) {
		 * 
		 * rowData[0] = farmaciScadenza.get(i).getType(); rowData[1] =
		 * farmaciScadenza.get(i).getDataScadenza(); rowData[2] =
		 * farmaciScadenza.get(i).getQuantita(); rowData[3] =
		 * farmaciScadenza.get(i).getMode();
		 * 
		 * model.addRow(rowData); }
		 */

	}

	public JTable getTable() {
		return table;
	}

}
