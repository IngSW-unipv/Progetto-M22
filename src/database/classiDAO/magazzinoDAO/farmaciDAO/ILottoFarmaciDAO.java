package database.classiDAO.magazzinoDAO.farmaciDAO;

import java.util.ArrayList;

import model.magazzino.farmaci.LottoFarmaci;

public interface ILottoFarmaciDAO {

	public ArrayList<LottoFarmaci> selectAll();

	public boolean insertLottoFarmaci(LottoFarmaci f);

	boolean insertFarmaci(LottoFarmaci f);

}
