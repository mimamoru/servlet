package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.BoneLogic;
import logic.MBinsLogic;
import model.Account;
import model.Book;
import model.MyBook;

/**
 * Servlet implementation class TextKeepServlet
 */
@WebServlet("/admin/TextKeepServlet")
public class TextKeepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//mybookへ保存
	String[] book_ids=request.getParameterValues("book_ids[]");

	System.out.println(book_ids.length);
	HttpSession session=request.getSession();
	Account account=(Account)session.getAttribute("account");
	int account_id=account.getId();
	BoneLogic logic1 =new BoneLogic();
	MBinsLogic logic2 =new MBinsLogic();
	List<MyBook> myBooks=new ArrayList<MyBook>();
	MyBook myBook=null;
	Book book=null;
	for(String bid :book_ids) {
		int book_id=Integer.parseInt(bid);
		book=logic1.bone(book_id);
		if(book!=null) {
		myBook=new MyBook();
		myBook.setAccount_id(account_id);
		myBook.setBook_id(book_id);
		myBook.setTitle(book.getTitle());
		myBook.setText(book.getText());
		myBook.setModified(book.getModified().toLocalDate());
		myBook.setFavorite(false);
		myBook.setKind_num(0);

		myBook =logic2.mbins(myBook);
		myBooks.add(myBook);
		}
	}

	if(myBooks.size()==0) {

		response.getWriter().print("{\"msg\": \"fail\"}");
	}else{
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(myBooks);
		response.getWriter().print("{\"msg\": \"success\"}");
	}
}
}

