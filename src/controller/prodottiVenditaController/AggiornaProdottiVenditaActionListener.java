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
import view.magazzino.prodottiVendita.ProdottiVenditaPanel;

public class AggiornaProdottiVenditaActionListener implements ActionListener {

	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private MainView view;
	private ProdottiVenditaPanel prodottivenditaPanel;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		prodottivenditaPanel = view.getProdottiVenditaPanel(); 

		int elementoSelezionato = prodottivenditaPanel.getTabellaProdottiVenditaPanel().getTable().getSelectedRow();

		int COD = dbControl.selectIDProdottiVendita(elementoSelezionato);

		((DefaultTableModel) prodottivenditaPanel.getTabellaProdottiVenditaPanel().getTable().getModel())
				.removeRow(elementoSelezionato);

		model.getProdottiVenditaArray().remove(elementoSelezionato);

		String nome = prodottivenditaPanel.getNomeText().getText();
		String tipo = prodottivenditaPanel.getTipoText().getText();
		Fornitori forn = costruisciFornitore();
		Date dataScadenza = prodottivenditaPanel.getDataScadenza().getDate();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

		try {
			dataScadenza = sdf.parse(sdf.format(dataScadenza));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		java.sql.Date sqlDate = new java.sql.Date(dataScadenza.getTime());
		
		int qt = (int) prodottivenditaPanel.getSpinner().getValue();
		
		DefaultTableModel modello = (DefaultTableModel) prodottivenditaPanel.getTabellaProdottiVenditaPanel().getTable()
				.getModel();

		ProdottiVendita pu = new ProdottiVendita(COD, nome, tipo, qt, forn, sqlDate);

		dbControl.updateProdottiVendita(pu);

		Object rowData[] = new Object[5];

		rowData[0] = nome;
		rowData[1] = tipo;
		rowData[2] = qt;
		rowData[3] = forn.getPIVA();
		rowData[4] = sqlDate;

		modello.addRow(rowData);
		model.getProdottiVenditaArray().add(pu);

		pulisciTextField();
	}

	public AggiornaProdottiVenditaActionListener(SmartVetModel model, DbControllerSingleton dbControl, MainView view) {

		super();
		this.model = model;
		this.dbControl = dbControl;
		this.view = view;
	}

	public Fornitori costruisciFornitore() {

		String PIVA = (String) prodottivenditaPanel.getFornitoriBox().getSelectedItem();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	public void pulisciTextField() {

		view.getProdottiVenditaPanel().getNomeText().setText(null);
		view.getProdottiVenditaPanel().getTipoText().setText(null);
		view.getProdottiVenditaPanel().getFornitoriBox().setSelectedIndex(0);
		view.getProdottiVenditaPanel().getSpinner().setValue(0);

	}
}
