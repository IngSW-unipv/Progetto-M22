package view.dashboard.farmaciScadenza;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.TableModelMio;

public class TabellaFarmaciScadenzaView {

	private JTable table;

	public TabellaFarmaciScadenzaView(JScrollPane scrollPane) {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); // restituisce la dimensione dello schermo come oggetto Dimension
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		// creo tabella farmaci scadenza
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new TableModelMio(new Object[][] {},
				new String[] { "Lotto", "Tipo", "Data scadenza", "Qt", "Assunzione" }));
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.setBounds(0, 0, screenHeight / 3, screenWidth / 3);

	}

	public JTable getTable() {
		return table;
	}

}
