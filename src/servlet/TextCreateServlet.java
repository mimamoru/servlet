package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import logic.BinsLogic;
import logic.KallLogic;
import logic.MBinsLogic;
import model.Account;
import model.Book;
import model.Kind;
import model.MyBook;

/**
 * Servlet implementation class TextCreateServlet
 */
@WebServlet("/admin/TextCreateServlet")
public class TextCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		KallLogic logic =new KallLogic();
		List<Kind> kinds =logic.kall(account.getId());
		request.setAttribute("kinds", kinds);
		RequestDispatcher dispatch = request.getRequestDispatcher("textCreate.jsp");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		int id=account.getId();
		String title=request.getParameter("title");
		String text=request.getParameter("text");
		LocalDate date=LocalDate.now();
		book.setTitle(title);
		book.setText(text);
		book.setModified(date);
		book.setAuther_id(id);
		book.setVisible(true);

		BinsLogic logic1 =new BinsLogic();
		int book_id=logic1.bins(book);
		if(book_id>0) {
			MyBook myBook=new MyBook();
			myBook.setAccount_id(id);
			myBook.setBook_id(book_id);
			myBook.setTitle(title);
			myBook.setText(text);
			myBook.setModified(date);
			myBook.setFavorite(Boolean.parseBoolean(request.getParameter("favorite")));
			myBook.setKind_num(Integer.parseInt(request.getParameter("kind_num")));
			MBinsLogic logic2 =new MBinsLogic();
			myBook=logic2.mbins(myBook);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(myBook);
			response.getWriter().print(json);
			}else {
			response.getWriter().print("{\"id\": 0}");
		}
	}

}
