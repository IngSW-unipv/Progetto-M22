package appuntamenti.visite;

import java.util.ArrayList;

public interface IVisiteDAO {
	
	public ArrayList<Visite> selectAll();

	public boolean insertVisite(Visite v);
}
