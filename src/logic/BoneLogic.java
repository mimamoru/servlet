package logic;

import dao.BookDAO;
import model.Book;

public class BoneLogic {

	public Book bone(int id) {
		BookDAO dao = new BookDAO();
		return dao.bone(id);
	}
}
