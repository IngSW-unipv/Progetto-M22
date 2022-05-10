package grafica;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import anagrafica.veterinari.Veterinari;
import anagrafica.veterinari.VeterinariDAO;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Prova1 {

	JFrame frame;
	String[] veterinari;
	VeterinariDAO vdao = new VeterinariDAO();
	JTable table;
	
	
	 static void main(String[] args) {
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
	 */
	public Prova1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<String> listeCF = vdao.getCFDAO();
		String[] lista = (String[]) listeCF.toArray();
		//DefaultComboBoxModel model = new DefaultComboBoxModel(lista);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		
		/*JComboBox comboBox = new JComboBox(lista);
		comboBox.setBounds(12, 0, 192, 17);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 29, 143, 96);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String CF_vet = (String) comboBox.getSelectedItem();
		System.out.println(CF_vet);*/
	}
}
