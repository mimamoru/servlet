package logic;

import dao.BookDAO;
import model.Book;

public class BinsLogic {

	public int bins(Book book) {
		BookDAO dao = new BookDAO();
		return dao.bins(book);
	}
}
