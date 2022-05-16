package view;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.appuntamenti.Appuntamenti;
import view.dashboard.MenuView;
import view.dashboard.promemoria.PromemoriaView;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	MenuView menu;
	JScrollPane promemoriaScrollPane;
	JComboBox comboBox1;
	JScrollPane farmaciScadenzaScrollPane;

	public MainView() {

		setVisible(true);
		setBounds(500, 500, 2700, 2200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		menu = new MenuView((JPanel) getContentPane());
		menu.setBounds(-46, -45, 397, 75);
		getContentPane().add(menu);

		// creo un pannello con scrollo per promemoria
		promemoriaScrollPane = new JScrollPane();
		promemoriaScrollPane.setBounds(119, 76, 435, 249);
		add(promemoriaScrollPane);

		// metto nella ComboBox tutti i CF VET
		// ArrayList<String> listeCF = vdao.getCFDAO();

		comboBox1 = new JComboBox();
		comboBox1.setBounds(934, 25, 192, 17);
		add(comboBox1); 

		// scegliendo il CF VET escono i suoi appuntamenti di oggi
		// ComboBoxActionListener creaArrayPromemoria = new
		// ComboBoxActionListener(promemoriaScrollPane, comboBox1);
		// comboBox1.addActionListener(creaArrayPromemoria);

		// inizializzo il pannello di scrollo promemoria con primo vet ComboBox per
		// estetica
		//PromemoriaView promemoria = new PromemoriaView(comboBox1, promemoriaScrollPane);

		// creo un pannello con scrollo per farmaci in scadenza
		farmaciScadenzaScrollPane = new JScrollPane();
		farmaciScadenzaScrollPane.setBounds(684, 83, 412, 254);
		add(farmaciScadenzaScrollPane);
		// FarmaciScadenzaView f = new FarmaciScadenzaView(farmaciScadenzaScrollPane);
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

}
