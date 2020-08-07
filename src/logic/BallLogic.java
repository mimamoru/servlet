package logic;

import java.util.List;

import dao.BookDAO;
import model.Book;

public class BallLogic {

	public List<Book> ball() {
		BookDAO dao = new BookDAO();
		return dao.ball();
	}
}
