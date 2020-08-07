package logic;

import dao.MyBookDAO;
import model.MyBook;

public class MBoneLogic {

	public MyBook mbone(int id) {
		MyBookDAO dao = new MyBookDAO();
		return dao.mbone(id);
	}
}
