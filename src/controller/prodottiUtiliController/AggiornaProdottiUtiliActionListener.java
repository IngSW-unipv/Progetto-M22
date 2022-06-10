package controller.prodottiUtiliController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.prodottiUtili.ProdottiUtili;
import view.MainView;
import view.magazzino.prodottiUtili.ProdottiUtiliPanel;

public class AggiornaProdottiUtiliActionListener implements ActionListener {

	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private MainView view;
	private ProdottiUtiliPanel prodottiutiliPanel;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		prodottiutiliPanel = view.getProdottiUtiliPanel();

		int elementoSelezionato = prodottiutiliPanel.getTabellaProdottiUtili().getTable().getSelectedRow();

		int COD = dbControl.selectCODProdottiUtili(elementoSelezionato);

		((DefaultTableModel) prodottiutiliPanel.getTabellaProdottiUtili().getTable().getModel())
				.removeRow(elementoSelezionato);

		model.getProdottiUtiliArray().remove(elementoSelezionato);

		String nome = prodottiutiliPanel.getNomeText().getText();
		String tipo = prodottiutiliPanel.getTipoText().getText();
		Fornitori forn = costruisciFornitore();
		int qt = (int) prodottiutiliPanel.getSpinner().getValue();

		DefaultTableModel modello = (DefaultTableModel) prodottiutiliPanel.getTabellaProdottiUtili().getTable()
				.getModel();

		ProdottiUtili pu = new ProdottiUtili(nome, tipo, qt, forn);

		dbControl.updateProdottiUtili(pu, COD);

		Object rowData[] = new Object[4];

		rowData[0] = nome;
		rowData[1] = tipo;
		rowData[2] = qt;
		rowData[3] = forn.getPIVA();

		modello.addRow(rowData);

		pulisciTextField();
	}

	public AggiornaProdottiUtiliActionListener(SmartVetModel model, DbControllerSingleton dbControl, MainView view) {
		super();
		this.model = model;
		this.dbControl = dbControl;
		this.view = view;
	}

	public Fornitori costruisciFornitore() {
		String PIVA = (String) prodottiutiliPanel.getFornitoriBox().getSelectedItem();
		Fornitori forn = dbControl.selectFornitoreFromPiva(PIVA);
		return forn;

	}

	public void pulisciTextField() {

		prodottiutiliPanel.getNomeText().setText(null);
		prodottiutiliPanel.getFornitoriBox().setSelectedIndex(0);
		prodottiutiliPanel.getSpinner().setValue(0);
	}
}
