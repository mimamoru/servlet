package logic;

import dao.MyBookDAO;
import model.MyBook;

public class MBinsLogic {

	public MyBook mbins(MyBook myBook) {
		MyBookDAO dao = new MyBookDAO();
		return dao.mbins(myBook);
	}
}
