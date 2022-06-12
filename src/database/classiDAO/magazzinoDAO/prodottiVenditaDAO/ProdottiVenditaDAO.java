package database.classiDAO.magazzinoDAO.prodottiVenditaDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				String PIVA_Fornitore = rs1.getString(5);

				Fornitori fornitore = forn.select_Forn(PIVA_Fornitore);

				ProdottiVendita p = new ProdottiVendita(rs1.getInt(4), rs1.getString(1), rs1.getString(2),
						rs1.getInt(3), fornitore, rs1.getDate(6));

				result.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean insertProdottiVendita(ProdottiVendita p) {

		String query = "INSERT INTO PRODOTTI_VENDITA (NOME, TIPO, QTA, PIVA, DATA_SCAD) values (?, ?, ?, ?, ?);";

		ResultSet rs;
		PreparedStatement stmt = null;
		int COD = 0;

		try {

			stmt = db.getConnection().prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getType());
			stmt.setInt(3, p.getQuantita());
			stmt.setString(4, p.getFornitore().getPIVA());
			stmt.setDate(5, p.getDataScadenza());

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
				+ "SELECT  COD_PROD, ROW_NUMBER() OVER (ORDER BY COD_PROD) AS RowNumber\n" + "FROM PRODOTTI_VENDITA\n"
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

	public void deleteProdottiVenditai(int cod) {

		String query = "delete from PRODOTTI_VENDITA where COD_PROD=\"" + cod + "\"";
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

	public void updateProdottiVendita(ProdottiVendita p) {

		String query = "UPDATE PRODOTTI_VENDITA SET NOME = ?, TIPO = ?, QTA = ?, PIVA = ?, DATA_SCAD = ?" + ""
				+ " where COD_PROD=\"" + p.getCOD() + "\"";
		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getType());
			stmt.setInt(3, p.getQuantita());
			stmt.setString(4, p.getFornitore().getPIVA());
			stmt.setDate(5, p.getDataScadenza());
			stmt.executeUpdate();

			stmt.executeUpdate();

			p.setCOD(p.getCOD());
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
