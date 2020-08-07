package logic;

import dao.OurBookDAO;

public class OBinsLogic {

	public int obins(String name,String pass,int owner_id){
		OurBookDAO dao = new OurBookDAO();
		return dao.obins(name,pass,owner_id);
	}
}
