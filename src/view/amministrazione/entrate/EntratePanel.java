package view.amministrazione.entrate;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 
 * @author MMA version 1.0
 *
 */
public class EntratePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JButton btnElimina;
	private TabellaEntratePanel tab;
	private JButton btnHome;

	public EntratePanel() {

		setBounds(0, 0, 2700, 2200);
		// setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(1061, 442, 100, 25);
		add(btnElimina);

		tab = new TabellaEntratePanel(scrollPane);

		btnHome = new JButton("HOME");
		btnHome.setBounds(1085, 528, 52, 43);
		add(btnHome);
	}

	public TabellaEntratePanel getTab() {
		return tab;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public JButton getBtnElimina() {
		return btnElimina;
	}

}
