package database.classiDAO.magazzinoDAO.prodottiVenditaDAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.connectionSQL.DbSingleton;
import model.magazzino.prodottiVendita.ProdottiVendita;

public class ProdottiVenditaDAO implements IProdottiVenditaDAO {

	private DbSingleton db;

	public ProdottiVenditaDAO() {
		super();

	}

	public ArrayList<ProdottiVendita> selectAll() {
		ArrayList<ProdottiVendita> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM PRODOTTI_VENDITA";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				ProdottiVendita p = new ProdottiVendita(rs1.getString(1), rs1.getInt(2), rs1.getString(3),
						rs1.getString(4), rs1.getDate(5));

				result.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}



	@Override
	public boolean insertProdottiVendita(ProdottiVendita p) {
		// TODO Auto-generated method stub
		return false;
	}
}
