package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.MBchaLogic;

/**
 * Servlet implementation class TextLikeServlet
 */
@WebServlet("/admin/TextTypeServlet")
public class TextTypeServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MBchaLogic logic =new MBchaLogic();
		Boolean bool=logic.mbcha(Integer.parseInt(request.getParameter("id")),Integer.parseInt(request.getParameter("num")));
		response.getWriter().print(bool);
	}

}
