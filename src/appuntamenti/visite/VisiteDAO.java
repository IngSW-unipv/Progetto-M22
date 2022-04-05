package appuntamenti.visite;

import java.sql.ResultSet;
import java.util.ArrayList;

import ConnectionSQL.DbSingleton;

public class VisiteDAO implements IVisiteDAO {
	private DbSingleton db;

	public VisiteDAO() {
		super();

	}

	public ArrayList<Visite> selectAll() {
		ArrayList<Visite> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM VISITE";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Visite v = new Visite(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getDate(5), rs1.getTime(6), rs1.getString(7), rs1.getDouble(8), rs1.getString(9));

				result.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean insertVisite(Visite p) {
		// TODO Auto-generated method stub
		return false;
	}

	public static class Engine1 {

		public static void main(String[] args) {

			VisiteDAO pdao = new VisiteDAO();

			ArrayList<Visite> res = pdao.selectAll();

			for (Visite r : res)
				System.out.println(r.toString());
		}

	}
}
