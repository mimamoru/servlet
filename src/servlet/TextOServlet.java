package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.OBoneLogic;
import model.OurBook;

/**
 * Servlet implementation class TextOServlet
 */
@WebServlet("/TextOServlet")
public class TextOServlet extends HttpServlet {
	//tukawanai?
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OurBook ourBook = new OurBook();
		OBoneLogic logic =new OBoneLogic();
		ourBook=logic.obone(Integer.parseInt(request.getParameter("id")));
		if(ourBook!=null) {
		request.setAttribute("ourBook", ourBook);
		RequestDispatcher dispatch = request.getRequestDispatcher("textO.jsp");
		dispatch.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
