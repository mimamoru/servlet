package logic;

import dao.OurBookDAO;

public class OBcheLogic {

	public int obche(String name,String pass){
		OurBookDAO dao = new OurBookDAO();
		return dao.obche(name,pass);
	}
}
