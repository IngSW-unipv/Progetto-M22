package controller.appuntamentiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class ModificaAppuntamentiActionListener implements ActionListener {
	private SmartVetModel model;
	private MainView view;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int rigaSelezionata = view.getAppuntamentiPanel().getTab().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {

			int IDpaz = model.getAppuntamentiArray().get(rigaSelezionata).getPaziente().getIDpaz();
			String sala = model.getAppuntamentiArray().get(rigaSelezionata).getSala();
			String tipo = model.getAppuntamentiArray().get(rigaSelezionata).getTipo();
			Date data = model.getAppuntamentiArray().get(rigaSelezionata).getData();
			Time ora = model.getAppuntamentiArray().get(rigaSelezionata).getTime();
			String CFvet = model.getAppuntamentiArray().get(rigaSelezionata).getVeterinario().getCF();
			double costo = model.getAppuntamentiArray().get(rigaSelezionata).getCosto();
			String note = model.getAppuntamentiArray().get(rigaSelezionata).getNote();

			view.getAppuntamentiPanel().getIDpazText().setSelectedItem(IDpaz);
			view.getAppuntamentiPanel().getSalaText().setSelectedItem(sala);
			view.getAppuntamentiPanel().getTipoText().setText(tipo);
			view.getAppuntamentiPanel().getDataText().setDate(data);
			view.getAppuntamentiPanel().getTimeChooserText().setTime(ora);

			if (view.getAppuntamentiPanel().getCFvetText() != null) {
				view.getAppuntamentiPanel().getCFvetText().setSelectedItem(CFvet);
			}

			view.getAppuntamentiPanel().getCostoText().setText(Double.toString(costo));
			view.getAppuntamentiPanel().getNoteText().setText(note);
		}
	}

	public ModificaAppuntamentiActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}