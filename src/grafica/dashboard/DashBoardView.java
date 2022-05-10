package grafica.dashboard;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import anagrafica.veterinari.VeterinariDAO;
import grafica.dashboard.farmaciScadenza.FarmaciScadenzaView;
import grafica.dashboard.promemoria.ComboBoxActionListener;
import grafica.dashboard.promemoria.PromemoriaView;

import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenu;

public class DashBoardView extends JPanel {

	// private JFrame frame;
	VeterinariDAO vdao = new VeterinariDAO();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame principale = new JFrame();
					principale.setVisible(true);
					principale.setBounds(500, 500, 2700, 2200);
					principale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					principale.getContentPane().setLayout(null);

					DashBoardView dash = new DashBoardView(); 
					principale.getContentPane().add(dash);
					// dash.setVisible(true);

					MenuView menuView = new MenuView(dash);
					menuView.setBounds(-46, -45, 397, 75);
					dash.add(menuView);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DashBoardView() {
		initialize();
	}

	private void initialize() {

		setBounds(0, 0, 2700, 2200);
		setLayout(null);
		
		// creo un pannello con scrollo per promemoria
		JScrollPane promemoriaScrollPane = new JScrollPane();
		promemoriaScrollPane.setBounds(119, 76, 435, 249);
		add(promemoriaScrollPane);

		// metto nella ComboBox tutti i CF VET
		ArrayList<String> listeCF = vdao.getCFDAO();
		JComboBox comboBox1 = new JComboBox(listeCF.toArray());
		comboBox1.setBounds(934, 25, 192, 17);
		add(comboBox1);

		// scegliendo il CF VET escono i suoi appuntamenti di oggi
		ComboBoxActionListener creaArrayPromemoria = new ComboBoxActionListener(promemoriaScrollPane, comboBox1);
		comboBox1.addActionListener(creaArrayPromemoria);

		// inizializzo il pannello di scrollo promemoria con primo vet ComboBox per
		// estetica
		PromemoriaView promemoria = new PromemoriaView(comboBox1, promemoriaScrollPane);

		// creo un pannello con scrollo per farmaci in scadenza
		JScrollPane farmaciScadenzaScrollPane = new JScrollPane();
		farmaciScadenzaScrollPane.setBounds(684, 83, 412, 254);
		add(farmaciScadenzaScrollPane);
		FarmaciScadenzaView f = new FarmaciScadenzaView(farmaciScadenzaScrollPane);

	}
}
