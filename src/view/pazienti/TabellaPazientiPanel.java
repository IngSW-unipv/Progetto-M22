package view.pazienti;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabellaPazientiPanel {

	private JTable table;

	public TabellaPazientiPanel(JScrollPane scrollPane) {

		table = new JTable();
		scrollPane.setViewportView(table);
		
		DefaultTableModel modello1 = new DefaultTableModel(new Object[][] {},
				new String[] {"Nome", "Tipo", "Razza", "Data nascita", "Sesso",
							"Veterinario", "Gruppo Sanguigno", "Microchip", "Sterilizzato", "Peso", 
							"Data Morte", "Proprietario", "Note"});

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

	}

	public JTable getTable() {
		return table;
	}

}

