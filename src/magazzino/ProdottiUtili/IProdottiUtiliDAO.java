package magazzino.ProdottiUtili;

import java.util.ArrayList;

public interface IProdottiUtiliDAO {

	public ArrayList<ProdottiUtili> selectAll();

	public boolean insertProdottiUtili(ProdottiUtili p);

}
