package anagrafica.fornitori;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionSQL.DbSingleton;
import anagrafica.clienti.Clienti;
import anagrafica.clienti.ClientiDAO;
import grafica.PopupError;

public class FornitoriDAO implements IFornitoriDAO {

	private DbSingleton db;

	public FornitoriDAO() {
		super();
	}

	public ArrayList<Fornitori> selectAll() {
		ArrayList<Fornitori> result = new ArrayList<>();

		ResultSet rs1;
		db = DbSingleton.getInstance();

		try {
			String query = "SELECT * from FORNITORI";
			rs1 = db.executeQuery(query);

			while (rs1.next()) {
				Fornitori fo = new Fornitori( rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(5), rs1.getString(6));
				
				result.add(fo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean insertFornitore(Fornitori fo) {
		
		/*System.out.println(fo.getPIVA());
	  if(fo.getPIVA() == "") {
		  PopupError.infoBox("Inserire PIVA", "ERRORE");
			return false;
		  
	  }else {*/
		
		System.out.println("passo2");
		
		String query = "INSERT INTO FORNITORI (PIVA,AZIENDA,TELEFONO,EMAIL,CITTA,IBAN)"
				 +"values (?, ?, ?, ?, ?, ?);";
		
		PreparedStatement stmt = null;
		
		System.out.println("passo3");
		try {
			
			stmt = db.getConnection().prepareStatement(query);
			
			stmt.setString(1, fo.getPIVA());
			stmt.setString(2, fo.getNomeAzienda());
			stmt.setString(3, fo.getnTelefono());
			stmt.setString(4, fo.getEmail());
			stmt.setString(5, fo.getSede());
			stmt.setString(6, fo.getIBAN());
			stmt.executeUpdate();
			return true;
			
		}
		
		catch (SQLException e) {
			System.out.println("passo0");
			e.printStackTrace();
			PopupError.infoBox("Esiste già  un cliente con questo CODF", "ERRORE");
			return false;
		}
	  //}
	} 

	public void deletefornitori(Fornitori fo) {
		String PIVA = fo.getPIVA();
		String query = "delete from FORNITORI where PIVA=\"" + PIVA + "\"";
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
		
	/*public static class Engine2 {

		public static void main(String[] args) {

			FornitoriDAO cdao = new FornitoriDAO();

			ArrayList<Fornitori> res = cdao.selectAll();

			for (Fornitori r : res)
				System.out.println(r.toString());
		}
	  }*/
	}

}
	
