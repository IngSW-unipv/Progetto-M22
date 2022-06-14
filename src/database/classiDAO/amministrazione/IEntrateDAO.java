package database.classiDAO.amministrazione;
/**
 * interfaccia con metodi da implementare
 * in EntrateDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see EntrateDAO
 */

import java.util.ArrayList;

import controller.amministrazioneController.entrateController.EntrateController;
import model.amministrazione.Entrate;

public interface IEntrateDAO {

	public ArrayList<Entrate> selectAll();
	
	public boolean insertEntrate(Entrate entrate);
	
	public int selectIDentrata(int rigaSelezionata);
	
	public void deleteEntrate(int ID);
}
