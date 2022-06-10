package controller.loginController;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class LoginController {

	private MainView view;
	private SmartVetModel model;
	private DbControllerSingleton dbControl;
	private GoBtnActionListener go;

	public LoginController(MainView view, SmartVetModel model, DbControllerSingleton dbControl) {

		this.view = view;
		this.model = model;
		this.dbControl = dbControl;

		go = new GoBtnActionListener(view, model, dbControl);
		view.getLoginView().getBtnGo().addActionListener(go);
	}

	public GoBtnActionListener getGo() {
		return go;
	}
}
