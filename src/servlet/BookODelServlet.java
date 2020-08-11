package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.BRdelLogic;
import logic.OBdisLogic;

/**
 * Servlet implementation class BookOServlet
 */
@WebServlet("/admin/BookODelServlet")
public class BookODelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ob_ids = request.getParameterValues("ob_ids[]");
		int ob_id;
		BRdelLogic logic1 =new BRdelLogic();
		OBdisLogic logic2 =new OBdisLogic();
		for(String obid:ob_ids) {
			ob_id=Integer.parseInt(obid);
			System.out.println(ob_id+"***");
			logic1.brdel(ob_id);
			logic2.obdis(ob_id);
		}

	}

}
