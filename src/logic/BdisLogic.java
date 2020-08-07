package logic;

import dao.BookDAO;

public class BdisLogic {

	public boolean bdis(int book_id) {
		BookDAO dao = new BookDAO();
		return dao.bdis(book_id);
	}
}
