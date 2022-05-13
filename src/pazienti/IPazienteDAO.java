package pazienti;

import java.util.ArrayList;

public interface IPazienteDAO {

	public ArrayList<Paziente> selectAll();

	public boolean insertPaziente(Paziente f);
}
