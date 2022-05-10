package grafica.magazzino.Farmaci;

import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import magazzino.farmaci.LottoFarmaci;
import magazzino.farmaci.LottoFarmaciDAO;

public class TabellaFarmaciPanel {

	JScrollPane scrollPane;
	JTable table = new JTable();
	LottoFarmaciDAO fdao = new LottoFarmaciDAO();
	ArrayList<LottoFarmaci> res = fdao.selectAll();
	Object rowData[] = new Object[res.size()];

	public TabellaFarmaciPanel(JScrollPane scrollPane) { 

		this.scrollPane = scrollPane;
		scrollPane.setViewportView(table);

		DefaultTableModel modello1 = new DefaultTableModel(new Object[][] {},
				new String[] { "Lotto", "Assunzione", "Tipo", "Fornitore", "Data scadenza", "Qt" });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

		for (int i = 0; i < 10; i++) {

			rowData[0] = res.get(i).getIDLotto();
			rowData[1] = res.get(i).getMode();
			rowData[2] = res.get(i).getType();
			rowData[3] = res.get(i).getFornitore().getPIVA();
			rowData[4] = res.get(i).getDataScadenza();
			rowData[5] = res.get(i).getQuantita();

			modello1.addRow(rowData);
		}
	}

	public JTable getTable() {
		return table;
	}

	public LottoFarmaciDAO getFdao() {
		return fdao;
	}

}
