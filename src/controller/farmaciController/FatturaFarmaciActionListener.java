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
import view.amministrazione.PopupQuantitàPrezzo;

public class FatturaFarmaciActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private PopupQuantitàPrezzo popup;

	private String causa;
	private String tipo;
	private int qtVecchia;
	private String IDLotto;
	private String mode;
	private Fornitori forn;
	private java.sql.Date sqlDate;
	private int rigaSelezionata;
	
	private java.sql.Date date;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		rigaSelezionata = view.getFarmaciPanel().getTabellaFarmaci().getTable().getSelectedRow();

		causa = "Farmaci";
		tipo = model.getLottoFarmaciArray().get(rigaSelezionata).getType();

		memorizzaFarmaco();

		popup.setVisible(true);

	}

	public FatturaFarmaciActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;

		popup = new PopupQuantitàPrezzo();
	}

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
				e1.printStackTrace();
			}

		}
	}

	public PopupQuantitàPrezzo getPopup() {
		return popup;
	}

	public SmartVetModel getModel() {
		return model;
	}

	public MainView getView() {
		return view;
	}

	public DbControllerSingleton getDbControl() {
		return dbControl;
	}

	public String getCausa() {
		return causa;
	}

	public String getTipo() {
		return tipo;
	}

	public int getQtVecchia() {
		return qtVecchia;
	}

	public String getIDLotto() {
		return IDLotto;
	}

	public String getMode() {
		return mode;
	}

	public Fornitori getForn() {
		return forn;
	}

	public java.sql.Date getSqlDate() {
		return sqlDate;
	}

	public int getRigaSelezionata() {
		return rigaSelezionata;
	}

	public Date getDate() {
		return date;
	}

}
