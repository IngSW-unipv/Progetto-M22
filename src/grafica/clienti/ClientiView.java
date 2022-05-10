package grafica.clienti;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import anagrafica.clienti.Clienti;
import anagrafica.clienti.ClientiDAO;

public class ClientiView extends JFrame {

	//private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblCitt;
	private JLabel lblIndirizzo;
	private ClientiDAO cdao = new ClientiDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientiView window = new ClientiView();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientiView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ArrayList<Clienti> res = cdao.selectAll();
		for (Clienti r : res)
			System.out.println(r.toString());

		setBounds(500, 500, 2700, 2200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Cognome", "CF", "Email", "Cellulare", "Città", "Indirizzo" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);
		table.setBounds(0, 0, 1000, 1500);


		textField = new JTextField();
		textField.setBounds(1096, 12, 100, 25);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(); 
		textField_1.setColumns(10);
		textField_1.setBounds(1096, 72, 100, 25);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(1096, 132, 100, 25);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(1096, 192, 100, 25);
		getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(1096, 252, 100, 25);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1096, 312, 100, 25);
		getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(1096, 372, 100, 25);
		getContentPane().add(textField_6);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(970, 12, 70, 15);
		getContentPane().add(lblNome);

		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(970, 72, 70, 15);
		getContentPane().add(lblCognome);

		JLabel lblCf = new JLabel("CF");
		lblCf.setBounds(970, 132, 70, 15);
		getContentPane().add(lblCf);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(970, 192, 70, 15);
		getContentPane().add(lblEmail);

		JLabel lblCellulare = new JLabel("Cellulare");
		lblCellulare.setBounds(970, 252, 70, 15);
		getContentPane().add(lblCellulare);

		lblCitt = new JLabel("Città");
		lblCitt.setBounds(970, 312, 70, 15);
		getContentPane().add(lblCitt);

		lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setBounds(970, 372, 70, 15);
		getContentPane().add(lblIndirizzo);

		// frame.getContentPane().add(table);

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowData[] = new Object[res.size()];
		for (int i = 0; i < res.size(); i++) {

			rowData[0] = res.get(i).getNome();
			rowData[1] = res.get(i).getCognome();
			rowData[2] = res.get(i).getCF();
			rowData[3] = res.get(i).getEmail();
			rowData[4] = res.get(i).getCellulare();
			rowData[5] = res.get(i).getCitta();
			rowData[6] = res.get(i).getIndirizzo();

			model.addRow(rowData);
		}

		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aggiungi nuovo cliente

				String nome = textField.getText();
				String cognome = textField_1.getText();
				String CF = textField_2.getText();
				String email = textField_3.getText();
				String cellulare = textField_4.getText();
				String citta = textField_5.getText();
				String indirizzo = textField_6.getText();

				Clienti cl = new Clienti(nome, cognome, CF, email, cellulare, citta, indirizzo);

				boolean flag = cdao.insertClienti(cl);
				//ArrayList<Clienti> res = cdao.selectAll();

				if (flag) {
					rowData[0] = nome;
					rowData[1] = cognome;
					rowData[2] = CF;
					rowData[3] = email;
					rowData[4] = cellulare;
					rowData[5] = citta;
					rowData[6] = indirizzo;

					model.addRow(rowData);
					
				}
			}
		});

		
		btnAggiungi.setBounds(964, 444, 100, 25);
		getContentPane().add(btnAggiungi);

		JButton btnElimina = new JButton("Elimina");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int elementoSelezionato = table.getSelectedRow();
				model.removeRow(table.getSelectedRow());
				cdao.deleteClienti(res.get(elementoSelezionato));
				res.remove(elementoSelezionato);

			}
		});
		btnElimina.setBounds(1096, 444, 100, 25);
		getContentPane().add(btnElimina);
		
		JButton btnModifica = new JButton("Aggiorna");
		btnModifica.setBounds(1017, 492, 117, 25);
		getContentPane().add(btnModifica);
	}
}
