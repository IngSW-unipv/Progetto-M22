package database.classiDAO.magazzinoDAO.farmaciDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.classiDAO.anagraficaDAO.fornitoriDAO.FornitoriDAO;
import database.connectionSQL.DbSingleton;
import model.anagrafica.fornitori.Fornitori;
import model.magazzino.farmaci.LottoFarmaci;

public class LottoFarmaciDAO implements ILottoFarmaciDAO {

	private DbSingleton db;

	public LottoFarmaciDAO() {
		super();
		db = DbSingleton.getInstance();
	} 

	@Override
	public ArrayList<LottoFarmaci> selectAll() {
		ArrayList<LottoFarmaci> result = new ArrayList<>();

		ResultSet rs1;
		

		try {
			String query = "SELECT * FROM FARMACI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				FornitoriDAO forn = new FornitoriDAO();
				String PIVA_Fornitore = rs1.getString(4);

				Fornitori fornitore = forn.select_Forn(PIVA_Fornitore);

				LottoFarmaci f = new LottoFarmaci(rs1.getString(1), rs1.getString(2), rs1.getString(3), fornitore,
						rs1.getDate(5), rs1.getInt(6));

				result.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	@Override
	public ArrayList<LottoFarmaci> getFarmaciScadenza() {

		ArrayList<LottoFarmaci> farmaciScadenza = new ArrayList<>();

		ResultSet rs1;
	

		try {
			String query = "SELECT * FROM FARMACI WHERE MONTH(SCADENZA) = MONTH(CURRENT_TIMESTAMP) AND YEAR(SCADENZA) = \n"
					+ "YEAR(current_timestamp())";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {

				FornitoriDAO forn = new FornitoriDAO();
				String PIVA_Fornitore = rs1.getString(4);

				Fornitori fornitore = forn.select_Forn(PIVA_Fornitore);

				LottoFarmaci f = new LottoFarmaci(rs1.getString(1), rs1.getString(2), rs1.getString(3), fornitore,
						rs1.getDate(5), rs1.getInt(6));

				farmaciScadenza.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return farmaciScadenza;
	}

	@Override
	public boolean insertFarmaci(LottoFarmaci f) {

		String query = "INSERT INTO FARMACI (LOTTO,MODASSUNZ,TIPOFARMACI,PIVA,SCADENZA,QTA) values (?, ?, ?, ?, ?, ?);";

		PreparedStatement stmt = null;

		try {
			

			stmt = db.getConnection().prepareStatement(query); 

			stmt.setString(1, f.getIDLotto());
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

	
	@Override
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

}
