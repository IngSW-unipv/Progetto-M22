package database.classiDAO.loginDAO;

public interface ILoginDAO {
	
	public boolean isMatching(String user, String password);
	
	public String getCFuserLoggedIn(String user, String password);
	
	public void insertNuovoUtente(String user, String password, String CFdip) ;

}
