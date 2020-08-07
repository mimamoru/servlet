package logic;

import java.util.List;

import dao.KindDAO;
import model.Kind;

public class KallLogic {
	public  List<Kind> kall(int id) {
		KindDAO dao = new KindDAO();
		return dao.kall(id);
	}
}
