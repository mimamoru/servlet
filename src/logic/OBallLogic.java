package logic;

import java.util.List;

import dao.OurBookDAO;
import model.Account;
import model.OurBook;

public class OBallLogic {

	public List<OurBook> oball(Account account,int order){
		OurBookDAO dao = new OurBookDAO();
		return dao.oball(account.getId(),order);
	}
}
