package view.magazzino.prodottiVendita;

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
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

public class ProdottiVenditaPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTextField tipoText;
	private JTextField nomeText;
	private JDateChooser dataScadenza;
	private JComboBox fornitoriBox;
	private JSpinner spinner;
	private JLabel lblNome;
	private JLabel lblTipo;
	private JLabel lblFornitore;
	private JLabel lblDataScadenza;
	private JLabel lblQt;
	private JButton btnAggiungi;
	private JButton btnElimina;
	private TabellaProdottiVenditaPanel tabellaProdottiVendita;
	private JButton btnModifica;
	private JButton btnAggiorna;
	private JButton btnHome;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame principale1 = new JFrame();
					principale1.setVisible(true);
					principale1.setBounds(500, 500, 2700, 2200);
					principale1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					principale1.getContentPane().setLayout(null);

					ProdottiVenditaPanel frame = new ProdottiVenditaPanel();
					frame.setVisible(true);
					principale1.getContentPane().add(frame);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProdottiVenditaPanel() {

		setBounds(0, 0, 2700, 2200);
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		nomeText = new JTextField();
		nomeText.setBounds(1096, 12, 100, 25);
		add(nomeText);
		nomeText.setColumns(10);

		tipoText = new JTextField();
		tipoText.setColumns(10);
		tipoText.setBounds(1096, 72, 100, 25);
		add(tipoText);

		fornitoriBox = new JComboBox();
		fornitoriBox.setBounds(1096, 205, 100, 17);
		add(fornitoriBox);

		dataScadenza = new JDateChooser();
		dataScadenza.setDateFormatString("MM-dd-yyyy");
		dataScadenza.setBounds(1096, 267, 100, 25);
		add(dataScadenza);

		spinner = new JSpinner();
		spinner.setBounds(1118, 132, 48, 39);
		add(spinner);

		lblNome = new JLabel("nome");
		lblNome.setBounds(970, 12, 108, 15);
		add(lblNome);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(970, 72, 70, 15);
		add(lblTipo);

		lblFornitore = new JLabel("Fornitore");
		lblFornitore.setBounds(964, 205, 70, 15);
		add(lblFornitore);

		lblQt = new JLabel("Qt.");
		lblQt.setBounds(970, 132, 70, 15);
		add(lblQt);

		tabellaProdottiVendita = new TabellaProdottiVenditaPanel(scrollPane);

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
		btnHome.setBounds(1058, 551, 52, 43);
		Icon icon = UIManager.getIcon("FileChooser.homeFolderIcon");
		btnHome.setIcon(icon);
		add(btnHome);
		
		lblNewLabel = new JLabel("Data scadenza");
		lblNewLabel.setBounds(964, 276, 100, 16);
		add(lblNewLabel);

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

	public TabellaProdottiVenditaPanel getTabellaProdottiVenditaPanel() {
		return tabellaProdottiVendita;
	}

	public JButton getBtnModifica() {
		return btnModifica;
	}

	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}

	public JDateChooser getDataScadenza() {
		return dataScadenza;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JLabel getLblDataScadenza() {
		return lblDataScadenza;
	}

}
