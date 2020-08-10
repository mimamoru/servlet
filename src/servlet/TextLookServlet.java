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
import logic.MBoneLogic;
import model.Account;
import model.Kind;
import model.MyBook;

/**
 * Servlet implementation class TextLookServlet
 */
@WebServlet("/admin/TextLookServlet")
public class TextLookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
    	List<Kind> kinds = new ArrayList<Kind>();
		KallLogic logic1 =new KallLogic();
		kinds=logic1.kall(account.getId());
		request.setAttribute("kinds", kinds);
		int kind_num=Integer.parseInt(request.getParameter("kind_num"));
		System.out.println(kind_num);
		request.setAttribute("kind_num", kind_num);
		MyBook myBook = new MyBook();
		MBoneLogic logic2 =new MBoneLogic();
		myBook=logic2.mbone(Integer.parseInt(request.getParameter("id")));
		if(myBook!=null) {
			request.setAttribute("myBook", myBook);
			RequestDispatcher dispatch = request.getRequestDispatcher("textLook.jsp");
			dispatch.forward(request, response);
		}
//		Book book = new Book();
//		BoneLogic logic2 =new BoneLogic();
//		book=logic2.bone(Integer.parseInt(request.getParameter("id")));
//		if(book!=null) {
//			request.setAttribute("book", book);
//			RequestDispatcher dispatch = request.getRequestDispatcher("textLook.jsp");
//			dispatch.forward(request, response);
//		}
//		ObjectMapper mapper = new ObjectMapper();
//		if(book!=null) {
//			String json = mapper.writeValueAsString(book);
//			response.getWriter().print(json);
//		}else {
//			response.getWriter().print("{msg:"+ "テキストの取得に失敗しました"+"}");
//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
