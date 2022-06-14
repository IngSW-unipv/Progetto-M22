package database.classiDAO.appuntamentiDAO;
/**
 * interfaccia con metodi da implementare
 * in StoricoDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see StoricoDAO
 */
import java.util.ArrayList;

import model.appuntamenti.Appuntamenti;

public interface IStoricoDAO {
	
	public ArrayList<Appuntamenti> selectAll();
	
	public ArrayList<Appuntamenti> selectAllDueToVeterinario(String CFvet);
}
