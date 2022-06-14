package view.pazienti;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModelMio;

public class TabellaPazientiPanel {

	private JTable table;

	public TabellaPazientiPanel(JScrollPane scrollPane) {

		table = new JTable();
		scrollPane.setViewportView(table);

		TableModelMio modello1 = new TableModelMio(new Object[][] {},
				new String[] { "ID", "Nome", "Tipo", "Razza", "Data nascita", "Sesso", "Veterinario",
						"Gruppo Sanguigno", "Microchip", "Sterilizzato", "Peso", "Data Morte", "Proprietario",
						"Note" });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

	}

	public JTable getTable() {
		return table;
	}

}
