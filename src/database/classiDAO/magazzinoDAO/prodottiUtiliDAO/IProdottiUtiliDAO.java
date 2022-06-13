package database.classiDAO.magazzinoDAO.prodottiUtiliDAO;

import java.util.ArrayList;

import model.magazzino.prodottiUtili.ProdottiUtili;

public interface IProdottiUtiliDAO {

	public ArrayList<ProdottiUtili> selectAll();

	public boolean insertProdottiUtili(ProdottiUtili p);
	
	public void updateProdottiUtili(ProdottiUtili p);
	
	public void deleteProdottiUtili(int cod);
	
	public int selectCODprodotto(int rigaSelezionata);
	

}
