package grafica.dashboard;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import grafica.clienti.ClientiView;

import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends JPanel {
	JPanel panel;

	public MenuView(JPanel panel) { 
		this.panel = panel;
		setBounds(51, 31, 396, 63);
		setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(51, 31, 396, 63);
		add(menuBar);

		JMenu mnAnagrafica = new JMenu("Anagrafica");
		menuBar.add(mnAnagrafica);

		JMenuItem mntmClienti = new JMenuItem("Clienti");
		mntmClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ClientiView nuovaFinestra = new ClientiView();
				panel.setVisible(false);
				nuovaFinestra.setVisible(true);

			}
		});
		mnAnagrafica.add(mntmClienti);

		JMenuItem mntmPazienti = new JMenuItem("Pazienti");
		mnAnagrafica.add(mntmPazienti);

		JMenuItem mntmFornitori = new JMenuItem("Fornitori");
		mnAnagrafica.add(mntmFornitori);

		JMenuItem mntmDipendenti = new JMenuItem("Dipendenti");
		mnAnagrafica.add(mntmDipendenti);

		JMenu mnMagazzino = new JMenu("Magazzino");
		menuBar.add(mnMagazzino);

		JMenuItem mntmFarmaci = new JMenuItem("Farmaci");
		mnMagazzino.add(mntmFarmaci);

		JMenuItem mntmProdottiutili = new JMenuItem("Prodotti utili");
		mnMagazzino.add(mntmProdottiutili);

		JMenuItem mntmProdottiVendita = new JMenuItem("Prodotti vendita");
		mnMagazzino.add(mntmProdottiVendita);

		JMenu mnAppuntamenti = new JMenu("Appuntamenti");
		menuBar.add(mnAppuntamenti);
	}
}