package database.classiDAO.appuntamentiDAO;

import java.util.ArrayList;

import model.appuntamenti.Appuntamenti;
/**
 * interfaccia con metodi da implementare
 * in AppuntamentiDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see AppuntamentiDAO
 */
public interface IAppuntamentiDAO {
	
	public ArrayList<Appuntamenti> selectAll();

	public boolean insertAppuntamenti(Appuntamenti p);
	
	public int selectIDappuntamenti(int rigaSelezionata, String CF);
	
	public void deleteAppuntamenti(int cod);
	
	public ArrayList<Appuntamenti> appuntamentiOggiDueToVet(String CF_vetReferente);
	
	public ArrayList<Appuntamenti> appuntamentiOggi();
	
	public void updateAppuntamenti(Appuntamenti p);
	
	public ArrayList<Appuntamenti> selectAllDueToVeterinario(String CFvet);

	/**
	 * seleziona appuntamento a seconda della riga della tabella grafica che
	 * corrisponde alla riga del db (solo per appuntamenti da giorno corrente in
	 * poi)
	 * 
	 * @param rigaselezionata riga selezionata da tabella
	 * @return int Id dell'appuntamento selezionato
	 * @exception SQLException qualcosa è andato storto nel db
	 */

}
