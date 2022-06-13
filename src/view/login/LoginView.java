package view.login;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class LoginView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField usernameText;
	private JLabel lblLogin;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnGo;

	/**
	 * Create the panel.
	 */
	public LoginView() { 

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); // restituisce la dimensione dello schermo come oggetto Dimension
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width; 

		// centra il frame nello schermo
		setSize(screenWidth/3, screenHeight/3);
		setVisible(true);
		setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(139, 175, 206, 39);
		add(passwordField);

		usernameText = new JTextField();
		usernameText.setBounds(139, 110, 206, 39);
		add(usernameText);
		usernameText.setColumns(10);

		lblLogin = new JLabel("Login\n");
		lblLogin.setFont(new Font("Lucida Grande", Font.BOLD, 38));
		lblLogin.setBounds(180, 17, 247, 65);
		add(lblLogin);

		lblUsername = new JLabel("Username\n"); 
		lblUsername.setBounds(46, 121, 88, 16);
		add(lblUsername);

		lblPassword = new JLabel("Password\n");
		lblPassword.setBounds(46, 186, 88, 16);
		add(lblPassword);

		btnGo = new JButton("OK");
		btnGo.setBounds(357, 237, 117, 29);
		add(btnGo);

	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JTextField getUsernameText() {
		return usernameText;
	}

	public void setUsernameText(JTextField usernameText) {
		this.usernameText = usernameText;
	}

	public JLabel getLblLogin() {
		return lblLogin;
	}

	public void setLblLogin(JLabel lblLogin) {
		this.lblLogin = lblLogin;
	}

	public JLabel getLblUsername() {
		return lblUsername;
	}

	public void setLblUsername(JLabel lblUsername) {
		this.lblUsername = lblUsername;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	public JButton getBtnGo() {
		return btnGo;
	}

	public void setBtnGo(JButton btnGo) {
		this.btnGo = btnGo;
	}

}
