package anagrafica.fornitori;

import java.util.ArrayList;

public interface IFornitoriDAO {

	public ArrayList<Fornitori> selectAll();

	public boolean insertFornitore(Fornitori f);

}
