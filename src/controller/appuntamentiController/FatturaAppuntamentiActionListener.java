package controller.appuntamentiController;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.amministrazione.Entrate;
import view.MainView;
import view.login.PopUpOk;

/**
 * Fattura Appuntamento selezionato
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class FatturaAppuntamentiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	/**
	 * inserisce appuntamento selezionato nelle entrate con prezzo, causa e data al
	 * momento dell fatturazione
	 * 
	 * @param e evento schiaccia bottone fattura
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int rigaSelezionata = view.getAppuntamentiPanel().getTab().getTable().getSelectedRow();

		java.sql.Date sqlDate = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date data = new Date();

		if (data != null) {

			sdf.format(data);

			sqlDate = new java.sql.Date(data.getTime());
		}

		if (rigaSelezionata >= 0) {

			String causa = "Appuntamento";
			String tipo = view.getAppuntamentiPanel().getTab().getTable().getModel().getValueAt(rigaSelezionata, 2).toString();
			double prezzo = (double) view.getAppuntamentiPanel().getTab().getTable().getModel().getValueAt(rigaSelezionata, 6);

			Entrate entrata = new Entrate(0, tipo, prezzo, causa, sqlDate);

			dbControl.insertEntrate(entrata);

			model.getEntrateArray().add(entrata);

			DefaultTableModel modello = (DefaultTableModel) view.getEntratePanel().getTab().getTable().getModel();
			Object rowData[] = new Object[4];

			rowData[0] = causa;
			rowData[1] = tipo;
			rowData[2] = prezzo; 
			rowData[3] = sqlDate;
			
			modello.addRow(rowData);
	
			PopUpOk pop = new PopUpOk();
			pop.infoBox("Fatturazione avvenuta con successo", "OK");

		}
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public FatturaAppuntamentiActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
