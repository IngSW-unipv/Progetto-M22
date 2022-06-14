package view.magazzino.prodottiUtili;

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

public class ProdottiUtiliPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTextField nomeText;
	private JTextField tipoText;
	private JComboBox fornitoriBox;
	private JSpinner spinner; 
	private JLabel lblNome;
	private JLabel lblTipo;
	private JLabel lblFornitore;
	private JLabel lblQt;
	private JButton btnAggiungi;
	private JButton btnElimina;
	private TabellaProdottiUtiliPanel tabellaProdottiUtili;
	private JButton btnModifica;
	private JButton btnAggiorna;
	private JButton btnHome;


	public ProdottiUtiliPanel() {

		setBounds(0, 0, 2700, 2200);
		// setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		nomeText = new JTextField();
		nomeText.setBounds(1096, 72, 100, 25);
		add(nomeText);
		nomeText.setColumns(10);

		tipoText = new JTextField();
		tipoText.setColumns(10);
		tipoText.setBounds(1096, 192, 100, 25);
		add(tipoText);

		fornitoriBox = new JComboBox();
		fornitoriBox.setBounds(1096, 132, 100, 17);
		add(fornitoriBox);
		
		SpinnerModel sm = new SpinnerNumberModel(1, 1, 4000, 1);
		spinner = new JSpinner(sm);
		spinner.setBounds(1118, 312, 48, 39);
		add(spinner);

		lblNome = new JLabel("nome");
		lblNome.setBounds(970, 72, 108, 15);
		add(lblNome);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(970, 132, 70, 15);
		add(lblTipo);
		lblTipo.setBounds(970, 192, 70, 15);

		lblFornitore = new JLabel("Fornitore");
		lblFornitore.setBounds(970, 137, 70, 15);
		add(lblFornitore);

		lblQt = new JLabel("Qt.");
		lblQt.setBounds(970, 312, 70, 15);
		add(lblQt);

		tabellaProdottiUtili = new TabellaProdottiUtiliPanel(scrollPane);

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
		btnHome.setBounds(1058, 590, 52, 43);
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

	public JTextField getTipoText() {
		return tipoText;
	}

	public JComboBox getFornitoriBox() {
		return fornitoriBox;
	}

	public JSpinner getSpinner() {
		return spinner;
	}


	public JLabel getLblNome() {
		return lblNome;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public JLabel getLblFornitore() {
		return lblFornitore;
	}

	public JLabel getLblQt() {
		return lblQt;
	}

	public JButton getBtnAggiungi() {
		return btnAggiungi;
	}

	public JButton getBtnElimina() {
		return btnElimina;
	}

	public TabellaProdottiUtiliPanel getTabellaProdottiUtili() {
		return tabellaProdottiUtili;
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
	
	
}
