package database.classiDAO.amministrazione;
/**
 * interfaccia con metodi da implementare
 * in entrateDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see UsciteDAO
 */
import java.util.ArrayList;

import model.amministrazione.Uscite;

public interface IUsciteDAO {
	
	public ArrayList<Uscite> selectAll();
	
	public boolean insertUscite(Uscite uscite);
	
	public void deleteUscite(int ID);
	
	public int selectIDuscita(int rigaSelezionata);
}
