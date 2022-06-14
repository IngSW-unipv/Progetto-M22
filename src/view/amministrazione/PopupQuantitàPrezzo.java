package view.amministrazione;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class PopupQuantitàPrezzo extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField prezzotext;
	private JSpinner quantitàSpinner;
	private JLabel lblprezzo1;
	private JLabel lblPrezzo2;
	private JLabel lblQuantità;
	private JButton btnGo;

	public PopupQuantitàPrezzo() {

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
		quantitàSpinner = new JSpinner(sm);
		quantitàSpinner.setBounds(255, 149, 54, 42);
		getContentPane().add(quantitàSpinner);

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

		lblQuantità = new JLabel("Inserisci la quantità");
		lblQuantità.setBounds(32, 162, 136, 16);
		getContentPane().add(lblQuantità);

		btnGo = new JButton("OK");
		btnGo.setBounds(342, 211, 117, 29);
		getContentPane().add(btnGo);
	}

	public JTextField getPrezzotext() {
		return prezzotext;
	}

	public JSpinner getQuantitàSpinner() {
		return quantitàSpinner;
	}

	public JLabel getLblprezzo1() {
		return lblprezzo1;
	}

	public JLabel getLblPrezzo2() {
		return lblPrezzo2;
	}

	public JLabel getLblQuantità() {
		return lblQuantità;
	}

	public JButton getBtnGo() {
		return btnGo;
	}

}
