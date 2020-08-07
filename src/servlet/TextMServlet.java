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
import logic.MBallLogic;
import model.Account;
import model.Kind;
import model.MyBook;

/**
 * Servlet implementation class TextMServlet
 */
@WebServlet("/admin/TextMServlet")
public class TextMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MyBook> myBooks = new ArrayList<MyBook>();
		MBallLogic logic1 =new MBallLogic();
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
    	List<Kind> kinds = new ArrayList<Kind>();
		KallLogic logic2 =new KallLogic();
		kinds=logic2.kall(account.getId());
		request.setAttribute("kinds", kinds);
		System.out.println(request.getParameter("kind_num"));
		myBooks=logic1.mball("",0,Integer.parseInt(request.getParameter("kind_num")));
		if(myBooks==null) {
			myBooks = new ArrayList<MyBook>();
		}
			request.setAttribute("myBooks", myBooks);
			RequestDispatcher dispatch = request.getRequestDispatcher("textM.jsp");
			dispatch.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MyBook> myBooks = new ArrayList<MyBook>();
		MBallLogic logic1 =new MBallLogic();
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
    	List<Kind> kinds = new ArrayList<Kind>();
		KallLogic logic2 =new KallLogic();
		kinds=logic2.kall(account.getId());
		request.setAttribute("kinds", kinds);
		myBooks=logic1.mball(request.getParameter("like"),Integer.parseInt(request.getParameter("order")),Integer.parseInt(request.getParameter("kind_num")));
		if(myBooks==null) {
			myBooks = new ArrayList<MyBook>();
		}
			request.setAttribute("myBooks", myBooks);
			RequestDispatcher dispatch = request.getRequestDispatcher("textM.jsp");
			dispatch.forward(request, response);


	}

}
