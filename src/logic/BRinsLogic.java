package logic;

import dao.BookRelationDAO;

public class BRinsLogic {

	public void brins(int b_id,int ob_id) {
		BookRelationDAO dao = new BookRelationDAO();
		dao.brins(b_id,ob_id);
	}
}
