package controller.appuntamentiController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
import view.PopupError;

/**
 * Riempie i campi testo con il record selezionato per poi eventualmente
 * modificarli e aggiornare record
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class ModificaAppuntamentiActionListener implements ActionListener {

	private SmartVetModel model;
	private MainView view;

	/**
	 * riempie i campi testo/data della riga selezionata della tabella
	 * 
	 * @param e evento schiaccia bottone modifica
	 * @return void
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int rigaSelezionata = view.getAppuntamentiPanel().getTab().getTable().getSelectedRow();

		if (rigaSelezionata >= 0) {


			int IDpaz = (int) view.getAppuntamentiPanel().getTab().getTable().getModel().getValueAt(rigaSelezionata,0);
			String sala =view.getAppuntamentiPanel().getTab().getTable().getModel().getValueAt(rigaSelezionata,1).toString();
			String tipo = view.getAppuntamentiPanel().getTab().getTable().getModel().getValueAt(rigaSelezionata,2).toString();
			Date data =(Date) view.getAppuntamentiPanel().getTab().getTable().getModel().getValueAt(rigaSelezionata,3);
			String ora = view.getAppuntamentiPanel().getTab().getTable().getModel().getValueAt(rigaSelezionata,4).toString();
			
			SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");
			Time timeValue = null;
			
			
			try {
				timeValue = new java.sql.Time(stf.parse(ora).getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String CFvet = view.getAppuntamentiPanel().getTab().getTable().getModel().getValueAt(rigaSelezionata,5).toString();
			double costo = (double) view.getAppuntamentiPanel().getTab().getTable().getModel().getValueAt(rigaSelezionata,6);
			String note = view.getAppuntamentiPanel().getTab().getTable().getModel().getValueAt(rigaSelezionata,7).toString();
 
			view.getAppuntamentiPanel().getIDpazText().setSelectedItem(IDpaz);
			view.getAppuntamentiPanel().getSalaText().setSelectedItem(sala);
			view.getAppuntamentiPanel().getTipoText().setText(tipo);
			view.getAppuntamentiPanel().getDataText().setDate(data);
			view.getAppuntamentiPanel().getTimeChooserText().setTime(timeValue);

			if (view.getAppuntamentiPanel().getCFvetText() != null) {
				view.getAppuntamentiPanel().getCFvetText().setSelectedItem(CFvet);
			}

			view.getAppuntamentiPanel().getCostoText().setText(Double.toString(costo));
			view.getAppuntamentiPanel().getNoteText().setText(note);
		}
	}

	/**
	 * costruttore
	 * 
	 * @param model     modello
	 * @param dbControl database
	 * @param view      grafica
	 */
	public ModificaAppuntamentiActionListener(SmartVetModel model, MainView view) {
		super();
		this.model = model;
		this.view = view;
	}

}