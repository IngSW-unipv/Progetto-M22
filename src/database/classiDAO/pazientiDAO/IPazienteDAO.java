package database.classiDAO.pazientiDAO;

import java.util.ArrayList;

import model.pazienti.Paziente;

public interface IPazienteDAO {

	public ArrayList<Paziente> selectAll();

	public boolean insertPaziente(Paziente f);
}
