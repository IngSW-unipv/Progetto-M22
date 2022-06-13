package database.classiDAO.anagraficaDAO.fornitoriDAO;

import java.util.ArrayList;

import model.anagrafica.fornitori.Fornitori;

public interface IFornitoriDAO {

	public ArrayList<Fornitori> selectAll();

	public boolean insertFornitore(Fornitori f);

	public Fornitori select_Forn(String PIVA);
	
	public void deleteFornitori(Fornitori fo);
}
