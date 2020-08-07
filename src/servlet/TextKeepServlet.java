package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import logic.MBinsLogic;
import model.Account;
import model.MyBook;

/**
 * Servlet implementation class TextKeepServlet
 */
@WebServlet("/TextKeepServlet")
public class TextKeepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LocalDate toLocalDate(String date, String format) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date formatDate = sdf.parse(date);
        return LocalDate.ofInstant(formatDate.toInstant(), ZoneId.systemDefault());
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//mybookへ保存
	String[] book_ids=request.getParameterValues("book_ids");
	String[] titles=request.getParameterValues("titles");
	String[] texts=request.getParameterValues("texts");
	String[] dates=request.getParameterValues("dates");
	HttpSession session=request.getSession();
	Account account=(Account)session.getAttribute("account");
	int account_id=account.getId();
	List<MyBook> myBooks=new ArrayList<MyBook>();
	MyBook myBook;
	for(int i=0; i<book_ids.length; i++) {
		int book_id=Integer.parseInt(book_ids[i]);
		String title=titles[i];
		String text=texts[i];
		LocalDate date=null;
		try {
			date = toLocalDate(dates[i],"yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		myBook=new MyBook();
		myBook.setAccount_id(account_id);
		myBook.setBook_id(book_id);
		myBook.setTitle(title);
		myBook.setText(text);
		myBook.setModified(date);
		myBook.setFavorite(false);
		myBook.setKind_num(0);
		MBinsLogic logic =new MBinsLogic();
		myBook =logic.mbins(myBook);
		myBooks.add(myBook);
	}

	if(myBooks.size()==0) {
		response.getWriter().print("{msg:"+ "保存に失敗しました"+"}");
	}else{
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(myBooks);
		response.getWriter().print(json);
	}

}

}
