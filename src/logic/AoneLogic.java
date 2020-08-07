package logic;

import dao.AccountDAO;
import model.Account;

public class AoneLogic {
	public Account aone(Account ac) {
		AccountDAO dao = new AccountDAO();
		return dao.aone(ac);
	}
}
