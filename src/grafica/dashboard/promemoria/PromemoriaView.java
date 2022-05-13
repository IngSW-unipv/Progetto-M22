package grafica.dashboard.promemoria;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import anagrafica.veterinari.VeterinariDAO;
import appuntamenti.visite.AppuntamentiDAO;
import appuntamenti.visite.Promemoria;

import javax.swing.JPanel;

public class PromemoriaView {

	VeterinariDAO vdao = new VeterinariDAO();

	public PromemoriaView(JComboBox comboBox1, JScrollPane scrollPane) {

		// inizializzo panel_Promemoria con la tabella del primo veterinario della
		// comboBox, soltanto per estetica

		// creo tabella promemoria
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Sala", "Tipo", "Data", "Ora", "Note" }));
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.setBounds(0, 0, 1000, 1500);

		// prendo il primo vet=vet(0) che è gia nella comboBox e personalizzo per lui
		// (soltanto per estetica)

		String CF_vet = (String) comboBox1.getItemAt(0);
		AppuntamentiDAO pdao = new AppuntamentiDAO();
		ArrayList<Promemoria> app = pdao.appuntamentiOggi(CF_vet); // Array promemoria appuntamenti di oggi del vet

		// personalizzo per vet(0)
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowData[] = new Object[5];
		for (int i = 0; i < app.size(); i++) {

			rowData[0] = app.get(i).getSala();
			rowData[1] = app.get(i).getTipo();
			rowData[2] = app.get(i).getData();
			rowData[3] = app.get(i).getTime();
			rowData[4] = app.get(i).getNote();

			model.addRow(rowData);
		}

	}
}
