package logic;

import dao.AccountDAO;
import model.Account;

public class AinsLogic {

	public boolean ains(Account ac) {
		AccountDAO dao = new AccountDAO();
		return dao.ains(ac);

	}
}
