package view.magazzino.prodottiVendita;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabellaProdottiVenditaPanel {
	
	private JTable table;

	public TabellaProdottiVenditaPanel(JScrollPane scrollPane) {

		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel modello1 = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Tipo", "Quantita", "Fornitore", "Data Scadenza"});

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

	}

	public JTable getTable() {
		return table;
	}

}
