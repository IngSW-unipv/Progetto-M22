package controller.prodottiVenditaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.fornitori.Fornitori;
import view.MainView;
import view.PopupError;
import view.amministrazione.PopupQuantitaPrezzo;

/**
 * Fattura prodotto vendita selezionato
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class FatturaProdottiVenditaActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private PopupQuantitaPrezzo popup;

	private int rigaSelezionata;
	private String causa;
	private String nome;
	private String tipo;

	private int COD;
	private java.sql.Date sqlDate;
	private Fornitori forn;
	private int qtVecchia;

	/**
	 * inserisce prodotto vendita selezionato nelle entrate con prezzo, causa e data
	 * al momento dell fatturazione
	 * 
	 * @param e evento schiaccia bottone fattura
	 * @exception Parseexception data non valida
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub

		rigaSelezionata = view.getProdottiVenditaPanel().getTabellaProdottiVenditaPanel().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			causa = "Prodotto";
			nome = model.getProdottiVenditaArray().get(rigaSelezionata).getType();

			memorizzaProdotti();

			popup.setVisible(true);
		}
	}

	/**
	 * memorizzo il prodotto selezionato che ho deciso di fatturare per così poi
	 * aggiornare la sua quantità in base a quanta ne ho tolta vendendolo
	 * (fatturandolo)
	 * 
	 * @exception parseexception data non valida
	 * @param e evento schiaccia bottone fattura
	 * @return void
	 */
	public void memorizzaProdotti() {

		if (rigaSelezionata >= 0) {

			COD = model.getProdottiVenditaArray().get(rigaSelezionata).getCOD();
			nome = model.getProdottiVenditaArray().get(rigaSelezionata).getNome();
			tipo = model.getProdottiVenditaArray().get(rigaSelezionata).getType();

			String PIVA = null;

			qtVecchia = model.getProdottiVenditaArray().get(rigaSelezionata).getQuantita();

			if (model.getProdottiVenditaArray().get(rigaSelezionata).getFornitore() != null)
				PIVA = model.getProdottiVenditaArray().get(rigaSelezionata).getFornitore().getPIVA();

			forn = dbControl.selectFornitoreFromPiva(PIVA);

			Date dataScadenza = null;
			sqlDate = null;

			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

			try {

				dataScadenza = model.getProdottiVenditaArray().get(rigaSelezionata).getDataScadenza();

				if (dataScadenza != null) {

					dataScadenza = sdf.parse(sdf.format(dataScadenza));

					sqlDate = new java.sql.Date(dataScadenza.getTime());
				}
			}

			catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				PopupError err = new PopupError();
				err.infoBox("data non valida", "Errore");
			}

		}
	}

	/**
	 * restituisce popup generato
	 * 
	 * @return PopupQuantitàprezzo
	 */
	public PopupQuantitaPrezzo getPopup() {
		return popup;
	}

	/**
	 * restituisce riga tabella prodotti selezionata
	 * 
	 * @return int numero riga selezionata
	 */
	public int getRigaSelezionata() {
		return rigaSelezionata;
	}

	/**
	 * restituisce causa fattura (prodotto)
	 * 
	 * @return String causa
	 */
	public String getCausa() {
		return causa;
	}

	/**
	 * restituisce nome prodotto fattura
	 * 
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * restituisce ID prodotto
	 * 
	 * @return int cod prodotto
	 */
	public int getCOD() {
		return COD;
	}

	/**
	 * restituisce data fattura
	 * 
	 * @return Date data fattura
	 */
	public java.sql.Date getSqlDate() {
		return sqlDate;
	}

	/**
	 * restituisce fornitore prodotto
	 * 
	 * @return Fornitore fornitore prodotto
	 */
	public Fornitori getForn() {
		return forn;
	}

	/**
	 * restituisce fquantità vecchia prodotto
	 * 
	 * @return int quantità vecchia prodotto
	 */
	public int getQtVecchia() {
		return qtVecchia;
	}

	/**
	 * restituisce tipoprodotto
	 * 
	 * @return String tipo prodotto
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * costruttore fa uscire popup per selezionare prezzo e quantità del prodotto
	 * venduto
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public FatturaProdottiVenditaActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;

		popup = new PopupQuantitaPrezzo();
	}

}
