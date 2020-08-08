package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.MBchaLogic;

/**
 * Servlet implementation class TextFavoriteServlet
 */
@WebServlet("/admin/TextFavoriteServlet")
public class TextFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MBchaLogic logic =new MBchaLogic();
		Boolean bool=logic.mbcha(Integer.parseInt(request.getParameter("id")),Boolean.parseBoolean(request.getParameter("favorite")));
		response.getWriter().print(bool);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
