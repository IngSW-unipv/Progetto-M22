package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class PopupQuantitàPrezzo extends JFrame {
	private JTextField prezzotext;
	private JSpinner quantitàSpinner;
	private JLabel lblprezzo1;
	private JLabel lblPrezzo2;
	private JLabel lblQuantità;

	public PopupQuantitàPrezzo() {
		getContentPane().setLayout(null);

		quantitàSpinner = new JSpinner();
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

}
