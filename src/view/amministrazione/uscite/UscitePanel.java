package view.amministrazione.uscite;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class UscitePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTextField tipoText;
	private JTextField causaText;
	private JTextField prezzoText;
	private JLabel lblCausa;
	private JLabel lblTipo;
	private JLabel lblPrezzo;
	private JButton btnAggiungi;
	private JButton btnElimina;
	private TabellaUscitePanel tab;
	private JButton btnHome;

	public UscitePanel() {

		setBounds(0, 0, 2700, 2200);
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		causaText = new JTextField();
		causaText.setBounds(1096, 12, 100, 25);
		add(causaText);
		causaText.setColumns(10);

		tipoText = new JTextField();
		tipoText.setColumns(10);
		tipoText.setBounds(1096, 72, 100, 25);
		add(tipoText);

		prezzoText = new JTextField();
		prezzoText.setColumns(10);
		prezzoText.setBounds(1096, 132, 100, 25);
		add(prezzoText);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(970, 72, 70, 15);
		add(lblTipo);

		lblCausa = new JLabel("Causa");
		lblCausa.setBounds(970, 12, 70, 15);
		add(lblCausa);

		lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setBounds(970, 132, 70, 15);
		add(lblPrezzo);

		btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(964, 444, 100, 25);
		add(btnAggiungi);

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(1096, 444, 100, 25);
		add(btnElimina);

		btnHome = new JButton();
		btnHome.setBounds(1058, 551, 52, 43);
		Icon icon = UIManager.getIcon("FileChooser.homeFolderIcon");
		btnHome.setIcon(icon);
		add(btnHome);

		tab = new TabellaUscitePanel(scrollPane);

	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTextField getTipoText() {
		return tipoText;
	}

	public JTextField getCausaText() {
		return causaText;
	}

	public JTextField getPrezzoText() {
		return prezzoText;
	}

	public JLabel getLblCausa() {
		return lblCausa;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public JLabel getLblPrezzo() {
		return lblPrezzo;
	}

	public JButton getBtnAggiungi() {
		return btnAggiungi;
	}

	public JButton getBtnElimina() {
		return btnElimina;
	}

	public TabellaUscitePanel getTab() {
		return tab;
	}

	public JButton getBtnHome() {
		return btnHome;
	}
}
