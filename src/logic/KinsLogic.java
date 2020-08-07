package logic;

import java.util.List;

import dao.KindDAO;
import model.Account;
import model.Kind;

public class KinsLogic {
	public List<Kind> kins(Account account) {
		KindDAO dao = new KindDAO();
		return dao.kins(account);
	}
}
