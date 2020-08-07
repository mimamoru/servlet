package logic;

import dao.BookRelationDAO;

public class BRdelLogic {

	public void brdel(int ob_id) {
		BookRelationDAO dao = new BookRelationDAO();
		dao.brdel(ob_id);
	}

}
