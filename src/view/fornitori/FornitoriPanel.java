package view.fornitori;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.anagrafica.fornitori.Fornitori;
/** 
 * 
 * @author MMA
 * version 1.0
 *
 */
public class FornitoriPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTextField PIVAText;
	private JTextField nomeAziendaText;
	private JTextField nTelefonoText;
	private JTextField emailText;
	private JTextField sedeText;
	private JTextField IBANText;
	private JLabel lblPIVA;
	private JLabel lblnomeAzienda;
	private JLabel lblnTelefono;
	private JLabel lblEmail;
	private JLabel lblSede;
	private JLabel lblIBAN;
	private TabellaFornitoriPanel tab;
	private JButton btnModifica;
	private JButton btnAggiungi;
	private JButton btnElimina;
	private JButton btnAggiorna;
	private JButton btnHome;

	public FornitoriPanel() {
		

		setBounds(0, 0, 2700, 2200);
		// setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		PIVAText = new JTextField();
		PIVAText.setBounds(1096, 12, 100, 25);
		add(PIVAText);
		PIVAText.setColumns(10);

		nomeAziendaText = new JTextField();
		nomeAziendaText.setColumns(10);
		nomeAziendaText.setBounds(1096, 72, 100, 25);
		add(nomeAziendaText);

		nTelefonoText = new JTextField();
		nTelefonoText.setColumns(10);
		nTelefonoText.setBounds(1096, 132, 100, 25);
		add(nTelefonoText);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(1096, 192, 100, 25);
		add(emailText);

		sedeText = new JTextField();
		sedeText.setColumns(10);
		sedeText.setBounds(1096, 252, 100, 25);
		add(sedeText);

		IBANText = new JTextField();
		IBANText.setColumns(10);
		IBANText.setBounds(1096, 312, 100, 25);
		add(IBANText);
		
		lblPIVA = new JLabel("PIVA");
		lblPIVA.setBounds(970, 12, 70, 15);
		add(lblPIVA);

		lblnomeAzienda = new JLabel("Nome azienda");
		lblnomeAzienda.setBounds(970, 72, 114, 15);
		add(lblnomeAzienda);

		lblnTelefono = new JLabel("Telefono");
		lblnTelefono.setBounds(970, 132, 70, 15);
		add(lblnTelefono);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(970, 192, 70, 15);
		add(lblEmail);

		lblSede = new JLabel("sede");
		lblSede.setBounds(970, 252, 70, 15);
		add(lblSede);

		lblIBAN = new JLabel("IBAN");
		lblIBAN.setBounds(970, 312, 70, 15);
		add(lblIBAN);

		tab = new TabellaFornitoriPanel(scrollPane);

		btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(964, 444, 100, 25);
		add(btnAggiungi);

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(1096, 444, 100, 25);
		add(btnElimina);

		// bottone per modificare quel cliente: riempie le textField con gli attributi
		// di quel cliente
		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(964, 493, 100, 25);
		add(btnModifica);

		// bottone per aggiornare le caratteristiche del cliente selezionato
		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(1096, 493, 100, 25);
		add(btnAggiorna);

		btnHome = new JButton("HOME");
		btnHome.setBounds(1058, 551, 52, 43);
		add(btnHome);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTextField getPIVAText() {
		return PIVAText;
	}

	public JTextField getNomeAziendaText() {
		return nomeAziendaText;
	}

	public JTextField getnTelefonoText() {
		return nTelefonoText;
	}

	public JTextField getEmailText() {
		return emailText;
	}

	public JTextField getSedeText() {
		return sedeText;
	}

	public JTextField getIBANText() {
		return IBANText;
	}

	public JLabel getLblPIVA() {
		return lblPIVA;
	}

	public JLabel getLblnomeAzienda() {
		return lblnomeAzienda;
	}

	public JLabel getLblnTelefono() {
		return lblnTelefono;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public JLabel getLblSede() {
		return lblSede;
	}

	public JLabel getLblIBAN() {
		return lblIBAN;
	}

	public TabellaFornitoriPanel getTab() {
		return tab;
	}

	public JButton getBtnModifica() {
		return btnModifica;
	}

	public JButton getBtnAggiungi() {
		return btnAggiungi;
	}

	public JButton getBtnElimina() {
		return btnElimina;
	}

	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}

	public JButton getBtnHome() {
		return btnHome;
	}
	

	public Fornitori getNuovoFornitoreTextField() {
		Fornitori fo = new Fornitori(PIVAText.getText(), nomeAziendaText.getText(), nTelefonoText.getText(),
				emailText.getText(), sedeText.getText(), IBANText.getText());
		return fo;
	}
}
