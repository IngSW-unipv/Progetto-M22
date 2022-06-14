package view.dashboard;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/** 
 * 
 * @author MMA
 * version 1.0
 *
 */
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
	private JMenuItem menuItemStorico;
	private JMenuItem mntmSaleOccupate;
	private JMenu mnAccount;
	private JMenuItem mntmEsciAccount;
	private JMenu mnAmministrazione;
	private JMenuItem mntmEntrate;
	private JMenuItem mntmUscite;

	public MenuView() {

		setBounds(24, 24, 600, 31);

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

		menuItemStorico = new JMenuItem("Storico");
		mnAppuntamenti.add(menuItemStorico);

		mntmSaleOccupate = new JMenuItem("Occupazione sale");
		mnAppuntamenti.add(mntmSaleOccupate);

		mnAccount = new JMenu("Account");
		add(mnAccount);

		mntmEsciAccount = new JMenuItem("Esci");
		mnAccount.add(mntmEsciAccount);

		mnAmministrazione = new JMenu("Amministrazione");
		add(mnAmministrazione);

		mntmEntrate = new JMenuItem("Entrate");
		mnAmministrazione.add(mntmEntrate);

		mntmUscite = new JMenuItem("Uscite");
		mnAmministrazione.add(mntmUscite);

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

	public JMenuItem getMenuItemStorico() {
		return menuItemStorico;
	}

	public JMenuItem getMntmSaleOccupate() {
		return mntmSaleOccupate;
	}

	public JMenuItem getMntmEsciAccount() {
		return mntmEsciAccount;
	}

	public JMenuItem getMntmEntrate() {
		return mntmEntrate;
	} 

	public JMenuItem getMntmUscite() {
		return mntmUscite;
	}

}