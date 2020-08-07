package logic;

import dao.MyBookDAO;
import model.MyBook;

public class MBupLogic {

	public MyBook mbup(MyBook myBook) {
		MyBookDAO dao = new MyBookDAO();
		return dao.mbup(myBook);
	}
}
