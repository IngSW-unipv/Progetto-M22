package controller.farmaciController;

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
 * Fattura farmaco selezionato
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class FatturaFarmaciActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private PopupQuantitaPrezzo popup;

	private String causa;
	private String tipo;
	private int qtVecchia;
	private String IDLotto;
	private String mode;
	private Fornitori forn;
	private java.sql.Date sqlDate;
	private int rigaSelezionata;

	private java.sql.Date date;

	/**
	 * inserisce lotto selezionato nelle entrate con prezzo, causa e data al momento
	 * dell fatturazione
	 * 
	 * @param e evento schiaccia bottone fattura
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		rigaSelezionata = view.getFarmaciPanel().getTabellaFarmaci().getTable().getSelectedRow();

		causa = "Farmaci";
		tipo = model.getLottoFarmaciArray().get(rigaSelezionata).getType();

		memorizzaFarmaco();

		popup.setVisible(true);

	}

	/**
	 * costruttore fa uscire popup per selezionare prezzo e quantità del farmaco
	 * venduto
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */

	public FatturaFarmaciActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;

		popup = new PopupQuantitaPrezzo();
	}

	/**
	 * memorizzo il farmaco selezionato che ho deciso di fatturare per così poi
	 * aggiornare la sua quantità in base a quanta ne ho tolta vendendolo
	 * (fatturandolo)
	 * 
	 * @exception parseexception data non valida
	 * @param e evento schiaccia bottone fattura
	 * @return void
	 */
	public void memorizzaFarmaco() {

		if (rigaSelezionata >= 0) {

			IDLotto = model.getLottoFarmaciArray().get(rigaSelezionata).getIDLotto();
			mode = model.getLottoFarmaciArray().get(rigaSelezionata).getMode();
			tipo = model.getLottoFarmaciArray().get(rigaSelezionata).getType();
			String PIVA = null;
			qtVecchia = model.getLottoFarmaciArray().get(rigaSelezionata).getQuantita();

			if (model.getLottoFarmaciArray().get(rigaSelezionata).getFornitore() != null)
				PIVA = model.getLottoFarmaciArray().get(rigaSelezionata).getFornitore().getPIVA();

			forn = dbControl.selectFornitoreFromPiva(PIVA);

			Date dataScadenza = null;
			sqlDate = null;

			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

			try {

				dataScadenza = model.getLottoFarmaciArray().get(rigaSelezionata).getDataScadenza();

				if (dataScadenza != null) {

					dataScadenza = sdf.parse(sdf.format(dataScadenza));

					sqlDate = new java.sql.Date(dataScadenza.getTime());
				}
			}

			catch (ParseException e1) {
				// TODO Auto-generated catch block
				PopupError err = new PopupError();
				err.infoBox("Data non valida", "Errore");
				e1.printStackTrace();
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
	 * restituisce causa fattura (farmaco)
	 * 
	 * @return String causa fattura
	 */
	public String getCausa() {
		return causa;
	}

	/**
	 * restituisce tipo farmaco
	 * 
	 * @return String tipo farmaco
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * restituisce quantità vecchia farmaco
	 * 
	 * @return int quantità vecchia
	 */
	public int getQtVecchia() {
		return qtVecchia;
	}

	/**
	 * restituisce ID lotto (farmaco)
	 * 
	 * @return String ID
	 */
	public String getIDLotto() {
		return IDLotto;
	}

	/**
	 * restituisce modalità somministrazione farmaco
	 * 
	 * @return String modalità somministrazione farmaco
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * restituisce fornitorefarmaco
	 * 
	 * @return Fornitore fornitore del farmaco
	 */
	public Fornitori getForn() {
		return forn;
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
	 * restituisce riga selezionata farmaco fatturare
	 * 
	 * @return int riga selezionata tabella farmaco
	 */
	public int getRigaSelezionata() {
		return rigaSelezionata;
	}

	/**
	 * restituisce data scadenza farmaco
	 * 
	 * @return date data scadenza farmaco
	 */
	public Date getDate() {
		return date;
	}

}
