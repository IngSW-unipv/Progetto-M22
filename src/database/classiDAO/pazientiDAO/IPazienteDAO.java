package database.classiDAO.pazientiDAO;

import java.util.ArrayList;

import model.pazienti.Paziente;

/**
 * interfaccia con metodi da implementare
 * in PazienteDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see PazienteDAO
 */
public interface IPazienteDAO {

	public ArrayList<Paziente> selectAll();

	public boolean insertPaziente(Paziente f);
	
	public Paziente selectPazientefromID(int ID);
	
	public int selectID_PAZ(int rigaSelezionata);
	
	public void deletePazienti(int id);
	
	public void updatePaziente(Paziente p);
}
