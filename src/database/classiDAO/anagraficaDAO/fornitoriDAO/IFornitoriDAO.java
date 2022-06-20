package database.classiDAO.anagraficaDAO.fornitoriDAO;

/**
 * interfaccia con metodi da implementare
 * in FornitoriDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see FornitoriDAO
 */
import java.util.ArrayList;

import model.anagrafica.fornitori.Fornitori;

public interface IFornitoriDAO {

	public ArrayList<Fornitori> selectAll();

	public boolean insertFornitore(Fornitori f);

	public Fornitori select_Forn(String PIVA);

	public void deleteFornitori(Fornitori fo);

	void updateFornitori(Fornitori fo);
}
