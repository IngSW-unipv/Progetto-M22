package controller.amministrazioneController.usciteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import model.amministrazione.Uscite;
import view.MainView;
import view.PopupError;

public class AggiungiUsciteActionListener implements ActionListener {
	private SmartVetModel model;
	private MainView view;
	private DbControllerSingleton dbControl;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String causa = view.getUscitePanel().getCausaText().getText();
		String tipo = view.getUscitePanel().getTipoText().getText();
		double prezzo = .0;

		try {

			prezzo = Double.parseDouble(view.getUscitePanel().getPrezzoText().getText());
		}

		catch (NumberFormatException nfe) {

			nfe.printStackTrace();
			PopupError err = new PopupError();
			err.infoBox("il prezzo deve contenere solo cifre", "Errore");

		}

		java.sql.Date sqlDate = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date data = new Date();

		if (data != null) {

			sdf.format(data);

			sqlDate = new java.sql.Date(data.getTime());
		}

		Uscite uscita = new Uscite(0, causa, tipo, prezzo, sqlDate);

		boolean flag = dbControl.insertUscite(uscita);

		if (flag) {

			model.getUsciteArray().add(uscita);

			Object rowData[] = new Object[4];

			DefaultTableModel model = (DefaultTableModel) view.getUscitePanel()
					.getTab().getTable().getModel();

			rowData[0] = causa;
			rowData[1] = tipo;
			rowData[2] = prezzo;
			rowData[3] = sqlDate;

			model.addRow(rowData);

			pulisciTextField();
		}

		else {

			{
				PopupError err = new PopupError();
				err.infoBox("Impossibile inserire uscita", "Errore");
				pulisciTextField();

			}

		}

	}

	public void pulisciTextField() {

		view.getUscitePanel().getCausaText().setText(null);
		view.getUscitePanel().getTipoText().setText(null);
		view.getUscitePanel().getPrezzoText().setText(null);
	}

	public AggiungiUsciteActionListener(SmartVetModel model, MainView view, DbControllerSingleton dbControl) {
		super();
		this.model = model;
		this.view = view;
		this.dbControl = dbControl;
	}

}
