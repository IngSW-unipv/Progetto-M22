package view.amministrazione.uscite;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabellaUscitePanel {
	
	private JTable table;

	public TabellaUscitePanel(JScrollPane scrollPane) {

		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel modello1 = new DefaultTableModel(new Object[][] {},
				new String[] { "Causa", "Tipo", "Prezzoa"});

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

	}

	public JTable getTable() {
		return table;
	}
}
