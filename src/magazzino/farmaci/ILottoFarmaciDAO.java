package magazzino.farmaci;

import java.util.ArrayList;

public interface ILottoFarmaciDAO {

	public ArrayList<LottoFarmaci> selectAll();

	public boolean insertLottoFarmaci(LottoFarmaci f);

}
