package database.classiDAO.pazientiDAO;

import java.util.ArrayList;

import model.pazienti.Paziente;

public interface IPazienteDAO {

	public ArrayList<Paziente> selectAll();

	public boolean insertPaziente(Paziente f);
	
	public Paziente selectPazientefromID(int ID);
	
	public int selectID_PAZ(int rigaSelezionata);
	
	public void deletePazienti(int id);
	
	public void updatePaziente(Paziente p);
}
