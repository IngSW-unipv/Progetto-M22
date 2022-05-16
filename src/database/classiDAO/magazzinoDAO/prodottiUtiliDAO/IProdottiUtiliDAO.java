package database.classiDAO.magazzinoDAO.prodottiUtiliDAO;

import java.util.ArrayList;

import model.magazzino.prodottiUtili.ProdottiUtili;

public interface IProdottiUtiliDAO {

	public ArrayList<ProdottiUtili> selectAll();

	public boolean insertProdottiUtili(ProdottiUtili p);

}
