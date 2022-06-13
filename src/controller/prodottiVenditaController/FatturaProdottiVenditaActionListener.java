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
import view.amministrazione.PopupQuantitàPrezzo;

public class FatturaProdottiVenditaActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private PopupQuantitàPrezzo popup;

	private int rigaSelezionata;
	private String causa;
	private String nome;
	private String tipo;

	private int COD;
	private java.sql.Date sqlDate;
	private Fornitori forn;
	private int qtVecchia;

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
			}

		}
	}

	public PopupQuantitàPrezzo getPopup() {
		return popup;
	}

	public int getRigaSelezionata() {
		return rigaSelezionata;
	}

	public String getCausa() {
		return causa;
	}

	public String getNome() {
		return nome;
	}

	public int getCOD() {
		return COD;
	}

	public java.sql.Date getSqlDate() {
		return sqlDate;
	}

	public Fornitori getForn() {
		return forn;
	}

	public int getQtVecchia() {
		return qtVecchia;
	}

	public String getTipo() {
		return tipo;
	}

	public FatturaProdottiVenditaActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;

		popup = new PopupQuantitàPrezzo();
	}

}
