package model;

public class Kind {
	private int kind_num;
	private int account_id;
	private String kind_name;

	public Kind() {
		super();
	}

	public Kind(Kind kind) {
		this.kind_num = kind.kind_num;
		this.account_id = kind.account_id;
		this.kind_name = kind.kind_name;
	}

	public Kind(int kind_num, int account_id, String kind_name) {
		this.kind_num = kind_num;
		this.account_id = account_id;
		this.kind_name = kind_name;
	}

	public int getKind_num() {
		return kind_num;
	}

	public void setKind_num(int kind_num) {
		this.kind_num = kind_num;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getKind_name() {
		return kind_name;
	}

	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}



}
