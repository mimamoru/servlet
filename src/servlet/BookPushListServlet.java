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

import logic.MBallLogic;
import model.MyBook;

/**
 * Servlet implementation class BookPushServlet
 */
@WebServlet("/admin/BookPushListServlet")
public class BookPushListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TextM
		List<MyBook> myBooks = new ArrayList<MyBook>();
		MBallLogic logic =new MBallLogic();
		myBooks=logic.mball("",0,0);
		request.setAttribute("myBooks", myBooks);
		RequestDispatcher dispatch = request.getRequestDispatcher("bookPush.jsp");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MyBook> myBooks = new ArrayList<MyBook>();
		MBallLogic logic =new MBallLogic();
		myBooks=logic.mball(request.getParameter("like"),Integer.parseInt(request.getParameter("order")),0);
		request.setAttribute("myBooks", myBooks);
		RequestDispatcher dispatch = request.getRequestDispatcher("bookPush.jsp");
		dispatch.forward(request, response);
	}

}
