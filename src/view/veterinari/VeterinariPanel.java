package view.veterinari;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import model.anagrafica.veterinari.Veterinari;

public class VeterinariPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	
	private JTextField nomeText;
	private JTextField cognomeText;
	private JTextField emailText;
	private JTextField CFText;
	private JTextField cellulareText;
	private JTextField cittaText;
	private JTextField indirizzoText;
	private JTextField pivaText;
	private JTextField contrattoText;
	private JTextField stipendioText;
	private JTextField commissioniText;
	private JTextField ibanText;
	
	private JLabel lblNome;
	private JLabel lblCognome;
	private JLabel lblCF;
	private JLabel lblCitta;
	private JLabel lblIndirizzo;
	private JLabel lblEmail;
	private JLabel lblCellulare;
	private JLabel lblPiva;
	private JLabel lblContratto;
	private JLabel lblStipendio;
	private JLabel lblCommissioni;
	private JLabel lblIban;
	
	private TabellaVeterinariPanel tab;
	private JButton btnModifica;
	private JButton btnAggiungi;
	private JButton btnElimina;
	private JButton btnAggiorna;
	private JButton btnHome;

	public VeterinariPanel() {

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
		
		pivaText = new JTextField();
		pivaText.setColumns(10);
		pivaText.setBounds(1096, 132, 100, 25);
		add(pivaText);

		contrattoText = new JTextField();
		contrattoText.setColumns(10);
		contrattoText.setBounds(1096, 192, 100, 25);
		add(contrattoText);

		stipendioText = new JTextField();
		stipendioText.setColumns(10);
		stipendioText.setBounds(1096, 252, 100, 25);
		add(stipendioText);

		commissioniText = new JTextField();
		commissioniText.setColumns(10);
		commissioniText.setBounds(1096, 312, 100, 25);
		add(commissioniText);

		ibanText = new JTextField();
		ibanText.setColumns(10);
		ibanText.setBounds(1096, 372, 100, 25);
		add(ibanText);

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
		
		lblPiva = new JLabel("Piva");
		lblPiva.setBounds(970, 132, 70, 15);
		add(lblPiva);

		lblContratto = new JLabel("Contratto");
		lblContratto.setBounds(970, 192, 70, 15);
		add(lblContratto);

		lblStipendio = new JLabel("Stipendio");
		lblStipendio.setBounds(970, 252, 70, 15);
		add(lblStipendio);

		lblCommissioni = new JLabel("Commissioni");
		lblCommissioni.setBounds(970, 312, 70, 15);
		add(lblCommissioni);

		lblIban = new JLabel("Iban");
		lblIban.setBounds(970, 372, 70, 15);
		add(lblIban);

		tab = new TabellaVeterinariPanel(scrollPane);

		btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(964, 444, 100, 25);
		add(btnAggiungi);

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(1096, 444, 100, 25);
		add(btnElimina);

		// bottone per modificare quel vet: riempie le textField con gli attributi
		// di quel vet
		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(964, 493, 100, 25);
		add(btnModifica);

		// bottone per aggiornare le caratteristiche del vet selezionato
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
	
	public JTextField getPivaText() {
		return pivaText;
	}
	
	public JTextField getContrattoText() {
		return contrattoText;
	}
	
	public JTextField getStipendioText() {
		return stipendioText;
	}
	
	public JTextField getCommissioniText() {
		return commissioniText;
	}
	
	public JTextField getIbanText() {
		return ibanText;
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
	
	public JLabel getLblPiva() {
		return lblPiva;
	}

	public JLabel getLblContratto() {
		return lblContratto;
	}
	
	public JLabel getLblStipendio() {
		return lblStipendio;
	}

	public JLabel getLblCommissioni() {
		return lblCommissioni;
	}
	
	public JLabel getLblIban() {
		return lblIban;
	}

	public TabellaVeterinariPanel getTab() {
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

	public Veterinari getNuovoVeterinarioTextField() {
		Veterinari vet = new Veterinari(nomeText.getText(), cognomeText.getText(), CFText.getText(), cellulareText.getText(),
				cittaText.getText(), indirizzoText.getText(), emailText.getText(), pivaText.getText(), contrattoText.getText(),
				stipendioText.getText(), commissioniText.getText(), ibanText.getText());
		return vet;
	}
}
