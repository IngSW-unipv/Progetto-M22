package magazzino.farmaci;

import java.sql.ResultSet;
import java.util.ArrayList;

import ConnectionSQL.DbSingleton;

public class LottoFarmaciDAO implements ILottoFarmaciDAO {

	private DbSingleton db;

	public LottoFarmaciDAO() {
		super();
	}

	public ArrayList<LottoFarmaci> selectAll() {
		ArrayList<LottoFarmaci> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM FARMACI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				LottoFarmaci f = new LottoFarmaci(rs1.getString(1), rs1.getString(2), rs1.getString(3),
						rs1.getString(4), rs1.getDate(5), rs1.getInt(6));

				result.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {

		LottoFarmaciDAO fdao = new LottoFarmaciDAO();

		ArrayList<LottoFarmaci> res = fdao.selectAll();

		for (LottoFarmaci r : res)
			System.out.println(r.toString());
	}

	@Override
	public boolean insertLottoFarmaci(LottoFarmaci f) {
		// TODO Auto-generated method stub
		return false;
	}
}
