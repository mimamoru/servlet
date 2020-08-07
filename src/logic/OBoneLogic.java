package logic;

import dao.OurBookDAO;
import model.OurBook;

public class OBoneLogic {

	public OurBook obone(int id) {
		OurBookDAO dao = new OurBookDAO();
		return dao.obone(id);
	}
}
