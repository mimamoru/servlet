package logic;

import dao.KindDAO;

public class KoneLogic {
public String kone(int account_id,int kind_num){
		KindDAO dao = new KindDAO();
		return dao.kone(account_id, kind_num);

	}
}
