package view.veterinari;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabellaVeterinariPanel {

	//private JScrollPane scrollPane;
	private JTable table; // ATTENZIONE QUI SE NO PUNTA NULLO

	public TabellaVeterinariPanel(JScrollPane scrollPane) {

		table = new JTable();
		//this.scrollPane = scrollPane;
		scrollPane.setViewportView(table);

		DefaultTableModel modello1 = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Cognome", "CF", "Email", "Cellulare", "Città", "Indirizzo", "Piva", "Contratto", 
								"Stipendio", "Commissioni", "Iban" });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

	}

	public JTable getTable() {
		return table;
	}

}
