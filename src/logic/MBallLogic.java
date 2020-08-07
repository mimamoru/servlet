package logic;

import java.util.List;

import dao.MyBookDAO;
import model.MyBook;

public class MBallLogic {

	public List<MyBook> mball(String like,int order,int kind){
		MyBookDAO dao = new MyBookDAO();
		return dao.mball(like,order,kind);
	}
}
