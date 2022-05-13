package grafica.dashboard.promemoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import appuntamenti.visite.AppuntamentiDAO;
import appuntamenti.visite.Promemoria;

public class ComboBoxActionListener implements ActionListener {
	
	JScrollPane scrollPane;
	JComboBox comboBox1;
	
	public ComboBoxActionListener(JScrollPane scrollPane, JComboBox comboBox1) {
		this.scrollPane = scrollPane;
		this.comboBox1 = comboBox1;
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// creo tabelle personalizzate per promemoria in base al CF VET

		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Sala", "Tipo", "Data", "Ora", "Note" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.getColumnModel().getColumn(4).setMinWidth(120);
		table.setBounds(0, 0, 1000, 1500);

		String CF_vet = (String) comboBox1.getSelectedItem(); 	// veterinario di cui voglio promemoria
		//System.out.println(CF_vet);
		AppuntamentiDAO pdao = new AppuntamentiDAO(); 	// array di appuntamenti veterinario
		ArrayList<Promemoria> app = pdao.appuntamentiOggi(CF_vet); 	// array di promemoria di OGGI veterinario

		// personalizzo tabella
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowData[] = new Object[5];  //fix

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
