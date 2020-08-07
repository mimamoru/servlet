package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.AinsLogic;
import logic.AoneLogic;
import logic.KinsLogic;
import model.Account;
import model.Kind;


@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		AinsLogic logic1 =new AinsLogic();

		//HttpSession session=request.getSession();
		if(logic1.ains(account)) {
			AoneLogic logic2 =new AoneLogic();
			KinsLogic logic3 =new KinsLogic();
			account=logic2.aone(account);
			List<Kind> kinds =logic3.kins(account);
			if(kinds.size()>0) {
			//session.setAttribute("account", account);
//			ObjectMapper mapper = new ObjectMapper();
//			String json1 = mapper.writeValueAsString(account);
//			String json2 = mapper.writeValueAsString(kinds);
			response.getWriter().print("{msg:"+ "登録が完了しました"+"}");
			}else {

			}
		}else {
			response.getWriter().print("{msg:"+ "既に登録されています"+"}");
		}

	}

}
