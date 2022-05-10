package grafica.dashboard.farmaciScadenza;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import magazzino.farmaci.LottoFarmaci;
import magazzino.farmaci.LottoFarmaciDAO;

public class FarmaciScadenzaView {

	public FarmaciScadenzaView(JScrollPane scrollPane) {
		
		// creo tabella farmaci scadenza
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Tipo", "Data scadenza", "Qt", "Assunzione" }));
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.setBounds(0, 0, 1000, 1500);

		LottoFarmaciDAO f = new LottoFarmaciDAO();
		ArrayList<LottoFarmaci> farmaciScadenza = new ArrayList<>();
		farmaciScadenza = f.getFarmaciScadenza();

		// personalizzo per vet(0)
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowData[] = new Object[4];
		for (int i = 0; i < farmaciScadenza.size(); i++) {

			rowData[0] = farmaciScadenza.get(i).getType();
			rowData[1] = farmaciScadenza.get(i).getDataScadenza();
			rowData[2] = farmaciScadenza.get(i).getQuantita();
			rowData[3] = farmaciScadenza.get(i).getMode();

			model.addRow(rowData);
		}

	}
}
