package magazzino.farmaci;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionSQL.DbSingleton;
import grafica.PopupError;

public class LottoFarmaciDAO implements ILottoFarmaciDAO {

	private DbSingleton db;

	public LottoFarmaciDAO() {
		super();
	}

	public ArrayList<LottoFarmaci> selectAll() {
		ArrayList<LottoFarmaci> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM FARMACI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				LottoFarmaci f = new LottoFarmaci(rs1.getString(1), rs1.getString(2), rs1.getString(3),
						rs1.getString(4), rs1.getDate(5), rs1.getInt(6));

				result.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<LottoFarmaci> getFarmaciScadenza() {

		ArrayList<LottoFarmaci> farmaciScadenza = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM FARMACI WHERE MONTH(SCADENZA) = MONTH(CURRENT_TIMESTAMP) AND YEAR(SCADENZA) = \n"
					+ "YEAR(current_timestamp())";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				LottoFarmaci f = new LottoFarmaci(rs1.getString(1), rs1.getString(2), rs1.getString(3),
						rs1.getString(4), rs1.getDate(5), rs1.getInt(6));

				farmaciScadenza.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return farmaciScadenza;
	}

	@Override
	public boolean insertFarmaci(LottoFarmaci f) {

		String query = "INSERT INTO FARMACI (LOTTO,MODASSUNZIONE,TIPO_FARMACO,PIVA,SCADENZA,QTA) values (?, ?, ?, ?, ?, ?);";

		PreparedStatement stmt = null;

		try {

			stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, f.getIDLotto());
			stmt.setString(2, f.getMode());
			stmt.setString(3, f.getType());
			stmt.setString(4, f.getFornitore().getPIVA().toString()); 
			stmt.setDate(4, (Date) f.getDataScadenza());
			stmt.setInt(5, f.getQuantita());
			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
			PopupError.infoBox("Esiste già un lotto con questo numero", "ERRORE");
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

		LottoFarmaciDAO fdao = new LottoFarmaciDAO();

		ArrayList<LottoFarmaci> res = fdao.selectAll();

		for (LottoFarmaci r : res)
			System.out.println(r.toString());
	}

	@Override
	public boolean insertLottoFarmaci(LottoFarmaci f) {
		// TODO Auto-generated method stub
		return false;
	}
}
