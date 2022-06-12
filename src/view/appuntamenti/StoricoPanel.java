package view.appuntamenti;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class StoricoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnHome;

	public StoricoPanel() {

		setBounds(0, 0, 2700, 2200);
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 0, 930, 644);
		add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);

		DefaultTableModel modello1 = new DefaultTableModel(new Object[][] {},
				new String[] { "Paziente", "Sala", "Tipo", "Data", "Ora", "Veterinario", "Costo", "Note" });

		table.setModel(modello1);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(0).setMinWidth(95);

		btnHome = new JButton();
		btnHome.setBounds(1058, 611, 52, 43);
		Icon icon = UIManager.getIcon("FileChooser.homeFolderIcon");
		btnHome.setIcon(icon);
		add(btnHome);

	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public void setBtnHome(JButton btnHome) {
		this.btnHome = btnHome;
	}

}
