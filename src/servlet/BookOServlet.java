package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import logic.OBallLogic;
import model.Account;
import model.OurBook;

/**
 * Servlet implementation class BookOServlet
 */
@WebServlet("/admin/BookOServlet")
public class BookOServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		OBallLogic logic =new OBallLogic();
		List<OurBook> ourBooks=logic.oball(account);
		System.out.println(ourBooks.size());
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ourBooks);
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session=request.getSession();
//		Account account=(Account)session.getAttribute("account");
//		int order=Integer.parseInt(request.getParameter("order"));
//		OBallLogic logic =new OBallLogic();
//		List<OurBook> ourBooks=logic.oball(account,order);
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(ourBooks);
//		response.getWriter().print(json);


	}

}
