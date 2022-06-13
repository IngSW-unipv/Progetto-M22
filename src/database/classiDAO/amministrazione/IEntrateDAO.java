package database.classiDAO.amministrazione;

import java.util.ArrayList;

import model.amministrazione.Entrate;

public interface IEntrateDAO {

	public ArrayList<Entrate> selectAll();
	
	public boolean insertEntrate(Entrate entrate);
	
	public int selectIDentrata(int rigaSelezionata);
	
	public void deleteEntrate(int ID);
}
