package appuntamenti.operazioni;

import java.util.ArrayList;

public interface IOperazioniDAO {

	public ArrayList<Operazioni> selectAll();

	public boolean insertOperazioni(Operazioni f);
}
