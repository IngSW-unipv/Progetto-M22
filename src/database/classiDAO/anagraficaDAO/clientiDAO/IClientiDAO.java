package database.classiDAO.anagraficaDAO.clientiDAO;
/**
 * interfaccia con metodi da implementare
 * in ClientiDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see ClientiDAO
 */
import java.util.ArrayList;

import model.anagrafica.clienti.Clienti;

public interface IClientiDAO {

	public ArrayList<Clienti> selectAll();

	public boolean insertClienti(Clienti c);
	
	public Clienti select_cliente_from_CF(String CF);
	
	public void deleteClienti(Clienti cl);
}
