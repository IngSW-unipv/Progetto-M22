package database.classiDAO.appuntamentiDAO;

import java.util.ArrayList;

import model.appuntamenti.Appuntamenti;

public interface IAppuntamentiDAO {
	
	public ArrayList<Appuntamenti> selectAll();

	public boolean insertAppuntamenti(Appuntamenti p);
	
	public int selectIDappuntamenti(int rigaSelezionata);
	
	public void deleteAppuntamenti(int cod);
	
	public ArrayList<Appuntamenti> appuntamentiOggiDueToVet(String CF_vetReferente);
	
	public ArrayList<Appuntamenti> appuntamentiOggi();
	
	public void updateAppuntamenti(Appuntamenti p);
	
	public ArrayList<Appuntamenti> selectAllDueToVeterinario(String CFvet);
}
