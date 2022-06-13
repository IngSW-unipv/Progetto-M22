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
				new DefaultTableModel(new Object[][] {}, new String[] { "Lotto", "Tipo", "Data scadenza", "Qt", "Assunzione" }));
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.setBounds(0, 0, 1000, 1500); 

	}

	public JTable getTable() {
		return table;
	}

}
