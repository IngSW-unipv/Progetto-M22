package database.classiDAO.magazzinoDAO.prodottiVenditaDAO;
/**
 * interfaccia con metodi da implementare
 * in ProdottiVenditaDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see ProdottiVenditaDAO
 */
import java.util.ArrayList;

import model.magazzino.prodottiVendita.ProdottiVendita;

public interface IProdottiVenditaDAO {

	public ArrayList<ProdottiVendita> selectAll();

	public boolean insertProdottiVendita(ProdottiVendita p);

	public int selectCODprodotto(int rigaSelezionata);
	
	public void deleteProdottiVendita(int cod);
	
	public void updateProdottiVendita(ProdottiVendita p);
}
