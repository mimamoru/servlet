package logic;

import dao.KindDAO;
import model.Kind;

public class KupLogic {
public Kind kup(Kind kind) {
	KindDAO dao = new KindDAO();
	return dao.kup(kind);
	}
}
