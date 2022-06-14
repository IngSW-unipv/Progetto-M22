package view.dashboard.farmaciScadenza;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModelMio;

/**
 * 
 * @author MMA version 1.0
 *
 */
public class TabellaFarmaciScadenzaView {

	private JTable table;

	public TabellaFarmaciScadenzaView(JScrollPane scrollPane) {

		// creo tabella farmaci scadenza
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new TableModelMio(new Object[][] {},
				new String[] { "Lotto", "Tipo", "Data scadenza", "Qt", "Assunzione" }));
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.setBounds(0, 0, 1000, 1500);

	}

	public JTable getTable() {
		return table;
	}

}
