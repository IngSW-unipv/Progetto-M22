package magazzino.ProdottiUtili;

import java.sql.ResultSet;
import java.util.ArrayList;

import ConnectionSQL.DbSingleton;

public class ProdottiUtiliDAO implements IProdottiUtiliDAO {
	private DbSingleton db;

	public ProdottiUtiliDAO() {
		super();
	}

	public ArrayList<ProdottiUtili> selectAll() {
		ArrayList<ProdottiUtili> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM PRODOTTI_UTILI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				ProdottiUtili p = new ProdottiUtili(rs1.getString(1), rs1.getInt(2), rs1.getString(3),
						rs1.getString(4));

				result.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {

		ProdottiUtiliDAO pdao = new ProdottiUtiliDAO();

		ArrayList<ProdottiUtili> res = pdao.selectAll();

		for (ProdottiUtili r : res)
			System.out.println(r.toString());
	}

	@Override
	public boolean insertProdottiUtili(ProdottiUtili p) {
		// TODO Auto-generated method stub
		return false;
	}

}
