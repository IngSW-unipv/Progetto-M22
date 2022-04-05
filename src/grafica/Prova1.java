package grafica;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import anagrafica.clienti.Clienti;
import anagrafica.clienti.ClientiDAO;

public class Prova1 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prova1 window = new Prova1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Prova1() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
		
	
	public void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(90, 30, 1000, 1500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "Cognome", "CF", "Email", "Cellulare", "Città", "Indirizzo"}
			},
			new String[] {
				"Nome", "Cognome", "CF", "Email", "Cellulare", "Città", "Indirizzo"
			}
		));
		table.setBounds(0, 0, 1000, 1500);
		frame.getContentPane().add(table);
	
		ClientiDAO cdao = new ClientiDAO();
		ArrayList<Clienti> res = cdao.selectAll();
		for (Clienti r : res)
			System.out.println(r.toString());
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object rowData[] = new Object[res.size()];
		for (int i = 0; i < res.size(); i++) {
			System.out.println(i);
			rowData[0] = res.get(i).getNome();
			rowData[1] = res.get(i).getCognome();
			rowData[2] = res.get(i).getCF();
			rowData[3] = res.get(i).getEmail();
			rowData[4] = res.get(i).getCellulare();
			rowData[5] = res.get(i).getCitta();
			rowData[6] = res.get(i).getIndirizzo();
			
			model.addRow(rowData);
		}

	}
}

