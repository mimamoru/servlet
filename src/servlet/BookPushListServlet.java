package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.MBallLogic;
import logic.OBallLogic;
import model.Account;
import model.MyBook;
import model.OurBook;

/**
 * Servlet implementation class BookPushServlet
 */
@WebServlet("/admin/BookPushListServlet")
public class BookPushListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TextM
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		int account_id=account.getId();
		//int kind=Integer.parseInt(request.getParameter("kind"));
		List<MyBook> myBooks = new ArrayList<MyBook>();
		MBallLogic logic1 =new MBallLogic();
		myBooks=logic1.mball(account_id,0);
		request.setAttribute("myBooks", myBooks);
		OBallLogic logic2 =new OBallLogic();
		List<OurBook> ourBooks=logic2.oball(account);
		request.setAttribute("ourBooks", ourBooks);
		RequestDispatcher dispatch = request.getRequestDispatcher("bookPush.jsp");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<MyBook> myBooks = new ArrayList<MyBook>();
//		MBallLogic logic =new MBallLogic();
//		myBooks=logic.mball(request.getParameter("like"),Integer.parseInt(request.getParameter("order")),0);
//		request.setAttribute("myBooks", myBooks);
//		RequestDispatcher dispatch = request.getRequestDispatcher("bookPush.jsp");
//		dispatch.forward(request, response);
	}

}