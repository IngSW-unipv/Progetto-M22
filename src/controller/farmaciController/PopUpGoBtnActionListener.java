package controller.farmaciController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.amministrazione.Entrate;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.farmaci.LottoFarmaci;
import view.MainView;
import view.PopupError;
import view.amministrazione.PopupQuantitàPrezzo;

public class PopUpGoBtnActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private FatturaFarmaciActionListener fatturaFarmaciActionListener;

	private int qt;

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) { 
		// TODO Auto-generated method stu
		
		PopupQuantitàPrezzo popup = fatturaFarmaciActionListener.getPopup();
		double prezzo = .0;
 
		qt = (int) popup.getQuantitàSpinner().getValue();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date data = new Date();
		java.sql.Date dataCorrente = null;
		
		if (data != null) {

			sdf.format(data);

			 dataCorrente  = new java.sql.Date(data.getTime());
		}
		

		try {

			prezzo = Double.parseDouble(popup.getPrezzotext().getText());
		}

		catch (NumberFormatException e1) {

			PopupError err = new PopupError(); 
			err.infoBox("il prezzo non è valido", "errore");

		}
		if (qt > fatturaFarmaciActionListener.getQtVecchia()) {
			
			PopupError err = new PopupError();
			err.infoBox("non ci sono abbastanza prodotti in magazzino", "errore");
			
		}
		
	
		else if (qt != 0) {

			prezzo = qt * prezzo;
			Entrate entrata = new Entrate(0, fatturaFarmaciActionListener.getTipo(), prezzo,
					fatturaFarmaciActionListener.getCausa(), dataCorrente);

			qt = fatturaFarmaciActionListener.getQtVecchia() - qt ;

			
			dbControl.insertEntrate(entrata);
			
			

			model.getEntrateArray().add(entrata);

			DefaultTableModel modello = (DefaultTableModel) view.getEntratePanel().getTab().getTable().getModel();
			Object rowData[] = new Object[4];

			rowData[0] = fatturaFarmaciActionListener.getCausa();
			rowData[1] = fatturaFarmaciActionListener.getTipo();
			rowData[2] = prezzo;
			rowData[3] = dataCorrente;

			modello.addRow(rowData);

			aggiornaQuantitaFarmaco();

			popup.setVisible(false);

		}
		

		else {

			PopupError err = new PopupError();
			err.infoBox("la quantità non può essere nulla", "errore");
		}

	}

	public void aggiornaQuantitaFarmaco() {

		int rigaSelezionata = fatturaFarmaciActionListener.getRigaSelezionata();

		((DefaultTableModel) view.getFarmaciPanel().getTabellaFarmaci().getTable().getModel())
				.removeRow(rigaSelezionata);

		dbControl.deleteLotto(model.getLottoFarmaciArray().get(rigaSelezionata));

		model.getLottoFarmaciArray().remove(rigaSelezionata);

		DefaultTableModel modello = (DefaultTableModel) view.getFarmaciPanel().getTabellaFarmaci().getTable()
				.getModel();

		String IDLotto = fatturaFarmaciActionListener.getIDLotto();
		String mode = fatturaFarmaciActionListener.getMode();
		String type = fatturaFarmaciActionListener.getTipo();
		Fornitori forn = fatturaFarmaciActionListener.getForn();
		java.sql.Date sqlDate = fatturaFarmaciActionListener.getSqlDate();

		LottoFarmaci lo = new LottoFarmaci(fatturaFarmaciActionListener.getIDLotto(), mode, type, forn, sqlDate, qt);

		boolean flag = dbControl.addLottoFarmaci(lo);

		Object rowData[] = new Object[6];

		if (flag) {

			rowData[0] = IDLotto;
			rowData[1] = mode;
			rowData[2] = type;
			rowData[3] = forn.getPIVA();
			rowData[4] = sqlDate;
			rowData[5] = qt;

			modello.addRow(rowData);
			model.getLottoFarmaciArray().add(lo);
			model.getLottoFarmaciArray().add(lo);
		}

	}

	public PopUpGoBtnActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl,
			FatturaFarmaciActionListener fatturaFarmaciActionListener) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
		this.fatturaFarmaciActionListener = fatturaFarmaciActionListener;
	}
	

}
