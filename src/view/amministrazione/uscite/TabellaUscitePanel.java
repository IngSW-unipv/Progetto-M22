package view.amministrazione.uscite;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModelMio;

/**
 * 
 * @author MMA version 1.0
 *
 */
public class TabellaUscitePanel {

	private JTable table;

	public TabellaUscitePanel(JScrollPane scrollPane) {

		table = new JTable();
		scrollPane.setViewportView(table);

		TableModelMio modello1 = new TableModelMio(new Object[][] {}, new String[] { "Causa", "Tipo", "Prezzo" });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

	}

	public JTable getTable() {
		return table;
	}
}
