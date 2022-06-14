package view.amministrazione.entrate;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModelMio;

public class TabellaEntratePanel {
	// private JScrollPane scrollPane;
	private JTable table; // ATTENZIONE QUI SE NO PUNTA NULLO

	public TabellaEntratePanel(JScrollPane scrollPane) {

		table = new JTable();
		// this.scrollPane = scrollPane;
		scrollPane.setViewportView(table);

		TableModelMio modello1 = new TableModelMio(new Object[][] {},
				new String[] { "Causa", "Tipo", "Prezzo", "Data" });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

	}

	public JTable getTable() {
		return table;
	}

}
