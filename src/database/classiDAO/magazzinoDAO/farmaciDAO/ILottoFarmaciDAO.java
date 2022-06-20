package database.classiDAO.magazzinoDAO.farmaciDAO;
/**
 * interfaccia con metodi da implementare
 * in LottoFarmaciDAO
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 * @see LottoFarmaciDAO
 */
import java.util.ArrayList;

import database.classiDAO.appuntamentiDAO.AppuntamentiDAO;
import model.magazzino.farmaci.LottoFarmaci;

public interface ILottoFarmaciDAO {

	public ArrayList<LottoFarmaci> selectAll();

	public boolean insertFarmaci(LottoFarmaci f);

	public ArrayList<LottoFarmaci> getFarmaciScadenza();
	
	public void deleteFarmaci(LottoFarmaci f);

	void updateLottoFarmaci(LottoFarmaci f);
}
