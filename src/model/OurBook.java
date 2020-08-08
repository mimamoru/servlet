package model;

import java.io.Serializable;
import java.util.List;

public class OurBook implements Serializable {

	private int id;
	private String name;
	private String pass;
	private int ownner_id;
	private List<Book> oBooks;
	private boolean visible;

	public OurBook() {

	}

	public OurBook(int id, String name, String pass, int ownner_id,List<Book> oBooks,boolean visible) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.ownner_id = ownner_id;
		this.oBooks=oBooks;
		this.visible=visible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getOwnner_id() {
		return ownner_id;
	}

	public void setOwnner_id(int ownner_id) {
		this.ownner_id = ownner_id;
	}

	public List<Book> getOBooks() {
		return oBooks;
	}

	public void setOBooks(List<Book> oBooks) {
		this.oBooks = oBooks;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}




}
