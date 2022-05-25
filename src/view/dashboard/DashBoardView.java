package view.dashboard;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.dashboard.farmaciScadenza.TabellaFarmaciScadenzaView;

public class DashBoardView extends JPanel {

	private MenuView menu;
	private JScrollPane promemoriaScrollPane;
	private JComboBox comboBox1;
	private JScrollPane farmaciScadenzaScrollPane;
	private TabellaFarmaciScadenzaView f;

	public DashBoardView() {

		super();
		setVisible(true);
		setBounds(0, 0, 2700, 2200);
		setLayout(null);

		menu = new MenuView();
		menu.setBounds(-46, -45, 397, 75);
		add(menu);

		// creo un pannello con scrollo per promemoria
		promemoriaScrollPane = new JScrollPane();
		promemoriaScrollPane.setBounds(119, 76, 435, 249);
		add(promemoriaScrollPane);

		comboBox1 = new JComboBox();
		comboBox1.setBounds(934, 25, 192, 17);
		add(comboBox1);

		// creo un pannello con scrollo per farmaci in scadenza
		farmaciScadenzaScrollPane = new JScrollPane();
		farmaciScadenzaScrollPane.setBounds(684, 83, 412, 254);
		add(farmaciScadenzaScrollPane);
		f = new TabellaFarmaciScadenzaView(farmaciScadenzaScrollPane);
	}

	public MenuView getMenu() {
		return menu;
	}

	public JScrollPane getPromemoriaScrollPane() {
		return promemoriaScrollPane;
	}

	public JComboBox getComboBox1() {
		return comboBox1;
	}

	public JScrollPane getFarmaciScadenzaScrollPane() {
		return farmaciScadenzaScrollPane;
	}

	public TabellaFarmaciScadenzaView getTabellaFarmaciView() {
		return f;
	}

}
