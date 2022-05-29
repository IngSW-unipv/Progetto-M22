package database.classiDAO.magazzinoDAO.prodottiVenditaDAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.fornitoriDAO.FornitoriDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.fornitori.Fornitori;
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
				FornitoriDAO forn = new FornitoriDAO();
				String PIVA_Fornitore = rs1.getString(4);

				Fornitori fornitore = forn.select_Forn(PIVA_Fornitore);

				ProdottiVendita p = new ProdottiVendita(rs1.getString(1), rs1.getInt(2), rs1.getString(3), fornitore,
						rs1.getDate(5));

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
