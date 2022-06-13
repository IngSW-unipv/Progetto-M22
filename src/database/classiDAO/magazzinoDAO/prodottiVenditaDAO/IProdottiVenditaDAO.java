package database.classiDAO.magazzinoDAO.prodottiVenditaDAO;

import java.util.ArrayList;

import model.magazzino.prodottiVendita.ProdottiVendita;

public interface IProdottiVenditaDAO {

	public ArrayList<ProdottiVendita> selectAll();

	public boolean insertProdottiVendita(ProdottiVendita p);

	public int selectCODprodotto(int rigaSelezionata);
	
	public void deleteProdottiVenditai(int cod);
	
	public void updateProdottiVendita(ProdottiVendita p);
}
