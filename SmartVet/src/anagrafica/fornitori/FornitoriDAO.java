package anagrafica.fornitori;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectionSQL.ConnectionSQL;

public class FornitoriDAO implements IFornitoriDAO {

	private String schema;
	private Connection conn;

	public FornitoriDAO() {
		super();
		this.schema = "clinica";
//			conn=DBConnection.startConnection(conn,schema);
	}

	public ArrayList<Fornitori> selectAll() {
		ArrayList<Fornitori> result = new ArrayList<>();

		conn = ConnectionSQL.startConnection(conn, schema);
		Statement st1;
		ResultSet rs1;

		try {
			st1 = conn.createStatement();
			String query = "SELECT * from FORNITORI";
			rs1 = st1.executeQuery(query);

			while (rs1.next()) {
				Fornitori f = new Fornitori(rs1.getString(2), rs1.getString(1), rs1.getString(3), 
						rs1.getString(4), rs1.getString(5), query);

				result.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionSQL.closeConnection(conn);
		return result;
	}

	@Override
	public boolean insertFornitore(Fornitori f) {
		// TODO Auto-generated method stub
		return false;
	}
	 	public ArrayList<Fornitori> selectByCitta(Fornitori fornInput) {
		ArrayList<Fornitori> result = new ArrayList<>();

		conn = ConnectionSQL.startConnection(conn, schema);
		PreparedStatement st1;
		ResultSet rs1;

		try {
			String query = "SELECT * FROM FORNITORI WHERE CITTA=?";

			// "SELECT * FROM FORNITORE WHERE CITTA='"+fornInput.getCitta()+"'"

			// 'OR 1=1

			// "SELECT * FROM FORNITORE WHERE CITTA='

			st1 = conn.prepareStatement(query);
			st1.setString(1, fornInput.getCitta());

			rs1 = st1.executeQuery(query);

			while (rs1.next()) {
				Fornitori f = new Fornitori(rs1.getString(1), rs1.getString(2), rs1.getString(3));

				result.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		DBConnection.closeConnection(conn);
		return result;
	}

	public boolean insertFornitori(Fornitori f) {

		conn = DBConnection.startConnection(conn, schema);
		PreparedStatement st1;

		boolean esito = true;

		try {
			String query = "INSERT INTO FORNITORI (COD,NOME,CITTA) VALUES(?,?,?)";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getCod());
			st1.setString(2, f.getNome());
			st1.setString(3, f.getCitta());

			st1.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
			esito = false;
		}

		DBConnection.closeConnection(conn);
		return esito;

	}

	@Override
	public boolean insertFornitore(Fornitori f) {
		// TODO Auto-generated method stub
		return false;
	}
	

}

