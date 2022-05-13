package grafica.dashboard;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import grafica.clienti.ClientiPanel;
import grafica.magazzino.Farmaci.FarmaciPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends JPanel {
	private static final long serialVersionUID = 1L;

	JPanel panel;
	JFrame frame;

	public MenuView(JPanel panel, JFrame frame) {

		this.panel = panel;
		this.frame = frame;
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

				ClientiPanel nuovoPannello = new ClientiPanel();
				panel.setVisible(false);
				frame.getContentPane().add(nuovoPannello);
				nuovoPannello.setVisible(true);

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
		mntmFarmaci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarmaciPanel nuovoPannello2 = new FarmaciPanel();
				panel.setVisible(false);
				frame.getContentPane().add(nuovoPannello2);
				nuovoPannello2.setVisible(true);
			}
		});
		mnMagazzino.add(mntmFarmaci);

		JMenuItem mntmProdottiutili = new JMenuItem("Prodotti utili");
		mnMagazzino.add(mntmProdottiutili);

		JMenuItem mntmProdottiVendita = new JMenuItem("Prodotti vendita");
		mnMagazzino.add(mntmProdottiVendita);

		JMenu mnAppuntamenti = new JMenu("Appuntamenti");
		menuBar.add(mnAppuntamenti);
	}
}