package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import logic.AoneLogic;
import model.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			HttpSession session=request.getSession(false);
			if(session!=null) {
			session.invalidate();
			}
			response.sendRedirect("/TextRegister");
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account = new Account();
		account.setName(request.getParameter("name"));
		account.setPass(request.getParameter("pass"));
		AoneLogic logic =new AoneLogic();
		account=logic.aone(account);
		if(account!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("account", account);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(account);
			response.getWriter().print(json);

			}
//		else {
//			response.getWriter().print("{msg:"+ "ログインに成功しました"+"}");
		//}

	}

}
