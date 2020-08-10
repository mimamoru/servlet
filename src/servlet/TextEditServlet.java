package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import logic.BoneLogic;
import logic.BupLogic;
import logic.MBupLogic;
import model.Account;
import model.Book;
import model.MyBook;

/**
 * Servlet implementation class TextEditServlet
 */
@WebServlet("/admin/TextEditServlet")
public class TextEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		int account_id=account.getId();
		int book_id=Integer.parseInt(request.getParameter("book_id"));
		BoneLogic logic1 =new BoneLogic();
		int auther_id=logic1.bone(book_id).getAuther_id();
		String title=request.getParameter("title");
		String text=request.getParameter("text");
		LocalDate date=LocalDate.now();
		if(account_id==auther_id) {
			book.setTitle(title);
			book.setText(text);
			book.setModified(date);
			BupLogic logic2 =new BupLogic();
			logic2.bup(book);
		}

		MBupLogic logic3 =new MBupLogic();
		MyBook myBook=new MyBook();
			myBook.setId(Integer.parseInt(request.getParameter("id")));
			myBook.setAccount_id(account_id);
			myBook.setBook_id(book_id);
			myBook.setTitle(title);
			myBook.setText(text);
			myBook.setModified(date);
			System.out.println(myBook);
			myBook=logic3.mbup(myBook);

			ObjectMapper mapper = new ObjectMapper();
			if(myBook!=null) {
				String json = mapper.writeValueAsString(myBook);
				response.getWriter().print(json);
			}else {
			response.getWriter().print("{\"id\":0}");
		}
	}

}
