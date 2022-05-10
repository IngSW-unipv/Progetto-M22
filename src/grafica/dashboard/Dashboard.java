package grafica.dashboard;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import anagrafica.veterinari.VeterinariDAO;
import appuntamenti.visite.Appuntamenti;
import appuntamenti.visite.AppuntamentiDAO;
import appuntamenti.visite.Promemoria;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Dashboard {

	private JFrame frame;
	private JTable table;
	VeterinariDAO vdao = new VeterinariDAO();
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ArrayList<String> listeCF = vdao.getCFDAO();
		frame = new JFrame();
		frame.setBounds(500, 500, 2700, 2200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox comboBox1 = new JComboBox(listeCF.toArray());
		comboBox1.setBounds(124, 23, 192, 17);
		frame.getContentPane().add(comboBox1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 83, 435, 249);
		frame.getContentPane().add(scrollPane);

		JLabel lblVeterinario = new JLabel("Veterinario:");
		lblVeterinario.setBounds(26, 24, 115, 15);
		frame.getContentPane().add(lblVeterinario);

		// solo per avere una tabella di inizio
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Sala", "Tipo", "Data", "Ora", "Note" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.setBounds(0, 0, 1000, 1500);
		
		JLabel lblPromemoria = new JLabel("PROMEMORIA");
		lblPromemoria.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPromemoria.setBounds(185, 40, 146, 48);
		frame.getContentPane().add(lblPromemoria);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(635, 83, 315, 249);
		frame.getContentPane().add(scrollPane_1);
		
	
		String CF_vet = (String) comboBox1.getItemAt(0);
		AppuntamentiDAO pdao = new AppuntamentiDAO();

		ArrayList<Promemoria> app = pdao.appuntamentiOggi(CF_vet);

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

		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(new Object[][] {},
						new String[] { "Sala", "Tipo", "Data", "Ora", "Note" }));
				table.getColumnModel().getColumn(0).setPreferredWidth(95);
				table.getColumnModel().getColumn(0).setMinWidth(95);
				table.setBounds(0, 0, 1000, 1500);

				String CF_vet = (String) comboBox1.getSelectedItem();
				// System.out.println(CF_vet);
				AppuntamentiDAO pdao = new AppuntamentiDAO();

				ArrayList<Promemoria> app = pdao.appuntamentiOggi(CF_vet);

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Object rowData[] = new Object[5];
				System.out.println(app.size());
				for (int i = 0; i < app.size(); i++) {

					rowData[0] = app.get(i).getSala();
					rowData[1] = app.get(i).getTipo();
					rowData[2] = app.get(i).getData();
					rowData[3] = app.get(i).getTime();
					rowData[4] = app.get(i).getNote();

					model.addRow(rowData);
				}
			}
			
		});
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}
}
