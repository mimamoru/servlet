package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.BRdelLogic;
import logic.OBcheLogic;
import logic.OBdisLogic;
import logic.OBinsLogic;
import logic.OBoneLogic;
import model.Account;
import model.OurBook;

/**
 * Servlet implementation class BookPushServlet
 */
@WebServlet("/admin/BookPushConfServlet")
public class BookPushConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ourbook作成
		String ob_name = request.getParameter("name");
		String ob_pass = request.getParameter("pass");
		OBcheLogic logic1 =new OBcheLogic();
		OBoneLogic logic2 =new OBoneLogic();
		BRdelLogic logic3 =new BRdelLogic();
		OBdisLogic logic4 =new OBdisLogic();
		OBinsLogic logic5 =new OBinsLogic();
		int ob_id=logic1.obche(ob_name, ob_pass);
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		System.out.println(ob_id);
		if(ob_id>0) {
			OurBook ourBook=logic2.obone(ob_id);
			if(ourBook==null) {
				logic3.brdel(ob_id);
				logic4.obdis(ob_id);
				ob_id=logic1.obche(ob_name, ob_pass);
			}
		}
		int obid=0;

		if(ob_id==0) {
			obid=logic5.obins(ob_name, ob_pass,account.getId());
		}
		System.out.println(obid+"***");
		response.getWriter().print("{\"ob_id\": "+obid+"}");
	}

}
