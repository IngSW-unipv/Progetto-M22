package view.login;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import view.MainView;

public class RegistratiView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField passwordField;
	private JTextField usernameText;
	private JLabel lblNuovoAccount;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnGo;
	private JPasswordField passwordField_1;
	private JLabel lblConfermaPassword;
	private JLabel lblPassword_2;
	private JComboBox comboBox;
	private JLabel lblDipendente;
	

	public RegistratiView() {

		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); // restituisce la dimensione dello schermo come oggetto Dimension
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		// centra il frame nello schermo
		setSize(screenWidth / 3, screenHeight / 3);
		//setLocationRelativeTo(null); // consente di riposizionare il frame
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		setSize(screenWidth / 3, screenHeight / 3);
		setLocation(0, 0); // consente di riposizionare il frame
		setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(90, 122, 206, 39);
		add(passwordField);

		usernameText = new JTextField();
		usernameText.setBounds(90, 71, 206, 39);
		add(usernameText);
		usernameText.setColumns(10);

		lblNuovoAccount = new JLabel("Registrati");
		lblNuovoAccount.setFont(new Font("Lucida Grande", Font.BOLD, 29));
		lblNuovoAccount.setBounds(28, 19, 178, 39);
		add(lblNuovoAccount);

		lblUsername = new JLabel("Username\n");
		lblUsername.setBounds(17, 82, 88, 16);
		add(lblUsername);

		lblPassword = new JLabel("Password\n");
		lblPassword.setBounds(17, 133, 88, 16);
		add(lblPassword);

		btnGo = new JButton("Crea nuovo account");
		btnGo.setBounds(357, 237, 117, 29);
		add(btnGo);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(90, 173, 206, 39);
		add(passwordField_1);

		lblConfermaPassword = new JLabel("Conferma \n\n");
		lblConfermaPassword.setBounds(17, 173, 129, 16);
		add(lblConfermaPassword);

		lblPassword_2 = new JLabel("password\n");
		lblPassword_2.setBounds(17, 193, 88, 16);
		add(lblPassword_2);

		comboBox = new JComboBox();
		comboBox.setBounds(99, 237, 197, 29);
		add(comboBox);

		lblDipendente = new JLabel("Dipendente");
		lblDipendente.setBounds(17, 242, 88, 16);
		add(lblDipendente);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTextField getPasswordField() {
		return passwordField;
	}

	public JTextField getUsernameText() {
		return usernameText;
	}

	public JLabel getLblNuovoAccount() {
		return lblNuovoAccount;
	}

	public JLabel getLblUsername() {
		return lblUsername;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public JButton getBtnGo() {
		return btnGo;
	}

	public JPasswordField getPasswordField_1() {
		return passwordField_1;
	}

	public JLabel getLblConfermaPassword() {
		return lblConfermaPassword;
	}

	public JLabel getLblPassword_2() {
		return lblPassword_2;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JLabel getLblDipendente() {
		return lblDipendente;
	}

}
