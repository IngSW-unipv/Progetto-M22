package database.classiDAO.magazzinoDAO.prodottiUtiliDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.fornitoriDAO.FornitoriDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.farmaci.LottoFarmaci;
import model.magazzino.prodottiUtili.ProdottiUtili;

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
				FornitoriDAO forn = new FornitoriDAO();
				String PIVA_Fornitore = rs1.getString(4);

				Fornitori fornitore = forn.select_Forn(PIVA_Fornitore);
				
				ProdottiUtili p = new ProdottiUtili(rs1.getString(1), rs1.getInt(2), rs1.getString(3),
						fornitore);

				result.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean insertProdottiUtili(ProdottiUtili p) {

		String query = "INSERT INTO PRODOTTI_UTILI (NOME, QTA, COD_PROD, PIVA) values (?, ?, ?, ?, ?, ?);";

		PreparedStatement stmt = null;

		try {
			

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, p.get());
			stmt.setString(2, f.getMode());
			stmt.setString(3, f.getType());
			stmt.setString(4, f.getFornitore().getPIVA());
			stmt.setDate(5, f.getDataScadenza());
			stmt.setInt(6, f.getQuantita());
			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void deleteFarmaci(LottoFarmaci f) {
		String IDLotto = f.getIDLotto();
		String query = "delete from FARMACI where LOTTO=\"" + IDLotto + "\"";
		PreparedStatement stmt = null;
		try {
			stmt = db.getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
