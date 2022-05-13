package anagrafica.fornitori;

import java.util.ArrayList;

public class Engine {

	public static void main(String[] args) {

		FornitoriDAO fdao = new FornitoriDAO();

		ArrayList<Fornitori> res = fdao.selectAll();

		for (Fornitori r : res)
			System.out.println(r.toString());
	}

}
