package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.KallLogic;
import logic.KupLogic;
import model.Account;
import model.Kind;


@WebServlet("/admin/BookMainServlet")
public class BookMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
    	List<Kind> kinds = new ArrayList<Kind>();
		KallLogic logic =new KallLogic();
		kinds=logic.kall(account.getId());
		request.setAttribute("kinds", kinds);
		RequestDispatcher dispatch = request.getRequestDispatcher("bookMain.jsp");
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		Kind kind = new Kind();
		kind.setKind_num(Integer.parseInt(request.getParameter("kind_num")));
		kind.setAccount_id(account.getId());
		kind.setKind_name(request.getParameter("kind_name"));
		KupLogic logic =new KupLogic();
		kind=logic.kup(kind);
		response.getWriter().print(kind.getKind_name());

	}

}
