package logic;

import dao.MyBookDAO;

public class MBchaLogic {

public boolean mbcha(int id,int num){
	MyBookDAO dao = new MyBookDAO();
	return dao.mbcha(id,num);
}

public boolean mbcha(int id,boolean like){
	MyBookDAO dao = new MyBookDAO();
	return dao.mbcha(id,like);
}

}
