package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
														throws ServletException, IOException {

		try {
			HttpSession session=request.getSession(false);
			if(session!=null) {
			session.invalidate();
			}
			response.sendRedirect("/TextRegister");

		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}


}
