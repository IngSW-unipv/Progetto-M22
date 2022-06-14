package view.amministrazione;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
/** 
 * 
 * @author MMA
 * version 1.0
 *
 */
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class PopupQuantitaPrezzo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField prezzotext;
	private JSpinner quantitaSpinner;
	private JLabel lblprezzo1;
	private JLabel lblPrezzo2;
	private JLabel lblQuantita;
	private JButton btnGo;

	public PopupQuantitaPrezzo() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); // restituisce la dimensione dello schermo come oggetto Dimension
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		// centra il frame nello schermo
		setSize(screenWidth / 3, screenHeight / 3);
		setLocationRelativeTo(null); // consente di riposizionare il frame
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);

		SpinnerModel sm = new SpinnerNumberModel(1, 1, 4000, 1);
		quantitaSpinner = new JSpinner(sm);
		quantitaSpinner.setBounds(255, 149, 54, 42);
		getContentPane().add(quantitaSpinner);

		prezzotext = new JTextField();
		prezzotext.setBounds(207, 56, 149, 42);
		getContentPane().add(prezzotext);
		prezzotext.setColumns(10);

		lblprezzo1 = new JLabel("Inserisci il prezzo di ");
		lblprezzo1.setBounds(32, 56, 248, 29);
		getContentPane().add(lblprezzo1);

		lblPrezzo2 = new JLabel("ciò che vuoi fatturare");
		lblPrezzo2.setBounds(32, 78, 248, 29);
		getContentPane().add(lblPrezzo2);

		lblQuantita = new JLabel("Inserisci la quantità");
		lblQuantita.setBounds(32, 162, 136, 16);
		getContentPane().add(lblQuantita);

		btnGo = new JButton("OK");
		btnGo.setBounds(342, 211, 117, 29);
		getContentPane().add(btnGo);
	}

	public JTextField getPrezzotext() {
		return prezzotext;
	}

	public JSpinner getQuantitaSpinner() {
		return quantitaSpinner;
	}

	public JLabel getLblprezzo1() {
		return lblprezzo1;
	}

	public JLabel getLblPrezzo2() {
		return lblPrezzo2;
	}

	public JLabel getLblQuantita() {
		return lblQuantita;
	}

	public JButton getBtnGo() {
		return btnGo;
	}

}
