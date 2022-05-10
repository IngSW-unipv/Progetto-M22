package appuntamenti.visite;

import java.util.ArrayList;

public interface IAppuntamentiDAO {
	
	public ArrayList<Appuntamenti> selectAll();

	public boolean insertAppuntamenti(Appuntamenti v);
}
