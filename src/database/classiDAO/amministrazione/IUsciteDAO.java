package database.classiDAO.amministrazione;

import java.util.ArrayList;

import model.amministrazione.Uscite;

public interface IUsciteDAO {
	
	public ArrayList<Uscite> selectAll();
	
	public boolean insertUscite(Uscite uscite);
	
	public void deleteUscite(int ID);
	
	public int selectIDuscita(int rigaSelezionata);
}
