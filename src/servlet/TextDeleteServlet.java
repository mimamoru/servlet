package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.BdisLogic;
import logic.BoneLogic;
import logic.MBdelLogic;
import model.Account;

/**
 * Servlet implementation class TextDeleteServlet
 */
@WebServlet("/admin/TextDeleteServlet")
public class TextDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] book_ids=request.getParameterValues("book_id");
		String[] myBook_ids=request.getParameterValues("myBook_id");
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		int account_id=account.getId();
		int book_id;
		int auther_id;
		BoneLogic logic1 =new BoneLogic();
		int myBook_id;
		for(int i=0; i<book_ids.length; i++) {
		   book_id=Integer.parseInt(book_ids[i]);
		   myBook_id=Integer.parseInt(myBook_ids[i]);
		   auther_id=logic1.bone(book_id).getAuther_id();
		   if(account_id==auther_id) {
			   BdisLogic logic2 =new BdisLogic();
			   logic2.bdis(book_id);
		   }
		   MBdelLogic logic3 =new MBdelLogic();
		   logic3.mbdel(myBook_id);
		}


	}

}
