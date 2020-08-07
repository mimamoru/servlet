package logic;

import dao.OurBookDAO;

public class OBdisLogic {

	public boolean obdis(int ob_id){
		OurBookDAO dao = new OurBookDAO();
		return dao.obdis(ob_id);
	}
}
