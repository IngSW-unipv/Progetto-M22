package magazzino.ProdottiVendita;

import java.util.ArrayList;

public interface IProdottiVenditaDAO {

	public ArrayList<ProdottiVendita> selectAll();

	public boolean insertProdottiVendita(ProdottiVendita p);

}
