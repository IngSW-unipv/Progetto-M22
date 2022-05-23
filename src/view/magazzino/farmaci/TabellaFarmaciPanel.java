package view.magazzino.farmaci;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabellaFarmaciPanel {

	private JTable table;

	public TabellaFarmaciPanel(JScrollPane scrollPane) {

		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel modello1 = new DefaultTableModel(new Object[][] {},
				new String[] { "Lotto", "Assunzione", "Tipo", "Fornitore", "Data scadenza", "Qt." });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

	}

	public JTable getTable() {
		return table;
	}

}
