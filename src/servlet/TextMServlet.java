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
import logic.KoneLogic;
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
		int account_id=account.getId();
    	List<Kind> kinds = new ArrayList<Kind>();
		KallLogic logic2 =new KallLogic();
		kinds=logic2.kall(account_id);
		request.setAttribute("kinds", kinds);
		//System.out.println(request.getParameter("kind_num"));
		int kind_num=Integer.parseInt(request.getParameter("kind_num"));
		myBooks=logic1.mball(account_id,kind_num);
		KoneLogic logic3 =new KoneLogic();
		String kind_name=logic3.kone(account_id,kind_num);
		System.out.println(kind_name);
		if(myBooks==null) {
			myBooks = new ArrayList<MyBook>();
		}
		request.setAttribute("kind_num", kind_num);
		request.setAttribute("kind_name", kind_name);
//		request.setAttribute("like", "");
//		request.setAttribute("order", 0);
			request.setAttribute("myBooks", myBooks);
			RequestDispatcher dispatch = request.getRequestDispatcher("textM.jsp");
			dispatch.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<MyBook> myBooks = new ArrayList<MyBook>();
//		MBallLogic logic1 =new MBallLogic();
//		HttpSession session=request.getSession();
//		Account account=(Account)session.getAttribute("account");
//    	List<Kind> kinds = new ArrayList<Kind>();
//		KallLogic logic2 =new KallLogic();
//		kinds=logic2.kall(account.getId());
//		request.setAttribute("kinds", kinds);
//		int kind_num=Integer.parseInt(request.getParameter("kind_num"));
//		int order=Integer.parseInt(request.getParameter("order"));
//		String like=request.getParameter("like");
//		myBooks=logic1.mball(like,order,kind_num);
//		if(myBooks==null) {
//			myBooks = new ArrayList<MyBook>();
//		}
////		ObjectMapper mapper = new ObjectMapper();
////		String json = mapper.writeValueAsString(myBooks);
//// 		response.getWriter().print(json);
//		request.setAttribute("kind_num", kind_num);
//		request.setAttribute("like", like);
//		request.setAttribute("order", order);
//			request.setAttribute("myBooks", myBooks);
//			RequestDispatcher dispatch = request.getRequestDispatcher("textM.jsp");
//			dispatch.forward(request, response);


	}

}