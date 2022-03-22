package anagrafica.fornitori;

import java.sql.ResultSet;

import java.util.ArrayList;

import ConnectionSQL.DbSingleton;

public class FornitoriDAO implements IFornitoriDAO {

	private DbSingleton db;

	public FornitoriDAO() {
		super();
	}

	public ArrayList<Fornitori> selectAll() {
		ArrayList<Fornitori> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * from FORNITORI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Fornitori f = new Fornitori(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6),rs1.getString(7));

				result.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insertFornitore(Fornitori f) {
		// TODO Auto-generated method stub
		return false;
	}

}
