package grafica.clienti;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import anagrafica.clienti.Clienti;
import anagrafica.clienti.ClientiDAO;

public class TabellaClientiView {

	JScrollPane scrollPane;
	JTable table = new JTable(); // ATTENZIONE QUI SE NO PUNTA NULLO
	ClientiDAO cdao = new ClientiDAO();
	ArrayList<Clienti> res = cdao.selectAll();
	String rowData[] = new String[res.size()];

	public TabellaClientiView(JScrollPane scrollPane) {

		this.scrollPane = scrollPane;
		scrollPane.setViewportView(table);

		DefaultTableModel modello1 = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Cognome", "CF", "Email", "Cellulare", "Città", "Indirizzo" });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);
		
		for (int i = 0; i < res.size(); i++) {

			rowData[0] = res.get(i).getNome();
			rowData[1] = res.get(i).getCognome();
			rowData[2] = res.get(i).getCF(); 
			rowData[3] = res.get(i).getEmail();
			rowData[4] = res.get(i).getCellulare();
			rowData[5] = res.get(i).getCitta();
			rowData[6] = res.get(i).getIndirizzo();

			modello1.addRow(rowData);
		}
	}

	public JTable getTable() {
		return table;
	}

	public ClientiDAO getCdao() {
		return cdao;
	}

}
