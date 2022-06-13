package controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;

public class RegistratiController {

	private MainView view;
	private SmartVetModel model;
	private DbControllerSingleton dbControl;

	public RegistratiController(MainView view, SmartVetModel model, DbControllerSingleton dbControl) {

		this.view = view;
		this.dbControl = dbControl;
		this.model = model;

		fillComboBoxVet();
		addActionListenerRegistrati();
		addMenuActionListener();

	}

	public void addMenuActionListener() {
		view.getDashboard().getMenu().getMntmNuovoAccount().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getRegistratiView().setVisible(true);

			}
		});
	}

	public void addActionListenerRegistrati() {
		RegistratiActionListener registrati = new RegistratiActionListener(view, dbControl);
		view.getRegistratiView().getBtnGo().addActionListener(registrati);
	}

	public void fillComboBoxVet() {

		ArrayList<String> listaCFvet = new ArrayList<String>();

		for (int i = 0; i < model.getVeterinariArray().size(); i++) {

			listaCFvet.add(model.getVeterinariArray().get(i).getCF());

			if (listaCFvet.get(i) != null && !(listaCFvet.get(i).equals("direzione"))) {

				view.getRegistratiView().getComboBox().addItem(listaCFvet.get(i));
			}
		}
	}
}