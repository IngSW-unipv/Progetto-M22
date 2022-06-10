package view.dashboard;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuView extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JMenu mnAnagrafica;
	private JMenuItem mntmClienti;
	private JMenu mnPazienti;
	private JMenuItem mntmFornitori;
	private JMenuItem mntmDipendenti;
	private JMenu mnMagazzino;
	private JMenuItem mntmFarmaci;
	private JMenuItem mntmProdottiutili;
	private JMenuItem mntmProdottiVendita;
	private JMenu mnAppuntamenti;
	private JMenuItem menuItemPazienti;
	private JMenuItem menuItemAppuntamenti;

	public MenuView() {

		setBounds(51, 31, 396, 63);

		mnAnagrafica = new JMenu("Anagrafica");
		add(mnAnagrafica);

		mntmClienti = new JMenuItem("Clienti");
		mnAnagrafica.add(mntmClienti);

		mnPazienti = new JMenu("Pazienti");
		add(mnPazienti);

		mntmFornitori = new JMenuItem("Fornitori");
		mnAnagrafica.add(mntmFornitori);

		mntmDipendenti = new JMenuItem("Dipendenti");
		mnAnagrafica.add(mntmDipendenti);

		mnMagazzino = new JMenu("Magazzino");
		add(mnMagazzino);

		mntmFarmaci = new JMenuItem("Farmaci");
		mnMagazzino.add(mntmFarmaci);

		mntmProdottiutili = new JMenuItem("Prodotti utili");
		mnMagazzino.add(mntmProdottiutili);

		mntmProdottiVendita = new JMenuItem("Prodotti vendita");
		mnMagazzino.add(mntmProdottiVendita);

		mnAppuntamenti = new JMenu("Appuntamenti");
		add(mnAppuntamenti);
		
		
		menuItemPazienti = new JMenuItem("Pazienti\n");
		getMnPazienti().add(menuItemPazienti);
		
	    menuItemAppuntamenti = new JMenuItem("Appuntamenti\n");
		getMnAppuntamenti().add(menuItemAppuntamenti);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JMenu getMnAnagrafica() {
		return mnAnagrafica;
	}

	public JMenuItem getMntmClienti() {
		return mntmClienti;
	}

	public JMenu getMnPazienti() {
		return mnPazienti;
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

	public JMenuItem getMenuItemPazienti() {
		return menuItemPazienti;
	}


	public JMenuItem getMenuItemAppuntamenti() {
		return menuItemAppuntamenti;
	}


}