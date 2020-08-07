package model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class MyBook implements Serializable {
	private int id;
	private int account_id;
	private int book_id;
	private String title;
	private String text;
	private boolean favorite;
	private int kind_num;
	private LocalDate modified;

	public MyBook() {
	}

	public MyBook(MyBook myBook) {
		this.id = myBook.id;
		this.account_id = myBook.account_id;
		this.book_id = myBook.book_id;
		this.title = myBook.title;
		this.text = myBook.text;
		this.favorite = myBook.favorite;
		this.kind_num = myBook.kind_num;
		this.modified = myBook.modified;
	}

	public MyBook(int id, int account_id, int book_id, String title, String text, boolean favorite, int kind_num,
			Date modified) {
		this.id = id;
		this.account_id = account_id;
		this.book_id = book_id;
		this.title = title;
		this.text = text;
		this.favorite = favorite;
		this.kind_num = kind_num;
		this.modified = modified.toLocalDate();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int bookt_id) {
		this.book_id = bookt_id;
	}

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}


	public boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public int getKind_num() {
		return kind_num;
	}

	public void setKind_num(int kind_num) {
		this.kind_num = kind_num;
	}


	public Date getModified() {
		return Date.valueOf(modified);
	}


	public void setModified(LocalDate modified) {
		this.modified = modified;
	}



}
