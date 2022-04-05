package anagrafica.clienti;

import java.util.ArrayList;

public interface IClientiDAO {

	public ArrayList<Clienti> selectAll();

	public boolean insertClienti(Clienti c);
}
