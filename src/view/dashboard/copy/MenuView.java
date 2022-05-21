package view.dashboard.copy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import view.clienti.ClientiPanel;
import view.magazzino.farmaci.FarmaciPanel;

public class MenuView extends JPanel {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu mnAnagrafica;
	private JMenuItem mntmClienti;
	private JMenuItem mntmPazienti;
	private JMenuItem mntmFornitori;
	private JMenuItem mntmDipendenti;
	private JMenu mnMagazzino;
	private JMenuItem mntmFarmaci;
	private JMenuItem mntmProdottiutili;
	private JMenuItem mntmProdottiVendita;
	private JMenu mnAppuntamenti;

	public MenuView() {

		setBounds(51, 31, 396, 63);
		setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(51, 31, 396, 63);
		add(menuBar);

		mnAnagrafica = new JMenu("Anagrafica");
		menuBar.add(mnAnagrafica);

		mntmClienti = new JMenuItem("Clienti");

		mnAnagrafica.add(mntmClienti);

		mntmPazienti = new JMenuItem("Pazienti");
		mnAnagrafica.add(mntmPazienti);

		mntmFornitori = new JMenuItem("Fornitori");
		mnAnagrafica.add(mntmFornitori);

		mntmDipendenti = new JMenuItem("Dipendenti");
		mnAnagrafica.add(mntmDipendenti);

		mnMagazzino = new JMenu("Magazzino");
		menuBar.add(mnMagazzino);

		mntmFarmaci = new JMenuItem("Farmaci");
		mntmFarmaci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarmaciPanel nuovoPannello2 = new FarmaciPanel();
				panel.setVisible(false);
				add(nuovoPannello2);
				nuovoPannello2.setVisible(true);
			}
		});
		mnMagazzino.add(mntmFarmaci);

		mntmProdottiutili = new JMenuItem("Prodotti utili");
		mnMagazzino.add(mntmProdottiutili);

		mntmProdottiVendita = new JMenuItem("Prodotti vendita");
		mnMagazzino.add(mntmProdottiVendita);

		mnAppuntamenti = new JMenu("Appuntamenti");
		menuBar.add(mnAppuntamenti);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JMenu getMnAnagrafica() {
		return mnAnagrafica;
	}

	public JMenuItem getMntmClienti() {
		return mntmClienti;
	}

	public JMenuItem getMntmPazienti() {
		return mntmPazienti;
	}

	public JMenuItem getMntmFornitori() {
		return mntmFornitori;
	}

	public JMenuItem getMntmDipendenti() {
		return mntmDipendenti;
	}

	public JMenu getMnMagazzino() {
		return mnMagazzino;
	}

	public JMenuItem getMntmFarmaci() {
		return mntmFarmaci;
	}

	public JMenuItem getMntmProdottiutili() {
		return mntmProdottiutili;
	}

	public JMenuItem getMntmProdottiVendita() {
		return mntmProdottiVendita;
	}

	public JMenu getMnAppuntamenti() {
		return mnAppuntamenti;
	}

}