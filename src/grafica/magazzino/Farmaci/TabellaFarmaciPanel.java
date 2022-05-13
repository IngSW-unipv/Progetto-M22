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
	Object rowData[][] = new Object[res.size()][6];

	public TabellaFarmaciPanel(JScrollPane scrollPane) {

		this.scrollPane = scrollPane;
		scrollPane.setViewportView(table);

		System.out.println(res.size());
		DefaultTableModel modello1 = new DefaultTableModel(new Object[][] {},
				new String[] { "Lotto", "Assunzione", "Tipo", "Fornitore", "Data scadenza", "Qt." });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

		for (int i = 0; i < res.size(); i++) {
			
			rowData[i][0] = res.get(i).getIDLotto();
			rowData[i][1] = res.get(i).getMode();
			rowData[i][2] = res.get(i).getType();
			rowData[i][3] = res.get(i).getFornitore().getPIVA();
			rowData[i][4] = res.get(i).getDataScadenza().toString();
			rowData[i][5] = res.get(i).getQuantita();

			modello1.addRow(rowData[i]);
		}
	}

	public JTable getTable() {
		return table;
	}

	public LottoFarmaciDAO getFdao() {
		return fdao;
	}

}
