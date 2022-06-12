package controller.prodottiVenditaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.prodottiVendita.ProdottiVendita;
import view.MainView;
import view.PopupError;

public class AggiungiProdottiVenditaActionListener implements ActionListener {
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String nome = view.getProdottiVenditaPanel().getNomeText().getText();
		String tipo = view.getProdottiVenditaPanel().getTipoText().getText();
		Fornitori forn = costruisciFornitore();
		Date dataScadenza = view.getProdottiVenditaPanel().getDataScadenza().getDate();

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		try {

			dataScadenza = sdf.parse(sdf.format(dataScadenza));
			System.out.println(dataScadenza);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		java.sql.Date sqlDate = new java.sql.Date(dataScadenza.getTime());
		//

		int qt = (int) view.getProdottiVenditaPanel().getSpinner().getValue();

		ProdottiVendita nuovoPr = new ProdottiVendita(0, nome, tipo, qt, forn, sqlDate);

		boolean flag = dbControl.addProdottiVendita(nuovoPr);

		if (flag) {

			model.getProdottiVenditaArray().add(nuovoPr);

			Object rowData[] = new Object[5];

			DefaultTableModel model = (DefaultTableModel) view.getProdottiVenditaPanel()
					.getTabellaProdottiVenditaPanel().getTable().getModel();

			rowData[0] = nome;
			rowData[1] = tipo;
			rowData[2] = qt;
			rowData[3] = forn.getPIVA();
			rowData[4] = sqlDate;

			model.addRow(rowData);

			pulisciTextField();

		} else {

			{
				PopupError err = new PopupError();
				err.infoBox("Esiste gi� un prodotto con questo codice", "Impossibile inserire prodotto");
				pulisciTextField();

			}

		}

	}

	public void pulisciTextField() {

		view.getProdottiVenditaPanel().getNomeText().setText(null);
		view.getProdottiVenditaPanel().getTipoText().setText(null);
		view.getProdottiVenditaPanel().getFornitoriBox().setSelectedIndex(0);
		view.getProdottiVenditaPanel().getSpinner().setValue(0);

	}

	public Fornitori costruisciFornitore() {
		String PIVA = view.getProdottiVenditaPanel().getFornitoriBox().getSelectedItem().toString();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	public AggiungiProdottiVenditaActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}
}
