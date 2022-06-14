package view.dashboard.promemoria;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModelMio;

public class PromemoriaView {

	private JTable table;

	public PromemoriaView(JScrollPane scrollPane) {

		table = new JTable();

		scrollPane.setViewportView(table);

		table.setModel(new TableModelMio(new Object[][] {}, new String[] { "Sala", "Tipo", "Data", "Ora", "Note" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.getColumnModel().getColumn(4).setMinWidth(120);
		table.setBounds(0, 0, 1000, 1500);

	}

	public JTable getTable() {
		return table;
	}

}
