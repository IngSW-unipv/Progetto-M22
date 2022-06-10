package view.appuntamenti;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import lu.tudor.santec.jtimechooser.JTimeChooser;

public class AppuntamentiPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private TabellaAppuntamentiPanel tab;
	private JScrollPane scrollPane;
	private JComboBox IDpazText;
	private JComboBox salaText;
	private JTextField tipoText;
	private JDateChooser dataText;
	private JTimeChooser timeChooserText;
	private JComboBox CFvetText;
	private JTextField costoText;
	private JTextField noteText;

	private JLabel IDpazLabel;
	private JLabel salaLabel;
	private JLabel tipoLabel;
	private JLabel dataLabel;
	private JLabel timeChooserLabel;
	private JLabel CF_vetLabel;
	private JLabel costoLabel;
	private JLabel noteLabel;

	private JButton btnModifica;
	private JButton btnAggiungi;
	private JButton btnElimina;
	private JButton btnAggiorna;
	private JButton btnHome;

	public AppuntamentiPanel() {

		setBounds(0, 0, 2700, 2200);
		// setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		IDpazText = new JComboBox();
		IDpazText.setBounds(1096, 12, 100, 25);
		add(IDpazText);

		salaText = new JComboBox();
		salaText.setBounds(1096, 72, 100, 25);
		add(salaText);

		tipoText = new JTextField();
		tipoText.setBounds(1096, 132, 100, 25);
		add(tipoText);

		dataText = new JDateChooser();
		dataText.setDateFormatString("MM-dd-yyyy");
		dataText.setBounds(1096, 192, 100, 25);
		add(dataText);

		timeChooserText = new JTimeChooser();
		timeChooserText.setBounds(1096, 252, 100, 25);
		add(timeChooserText);

		costoText = new JTextField();
		costoText.setBounds(1096, 300, 100, 25);
		add(costoText);

		noteText = new JTextField();
		noteText.setBounds(1096, 353, 100, 25);
		add(noteText);

		IDpazLabel = new JLabel("Paziente");
		IDpazLabel.setBounds(970, 12, 70, 15);
		add(IDpazLabel);

		salaLabel = new JLabel("Sala");
		salaLabel.setBounds(970, 72, 70, 15);
		add(salaLabel);

		tipoLabel = new JLabel("Tipo");
		tipoLabel.setBounds(970, 132, 70, 15);
		add(tipoLabel);

		dataLabel = new JLabel("Data");
		dataLabel.setBounds(970, 192, 70, 15);
		add(dataLabel);

		timeChooserLabel = new JLabel("Ora");
		timeChooserLabel.setBounds(970, 252, 70, 15);
		add(timeChooserLabel);

		costoLabel = new JLabel("Costo");
		costoLabel.setBounds(970, 306, 70, 15);
		add(costoLabel);

		noteLabel = new JLabel("Note");
		noteLabel.setBounds(970, 359, 70, 15);
		add(noteLabel);

		tab = new TabellaAppuntamentiPanel(scrollPane);

		btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(964, 509, 100, 25);
		add(btnAggiungi);

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(1096, 509, 100, 25);
		add(btnElimina);

		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(964, 560, 100, 25);
		add(btnModifica);

		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(1096, 560, 100, 25);
		add(btnAggiorna);

		btnHome = new JButton();
		btnHome.setBounds(1058, 611, 52, 43);
		Icon icon = UIManager.getIcon("FileChooser.homeFolderIcon");
		btnHome.setIcon(icon);
		add(btnHome);

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addComboBoxVets() {

		CFvetText = new JComboBox();
		CFvetText.setBounds(1096, 421, 100, 25);
		add(CFvetText);

		CF_vetLabel = new JLabel("Veterinario");
		CF_vetLabel.setBounds(970, 425, 70, 15);
		add(CF_vetLabel);

	}

	public TabellaAppuntamentiPanel getTab() {
		return tab;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JComboBox getIDpazText() {
		return IDpazText;
	}

	public JComboBox getSalaText() {
		return salaText;
	}

	public JTextField getTipoText() {
		return tipoText;
	}

	public JDateChooser getDataText() {
		return dataText;
	}

	public JTimeChooser getTimeChooserText() {
		return timeChooserText;
	}

	public JComboBox getCFvetText() {
		return CFvetText;
	}

	public JTextField getCostoText() {
		return costoText;
	}

	public JTextField getNoteText() {
		return noteText;
	}

	public JLabel getIDpazLabel() {
		return IDpazLabel;
	}

	public JLabel getSalaLabel() {
		return salaLabel;
	}

	public JLabel getTipoLabel() {
		return tipoLabel;
	}

	public JLabel getDataLabel() {
		return dataLabel;
	}

	public JLabel getTimeChooserLabel() {
		return timeChooserLabel;
	}

	public JLabel getCF_vetLabel() {
		return CF_vetLabel;
	}

	public JLabel getCostoLabel() {
		return costoLabel;
	}

	public JLabel getNoteLabel() {
		return noteLabel;
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

}
