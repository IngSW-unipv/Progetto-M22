package database.classiDAO.appuntamentiDAO;

import java.util.ArrayList;

import model.appuntamenti.Appuntamenti;

public interface IStoricoDAO {
	
	public ArrayList<Appuntamenti> selectAll();
	
	public ArrayList<Appuntamenti> selectAllDueToVeterinario(String CFvet);
}
