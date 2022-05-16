package database.classiDAO.anagraficaDAO.clientiDAO;

import java.util.ArrayList;

import model.anagrafica.clienti.Clienti;

public interface IClientiDAO {

	public ArrayList<Clienti> selectAll();

	public boolean insertClienti(Clienti c);
}
