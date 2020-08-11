package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.BRinsLogic;

/**
 * Servlet implementation class BookPushServlet
 */
@WebServlet("/admin/BookPushServlet")
public class BookPushServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ob_id = Integer.parseInt(request.getParameter("ob_id"));
		String[] b_ids = request.getParameterValues("b_ids[]");
		BRinsLogic logic =new BRinsLogic();
//		System.out.println(ob_id+"**jb*");
//		System.out.println(b_ids[0]+"**hj*");
		int book_id;
		for(String bid:b_ids) {
			book_id=Integer.parseInt(bid);
			logic.brins(book_id, ob_id);
		}

	}

}