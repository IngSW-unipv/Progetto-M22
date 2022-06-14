package controller.loginController;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
/**
 * collega le credenziali col bottone di OK
 * e con il database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class LoginController {

	private MainView view;
	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private GoBtnActionListener go;
	
	/**
	 * costruttore 
	 * costruisce anche bottone OK
	 * con action listener
	 * @param model     modello
	 * @param view      grafica
	 * @param dbControl database
	 */
	public LoginController(MainView view, SmartVetModel model) {

		this.view = view; 
		this.model = model;
		
		dbControl = DbControllerSingleton.getInstance();

		go = new GoBtnActionListener(view, model);
		view.getLoginView().getBtnGo().addActionListener(go);

		addEsciActionListener();
	}

	/**
	 * restituisce bottone ok del login
	 * @return GoBtnActionlistener
	 */
	public GoBtnActionListener getGo() {
		return go;
	}

	/**
	 * aggiunge actionlistener al bottone esci
	 * per uscire da account loggato
	 * @return void
	 */
	public void addEsciActionListener() {

		EsciAccountActionListener esci = new EsciAccountActionListener(view, model);
		view.getDashboard().getMenu().getMntmEsciAccount().addActionListener(esci);
	}

}
