package anagrafica.veterinari;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionSQL.ConnectionSQL;
import ConnectionSQL.DbSingleton;

public class VeterinariDAO implements IVeterinariDAO {

	private DbSingleton db;

	public VeterinariDAO() {
		super();
//				conn=DBConnection.startConnection(conn,schema);
	}

	public ArrayList<Veterinari> selectAll() {
		ArrayList<Veterinari> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * FROM DIPENDENTI";
			rs1 = db.executeQuery(query);
			while (rs1.next()) {
				Veterinari v = new Veterinari(rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9),
						rs1.getDouble(10), rs1.getDouble(11), rs1.getString(12));

				result.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void insertVeterinari(Veterinari vet) {

		String query = "INSERT INTO DIPENDENTI (NOME,COGNOME,CF_DIP,EMAIL,TELEFONO,CITTA,"
				+ "INDIRIZZO,PIVA,TIPO_DI_CONTRATTO,STIPENDIO,COMMISS,IBAN) values (?, ?, ?, ?, ?, ?, ? , ?, ?, ?, ?, ?);";
		try {

			PreparedStatement stmt = db.getConnection().prepareStatement(query);

			stmt.setString(1, vet.getNome());
			stmt.setString(2, vet.getCognome());
			stmt.setString(3, vet.getCF());
			stmt.setString(4, vet.getEmail());
			stmt.setString(5, vet.getCellulare());
			stmt.setString(6, vet.getCitta());
			stmt.setString(7, vet.getIndirizzo());
			stmt.setString(8, vet.getPIVA());
			stmt.setString(9, vet.getContratto());
			stmt.setDouble(10, vet.getStipendio());
			stmt.setDouble(11, vet.getCommissioni());
			stmt.setString(12, vet.getIBAN());
			stmt.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public void deleteVeterinari(String CF) {

		String query = "delete from DIPENDENTI where CF_DIP=\"" + CF + "\"";
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
	


	public static class Engine1 {

		public static void main(String[] args) {

			VeterinariDAO vdao = new VeterinariDAO();

			ArrayList<Veterinari> res = vdao.selectAll();

			for (Veterinari r : res)
				System.out.println(r.toString());

			vdao.deleteVeterinari("00");

			// Veterinari vet1 = new Veterinari("peppe", "denico", "00", "@", "cell",
			// "citta", "indirizzo", "pivs",
			// "contratto", 300, 900, "iban");

			// vdao.insertVeterinari(vet1);

			Connection connection = null;
			ConnectionSQL.closeConnection(connection);

		}

	}

}
