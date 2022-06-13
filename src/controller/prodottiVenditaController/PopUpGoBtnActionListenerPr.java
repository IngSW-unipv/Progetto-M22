package controller.prodottiVenditaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.amministrazione.Entrate;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.prodottiVendita.ProdottiVendita;
import view.MainView;
import view.PopupError;
import view.amministrazione.PopupQuantitàPrezzo;

public class PopUpGoBtnActionListenerPr implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;
	private FatturaProdottiVenditaActionListener fatturaPrActionListener;

	private int qt;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stu

		PopupQuantitàPrezzo popup = fatturaPrActionListener.getPopup();
		double prezzo = .0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date data = new Date();
		java.sql.Date sqlDate = null;

		if (data != null) {

			sdf.format(data);

			sqlDate = new java.sql.Date(data.getTime());
		}

		qt = (int) popup.getQuantitàSpinner().getValue();

		try {

			prezzo = Double.parseDouble(popup.getPrezzotext().getText());
		}

		catch (NumberFormatException e1) {

			PopupError err = new PopupError();
			err.infoBox("il prezzo non è valido", "errore");

		}
		if (qt > fatturaPrActionListener.getQtVecchia()) {

			PopupError err = new PopupError();
			err.infoBox("non ci sono abbastanza prodotti in magazzino", "errore");

		}

		else if (qt != 0) {

			prezzo = qt * prezzo;
			Entrate entrata = new Entrate(0, fatturaPrActionListener.getNome(), prezzo,
					fatturaPrActionListener.getCausa(), sqlDate);

			qt = fatturaPrActionListener.getQtVecchia() - qt;

			dbControl.insertEntrate(entrata);

			model.getEntrateArray().add(entrata);

			DefaultTableModel modello = (DefaultTableModel) view.getEntratePanel().getTab().getTable().getModel();
			Object rowData[] = new Object[4];

			rowData[0] = fatturaPrActionListener.getCausa();
			rowData[1] = fatturaPrActionListener.getNome();
			rowData[2] = prezzo;
			rowData[3] = sqlDate;

			modello.addRow(rowData);

			aggiornaQuantitaProdotto();

			popup.setVisible(false);

		}

		else {

			PopupError err = new PopupError();
			err.infoBox("la quantità non può essere nulla", "errore");
		}

	}

	public void aggiornaQuantitaProdotto() {

		int rigaSelezionata = fatturaPrActionListener.getRigaSelezionata();

		((DefaultTableModel) view.getProdottiVenditaPanel().getTabellaProdottiVenditaPanel().getTable().getModel())
				.removeRow(rigaSelezionata);

		model.getProdottiVenditaArray().remove(rigaSelezionata);

		int COD = fatturaPrActionListener.getCOD();
		String nome = fatturaPrActionListener.getNome();
		String tipo = fatturaPrActionListener.getTipo();
		Fornitori forn = fatturaPrActionListener.getForn();
		java.sql.Date sqlDate = fatturaPrActionListener.getSqlDate();

		ProdottiVendita pr = new ProdottiVendita(COD, nome, tipo, qt, forn, sqlDate);

		dbControl.updateProdottiVendita(pr);

		DefaultTableModel modello = (DefaultTableModel) view.getProdottiVenditaPanel().getTabellaProdottiVenditaPanel()
				.getTable().getModel();
		Object rowData[] = new Object[5];

		rowData[0] = nome;
		rowData[1] = tipo;
		rowData[2] = qt;
		rowData[3] = forn.getPIVA();
		rowData[4] = sqlDate;

		modello.addRow(rowData);
		model.getProdottiVenditaArray().add(pr);

	}

	public PopUpGoBtnActionListenerPr(SmartVetModel model, MainView view, DbControllerSingleton dbControl,
			FatturaProdottiVenditaActionListener fatturaPrActionListener) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
		this.fatturaPrActionListener = fatturaPrActionListener;
	}

}
