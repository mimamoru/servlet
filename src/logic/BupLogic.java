package logic;

import dao.BookDAO;
import model.Book;

public class BupLogic {


	public Book bup(Book book) {
		BookDAO dao = new BookDAO();
		return dao.bup(book);
}

}
