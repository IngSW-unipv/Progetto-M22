package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.appuntamenti.Appuntamenti;
import view.MainView;

public class Controller {

	private SmartVetModel model;
	private MainView view;
	DbControllerSingleton dbControl;
	private DashBoardController dashControl;

	public Controller(SmartVetModel m, MainView v) {

		model = m;
		view = v;

		initComponents();

	}

	private void initComponents() {
		dbControl = new DbControllerSingleton();
		populateArrays();
		DynamicPromemoria();
		dashControl = new DashBoardController(model.getVeterinariArray(), view.getComboBox1(),
				view.getPromemoriaScrollPane(), model.getPromemoriaOggiArray());

	}

	private void populateArrays() {

		model.populateClienti(dbControl.selectAllClienti());
		model.populateFornitori(dbControl.selectAllFornitori());
		model.populatePazienti(dbControl.selectAllPazienti());
		model.populateVeterinari(dbControl.selectAllVeterinari());
		model.populateAppuntamenti(dbControl.selectAllAppuntamenti());
		model.populateProdottiUtili(dbControl.selectAllProdottiUtili());
		model.populateProdottivendibili(dbControl.selectAllProdottiVendita());
		model.populateLottoFarmaci(dbControl.selectAllLottoFarmaci());

	}

	private void DynamicPromemoria() {
		ComboBoxVetssActionListener scegli_vet = new ComboBoxVetssActionListener(view.getPromemoriaScrollPane(),
				view.getComboBox1());

		view.getComboBox1().addActionListener(scegli_vet);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// siccome array promemoria è dinamico ho bisogno di lasciarlo qui per comodità
	// cerchiamo però di riempire questo controller il meno possibile!!!!!!!

	public class ComboBoxVetssActionListener implements ActionListener {

		JScrollPane scrollPane;
		JComboBox comboBox1;
		String CF;

		public ComboBoxVetssActionListener(JScrollPane scrollPane, JComboBox comboBox1) {
			this.scrollPane = scrollPane;
			this.comboBox1 = comboBox1;
		}

		public void actionPerformed(ActionEvent e) {

			// creo tabelle personalizzate per promemoria in base al CF VET
			// per bellezza se nessun selezionato inizializzo col primo

			if (comboBox1.getSelectedIndex() >= 0) {
				CF = (String) comboBox1.getSelectedItem();
			} else
				CF = (String) comboBox1.getItemAt(0);
			model.populatePromemoriaOggi(dbControl.selectAllPromemoriaOggi(CF));

			JTable table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { "Sala", "Tipo", "Data", "Ora", "Note" }));
			table.getColumnModel().getColumn(0).setPreferredWidth(95);
			table.getColumnModel().getColumn(0).setMinWidth(95);
			table.getColumnModel().getColumn(4).setMinWidth(120);
			table.setBounds(0, 0, 1000, 1500);

			// personalizzo tabella
			DefaultTableModel model1 = (DefaultTableModel) table.getModel();
			Object rowData[][] = new Object[model.getPromemoriaOggiArray().size()][5]; // fix

			for (int i = 0; i < model.getPromemoriaOggiArray().size(); i++) {

				rowData[i][0] = model.getPromemoriaOggiArray().get(i).getSala();
				rowData[i][1] = model.getPromemoriaOggiArray().get(i).getTipo();
				rowData[i][2] = model.getPromemoriaOggiArray().get(i).getData();
				rowData[i][3] = model.getPromemoriaOggiArray().get(i).getTime();
				rowData[i][4] = model.getPromemoriaOggiArray().get(i).getNote();

				model1.addRow(rowData[i]);
			}
		}
	}
}
