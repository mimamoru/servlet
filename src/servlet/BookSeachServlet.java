package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.OBcheLogic;
import logic.OBoneLogic;
import model.OurBook;

/**
 * Servlet implementation class TextSeachServlet
 */
@WebServlet("/admin/BookSeachServlet")
public class BookSeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ob_name = request.getParameter("name");
		String ob_pass = request.getParameter("pass");
		OBcheLogic logic1 =new OBcheLogic();
		OBoneLogic logic2 =new OBoneLogic();
//		BRdelLogic logic3 =new BRdelLogic();
//		OBdisLogic logic4 =new OBdisLogic();
		int ob_id=logic1.obche(ob_name, ob_pass);
		if(ob_id>0) {
			OurBook ourBook=logic2.obone(ob_id);
//			if(ourBook.getOBooks().size()==0) {
//				logic3.brdel(ob_id);
//				logic4.obdis(ob_id);
//				response.getWriter().print("{\"id\":0}");
//			}else {
//				ObjectMapper mapper = new ObjectMapper();
//				String json = mapper.writeValueAsString(ourBook.getId());
				System.out.println("{\"id\":"+ourBook.getId()+"}");
				response.getWriter().print("{\"id\":"+ourBook.getId()+"}");
//			}
		}else {
		response.getWriter().print("{\"id\":0}");
		}

	}

}