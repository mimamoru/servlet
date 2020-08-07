package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.BoneLogic;
import model.Book;

/**
 * Servlet implementation class TextLookServlet
 */
@WebServlet("/admin/TextOLookServlet")
public class TextOLookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Book book = new Book();
		BoneLogic logic2 =new BoneLogic();
		book=logic2.bone(Integer.parseInt(request.getParameter("id")));
		if(book!=null) {
			request.setAttribute("book", book);
			RequestDispatcher dispatch = request.getRequestDispatcher("textOLook.jsp");
			dispatch.forward(request, response);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
