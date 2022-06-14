package database.classiDAO.magazzinoDAO.prodottiUtiliDAO;
/**
 * interfaccia con metodi da implementare
 * in ProdottiUtiliDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see ProdottiUtiliDAO
 */
import java.util.ArrayList;

import database.classiDAO.appuntamentiDAO.AppuntamentiDAO;
import model.magazzino.prodottiUtili.ProdottiUtili;

public interface IProdottiUtiliDAO {

	public ArrayList<ProdottiUtili> selectAll();

	public boolean insertProdottiUtili(ProdottiUtili p);
	
	public void updateProdottiUtili(ProdottiUtili p);
	
	public void deleteProdottiUtili(int cod);
	
	public int selectCODprodotto(int rigaSelezionata);
	

}
