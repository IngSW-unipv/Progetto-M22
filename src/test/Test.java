package test;

/**
 * permette di testare il programma
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
import java.awt.EventQueue;

import controller.Controller;
import model.SmartVetModel;
import view.MainView;

/**
 * fa partire il programma istanziando model view e controller
 * 
 * @param Strings[] args passati da riga di comando
 */
public class Test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartVetModel model = SmartVetModel.getInstance();
				
					MainView view = new MainView();

					@SuppressWarnings("unused")
					Controller ctrl = new Controller(model, view);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//costruttore
	public Test() {

	}
	
}
