package database.classiDAO.magazzinoDAO.prodottiUtiliDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.fornitoriDAO.FornitoriDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.fornitori.Fornitori;
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
		FornitoriDAO forn = new FornitoriDAO();

		try {
			String query = "SELECT * FROM PRODOTTI_UTILI ORDER BY COD_PROD";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				String PIVA_Fornitore = rs1.getString(5);

				Fornitori fornitore = forn.select_Forn(PIVA_Fornitore);

				ProdottiUtili p = new ProdottiUtili(rs1.getInt(4), rs1.getString(1), rs1.getString(2), rs1.getInt(3), fornitore);

				result.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insertProdottiUtili(ProdottiUtili p) {

		String query = "INSERT INTO PRODOTTI_UTILI (NOME,TIPO,QTA,PIVA) values (?, ?, ?, ?);";

		
		ResultSet rs;
		PreparedStatement stmt = null;
		int COD = 0;

		try {

			stmt = db.getConnection().prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getType());
			stmt.setInt(3, p.getQuantita());
			stmt.setString(4, p.getFornitore().getPIVA());
			
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			rs.next();
			COD = rs.getInt(1);
			p.setCOD(COD);
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int selectCODprodotto(int rigaSelezionata) {

		ResultSet rs1;
		db = DbSingleton.getInstance();
		rigaSelezionata = rigaSelezionata + 1;
		String query = "SELECT COD_PROD FROM\n" + "(\n"
				+ "SELECT  COD_PROD, ROW_NUMBER() OVER (ORDER BY COD_PROD) AS RowNumber\n" + "FROM PRODOTTI_UTILI\n"
				+ ") A\n" + "WHERE RowNumber = \"" + rigaSelezionata + "\"";
		rs1 = db.executeQuery(query);

		try {
			if (rs1.next()) {

				return rs1.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return -1;
	}

	public void deleteProdottiUtili(int cod) {

		String query = "delete from PRODOTTI_UTILI where COD_PROD=\"" + cod + "\"";
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

	public void updateProdottiUtili(ProdottiUtili p) {

		String query = "UPDATE PRODOTTI_UTILI SET NOME = ?, TIPO = ?, QTA = ?, PIVA = ?" + " where COD_PROD=\"" + p.getCOD()
				+ "\"";
		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getType());
			stmt.setInt(3, p.getQuantita());
			stmt.setString(4, p.getFornitore().getPIVA());
			stmt.executeUpdate();

			stmt.executeUpdate();
			
			p.setCOD(p.getCOD());
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		ProdottiUtiliDAO pdao = new ProdottiUtiliDAO();

		ArrayList<ProdottiUtili> res = pdao.selectAll();

		for (ProdottiUtili r : res)
			System.out.println(r.toString());
	}

}
