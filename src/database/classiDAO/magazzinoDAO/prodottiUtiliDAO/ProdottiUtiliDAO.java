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
/**
 * permette di fare query sulla tabella prodotti_utili  del database
 * 
 * @author MMA
 * @version 1.0 (current version number of program)
 */
public class ProdottiUtiliDAO implements IProdottiUtiliDAO {
	private DbSingleton db;

	// costruttore
	public ProdottiUtiliDAO() {
		
		super(); 
		db = DbSingleton.getInstance();
	}

	/**
	 * seleziona tutti i prodotti utili presenti nel db
	 * 
	 * @return ArrayList<ProdottiUtili> tutti i prodotti 
	 * utili presenti nel db
	 * 
	 * @exception SQLException  qualcosa è andato storto nel db
	 */
	@Override
	public ArrayList<ProdottiUtili> selectAll() {
		ArrayList<ProdottiUtili> result = new ArrayList<>(); 

		ResultSet rs1;
		
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


	/**
	 * inserisce nuovo prodotto utile nel db
	 * 
	 * @param  p prodotto nuovo da inserire
	 * @return boolean = true se ha avuto successo insert
	 * @exception SQLException qualcosa andato storto inserimento
	 */
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
	
	
	/**
	 * seleziona prodotto a seconda della riga
	 * della tabella grafica che corrisponde
	 * alla riga del db 
	 * @param  rigaselezionata riga selezionata da tabella
	 * @return int COD dell'appuntamento selezionato
	 * @exception SQLException  qualcosa è andato storto nel db
	 */
	@Override
	public int selectCODprodotto(int rigaSelezionata) {

		ResultSet rs1;
		
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

	/**
	 * elimina  nel db prodotto selezionata tramite cod
	 * 
	 * @param  cod	 del prodotto da eliminare
	 * @return void
	 * @exception SQLException  qualcosa è andato storto nel delete
	 */
	@Override
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


	/**
	 * aggiorna nel db prodotto utile selezionato
	 * 
	 * @param  p prodotto da aggiornare
	 * @return void
	 * @exception SQLException qualcosa andato storto inserimento
	 */
	@Override
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

}
