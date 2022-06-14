package view.magazzino.farmaci;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

public class FarmaciPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTextField IDLottoText;
	private JTextField modeText;
	private JTextField tipoText;
	private JComboBox fornitoriBox;
	private JDateChooser dataScadenza;
	private JSpinner spinner;
	private JLabel lblIDLotto;
	private JLabel lblMode;
	private JLabel lblTipo;
	private JLabel lblFornitore;
	private JLabel lblDataScadenza;
	private JLabel lblQt;
	private JButton btnAggiungi;
	private JButton btnElimina;
	private TabellaFarmaciPanel tabellaFarmaci;
	private JButton btnModifica;
	private JButton btnAggiorna;
	private JButton btnHome;
	private JButton btnFattura;



	public FarmaciPanel() {

		setBounds(0, 0, 2700, 2200);
		// setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		IDLottoText = new JTextField();
		IDLottoText.setBounds(1096, 12, 100, 25);
		add(IDLottoText);
		IDLottoText.setColumns(10);

		modeText = new JTextField();
		modeText.setBounds(1096, 72, 100, 25);
		add(modeText);
		modeText.setColumns(10);

		tipoText = new JTextField();
		tipoText.setColumns(10);
		tipoText.setBounds(1096, 192, 100, 25);
		add(tipoText);

		fornitoriBox = new JComboBox();
		fornitoriBox.setBounds(1096, 132, 100, 17);
		add(fornitoriBox);

		dataScadenza = new JDateChooser();
		dataScadenza.setDateFormatString("MM-dd-yyyy");
		dataScadenza.setBounds(1096, 252, 100, 25);
		add(dataScadenza);

		SpinnerModel sm = new SpinnerNumberModel(1, 1, 4000, 1);
		spinner = new JSpinner(sm);
		spinner.setBounds(1118, 312, 48, 39);
		add(spinner);

		lblIDLotto = new JLabel("Lotto");
		lblIDLotto.setBounds(970, 12, 70, 15);
		add(lblIDLotto);

		lblMode = new JLabel("Assunzione");
		lblMode.setBounds(970, 72, 108, 15);
		add(lblMode); 

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(970, 132, 70, 15);
		add(lblTipo);
		lblTipo.setBounds(970, 192, 70, 15);

		lblFornitore = new JLabel("Fornitore");
		lblFornitore.setBounds(970, 137, 70, 15);
		add(lblFornitore);

		lblDataScadenza = new JLabel("Data scadenza");
		lblDataScadenza.setBounds(970, 252, 125, 15);
		add(lblDataScadenza);

		lblQt = new JLabel("Qt.");
		lblQt.setBounds(970, 312, 70, 15);
		add(lblQt);

		tabellaFarmaci = new TabellaFarmaciPanel(scrollPane);

		btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(964, 444, 100, 25);
		add(btnAggiungi);

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(1096, 444, 100, 25);
		add(btnElimina);

		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(964, 493, 100, 25);
		add(btnModifica);

		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(1096, 493, 100, 25);
		add(btnAggiorna);

		btnHome = new JButton();
		btnHome.setBounds(1057, 556, 52, 43);
		Icon icon = UIManager.getIcon("FileChooser.homeFolderIcon");
		btnHome.setIcon(icon);
		add(btnHome);

		btnFattura = new JButton("Fattura");
		btnFattura.setBounds(1024, 387, 117, 29);
		add(btnFattura);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTextField getIDLottoText() {
		return IDLottoText;
	}

	public JTextField getModeText() {
		return modeText;
	}

	public JTextField getTipoText() {
		return tipoText;
	}

	public JDateChooser getDataScadenza() {
		return dataScadenza;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public JLabel getLblIDLotto() {
		return lblIDLotto;
	}

	public JLabel getLblMode() {
		return lblMode;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public JLabel getLblFornitore() {
		return lblFornitore;
	}

	public JLabel getLblDataScadenza() {
		return lblDataScadenza;
	}

	public JLabel getLblQt() {
		return lblQt;
	}

	public JComboBox getFornitoriBox() {
		return fornitoriBox;
	}

	public JButton getBtnAggiungi() {
		return btnAggiungi;
	}

	public JButton getBtnElimina() { 
		return btnElimina;
	}

	public TabellaFarmaciPanel getTabellaFarmaci() {
		return tabellaFarmaci;
	}

	public JButton getBtnModifica() {
		return btnModifica;
	}

	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnFattura() {
		return btnFattura;
	}

}
