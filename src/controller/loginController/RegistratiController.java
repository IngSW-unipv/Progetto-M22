package controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import database.connectionSQL.DbControllerSingleton;
import model.SmartVetModel;
import view.MainView;
/**
 * collega le credenziali nuovo account
 *  col bottone di OK
 * e con il database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class RegistratiController {

	private MainView view;
	private SmartVetModel model;
	private DbControllerSingleton dbControl;

	/**
	 * costruttore 
	 * @param model     modello
	 * @param view      grafica
	 * @param dbControl database
	 */
	public RegistratiController(MainView view, SmartVetModel model) {

		this.view = view;
		dbControl = DbControllerSingleton.getInstance();
		this.model = model;

		fillComboBoxVet();
		addActionListenerRegistrati();
		addActionListener();

	}

	
	/**
	 * Aggiunge action listener al menu per aprire pannello registrazione da login
	 * 
	 * @return void
	 */
	public void addActionListener() {
		view.getLoginView().getBtnRegistrati().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.getRegistratiView().setVisible(true);

			}
		});
	}

	
	/**
	 * Aggiunge action listener registrati per registrare nuovo account
	 * 
	 * @return void
	 */
	public void addActionListenerRegistrati() {
		RegistratiActionListener registrati = new RegistratiActionListener(view, dbControl);
		view.getRegistratiView().getBtnGo().addActionListener(registrati);
	}

	/**
	 * riempie la combobox con tutti i CF dei veterinari
	 * presenti nel database
	 * 
	 * @return void
	 */
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