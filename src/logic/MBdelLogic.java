package logic;

import dao.MyBookDAO;

public class MBdelLogic {

	public boolean mbdel(int myBooks_id){
		MyBookDAO dao = new MyBookDAO();
		return dao.mbdel(myBooks_id);
	}
}
