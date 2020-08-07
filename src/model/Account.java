package model;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
	private int id;
	private String pass;
	private String name;
	private List<Kind> kinds;

	public Account() {
	}

	public Account(Account account) {
		this.id=account.id;
		this.pass = account.pass;
		this.name = account.name;
		this.kinds = account.kinds;
	}

	public Account(int id, String pass, String name,List<Kind> kinds) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.kinds = kinds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Kind> getKinds() {
		return kinds;
	}

	public void setKinds(List<Kind> kinds) {
		this.kinds = kinds;
	}


}
