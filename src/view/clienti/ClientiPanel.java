package view.clienti;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import model.anagrafica.clienti.Clienti;

public class ClientiPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JComboBox clientiBox;
	private JTextField nomeText;
	private JTextField cognomeText;
	private JTextField emailText;
	private JTextField CFText;
	private JTextField cellulareText;
	private JTextField cittaText;
	private JTextField indirizzoText;
	private JLabel lblNome;
	private JLabel lblCognome;
	private JLabel lblCF;
	private JLabel lblCitta;
	private JLabel lblIndirizzo;
	private JLabel lblEmail;
	private JLabel lblCellulare;
	private TabellaClientiPanel tab;
	private JButton btnModifica;
	private JButton btnAggiungi;
	private JButton btnElimina;
	private JButton btnAggiorna;
	private JButton btnHome;

	public ClientiPanel() { 

		setBounds(0, 0, 2700, 2200);
		// setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		nomeText = new JTextField();
		nomeText.setBounds(1096, 12, 100, 25);
		add(nomeText);
		nomeText.setColumns(10);

		cognomeText = new JTextField();
		cognomeText.setColumns(10);
		cognomeText.setBounds(1096, 72, 100, 25);
		add(cognomeText);

		CFText = new JTextField();
		CFText.setColumns(10);
		CFText.setBounds(1096, 132, 100, 25);
		add(CFText);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(1096, 192, 100, 25);
		add(emailText);

		cellulareText = new JTextField();
		cellulareText.setColumns(10);
		cellulareText.setBounds(1096, 252, 100, 25);
		add(cellulareText);

		cittaText = new JTextField();
		cittaText.setColumns(10);
		cittaText.setBounds(1096, 312, 100, 25);
		add(cittaText);

		indirizzoText = new JTextField();
		indirizzoText.setColumns(10);
		indirizzoText.setBounds(1096, 372, 100, 25);
		add(indirizzoText);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(970, 12, 70, 15);
		add(lblNome);

		lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(970, 72, 70, 15);
		add(lblCognome);

		lblCF = new JLabel("CF");
		lblCF.setBounds(970, 132, 70, 15);
		add(lblCF);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(970, 192, 70, 15);
		add(lblEmail);

		lblCellulare = new JLabel("Cellulare");
		lblCellulare.setBounds(970, 252, 70, 15);
		add(lblCellulare);

		lblCitta = new JLabel("Città");
		lblCitta.setBounds(970, 312, 70, 15);
		add(lblCitta);

		lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setBounds(970, 372, 70, 15);
		add(lblIndirizzo);

		tab = new TabellaClientiPanel(scrollPane);

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

		btnHome = new JButton();
		btnHome.setBounds(1058, 551, 52, 43);
		Icon icon = UIManager.getIcon("FileChooser.homeFolderIcon");
		btnHome.setIcon(icon);
		add(btnHome);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTextField getNomeText() {
		return nomeText;
	}

	public JTextField getCognomeText() {
		return cognomeText;
	}

	public JTextField getEmailText() {
		return emailText;
	}

	public JTextField getCFText() {
		return CFText;
	}

	public JTextField getCellulareText() {
		return cellulareText;
	}

	public JTextField getCittaText() {
		return cittaText;
	}

	public JTextField getIndirizzoText() {
		return indirizzoText;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public JLabel getLblCognome() {
		return lblCognome;
	}

	public JLabel getLblCF() {
		return lblCF;
	}

	public JLabel getLblCitta() {
		return lblCitta;
	}

	public JLabel getLblIndirizzo() {
		return lblIndirizzo;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public JLabel getLblCellulare() {
		return lblCellulare;
	}

	public TabellaClientiPanel getTab() {
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

	// attenzione all'ordine!!
	public Clienti getNuovoClienteTextField() {
		Clienti cl = new Clienti(nomeText.getText(), cognomeText.getText(), CFText.getText(), emailText.getText(),
				cellulareText.getText(), cittaText.getText(), indirizzoText.getText());
		return cl;
	}

	public JComboBox getClientiBox() {
		return clientiBox;
	}
}
