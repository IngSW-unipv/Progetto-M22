package appuntamenti.operazioni;

import java.sql.ResultSet;
import java.util.ArrayList;

import ConnectionSQL.DbSingleton;

public class OperazioniDAO implements IOperazioniDAO {

	private DbSingleton db;

	public OperazioniDAO() {
		super();

	}

	public ArrayList<Operazioni> selectAll() {
		ArrayList<Operazioni> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM OPERAZIONI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Operazioni v = new Operazioni(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getDate(5), rs1.getTime(6), rs1.getString(7), rs1.getDouble(8), rs1.getString(9));

				result.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean insertOperazioni(Operazioni p) {
		// TODO Auto-generated method stub
		return false;
	}

	public static class Engine1 {

		public static void main(String[] args) {

			OperazioniDAO pdao = new OperazioniDAO();

			ArrayList<Operazioni> res = pdao.selectAll();

			for (Operazioni r : res)
				System.out.println(r.toString());
		}

	}

}
