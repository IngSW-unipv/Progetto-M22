package view.fornitori;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabellaFornitoriPanel {

	private JTable table;

	public TabellaFornitoriPanel(JScrollPane scrollPane) {

		table = new JTable();

		scrollPane.setViewportView(table);

		DefaultTableModel modello1 = new DefaultTableModel(new Object[][] {},
				new String[] { "PIVA", "NomeAzienda", "NumeroDiTelefono", "Email", "Sede", "IBAN�" });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

	}

	public JTable getTable() {
		return table;
	}

}
