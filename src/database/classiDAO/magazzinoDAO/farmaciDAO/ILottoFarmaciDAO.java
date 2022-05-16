package database.classiDAO.magazzinoDAO.farmaciDAO;

import java.util.ArrayList;

public interface ILottoFarmaciDAO {

	public ArrayList<LottoFarmaci> selectAll();

	public boolean insertLottoFarmaci(LottoFarmaci f);

	boolean insertFarmaci(LottoFarmaci f);

}
