package controller.loginController;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class LoginController {

	private MainView view;
	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private GoBtnActionListener go;

	public LoginController(MainView view, SmartVetModel model) {

		this.view = view; 
		this.model = model;
		
		dbControl = DbControllerSingleton.getInstance();

		go = new GoBtnActionListener(view, model);
		view.getLoginView().getBtnGo().addActionListener(go);

		addEsciActionListener();
	}

	public GoBtnActionListener getGo() {
		return go;
	}

	public void addEsciActionListener() {

		EsciAccountActionListener esci = new EsciAccountActionListener(view, model);
		view.getDashboard().getMenu().getMntmEsciAccount().addActionListener(esci);
	}

}
