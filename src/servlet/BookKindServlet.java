package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import logic.KupLogic;
import model.Account;
import model.Kind;


@WebServlet("/admin/BookKindServlet")
public class BookKindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		Kind kind=new Kind();
		kind.setAccount_id(account.getId());
		System.out.println("ppp");
		kind.setKind_num(Integer.parseInt(request.getParameter("kind_num")));
		kind.setKind_name(request.getParameter("kind_name"));
		System.out.println(Integer.parseInt(request.getParameter("kind_num")));
		System.out.println(request.getParameter("kind_name"));
//		int order=Integer.parseInt(request.getParameter("order"));
		KupLogic logic =new KupLogic();
		kind =logic.kup(kind);
		ObjectMapper mapper = new ObjectMapper();
		if(kind!=null) {
		String json = mapper.writeValueAsString(kind);
		response.getWriter().print(json);
		}
	}

}