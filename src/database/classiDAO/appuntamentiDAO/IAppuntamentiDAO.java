package database.classiDAO.appuntamentiDAO;

import java.util.ArrayList;

import model.appuntamenti.Appuntamenti;

public interface IAppuntamentiDAO {
	
	public ArrayList<Appuntamenti> selectAll();

	public boolean insertAppuntamenti(Appuntamenti v);
}
