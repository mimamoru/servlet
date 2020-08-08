package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(book);
		if(book!=null) {
			String json = mapper.writeValueAsString(book);
			response.getWriter().print(json);
//			request.setAttribute("book", book);
//			RequestDispatcher dispatch = request.getRequestDispatcher("textOLook.jsp");
//			dispatch.forward(request, response);
		}else {
			response.getWriter().print("{\"id\":0}");
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
