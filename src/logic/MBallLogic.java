package logic;

import java.util.List;

import dao.MyBookDAO;
import model.MyBook;

public class MBallLogic {

	public List<MyBook> mball(int account_id,int kind){
		MyBookDAO dao = new MyBookDAO();
		return dao.mball(account_id,kind);
	}
}