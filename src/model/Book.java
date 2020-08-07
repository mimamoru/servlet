package model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Book implements Serializable {

	private int id;
	private String title;
	private String text;
	private LocalDate modified;
	private int auther_id;
	private boolean visible;

	public Book() {
		}

	public Book(Book book) {
		this.id = book.id;
		this.title = book.title;
		this.text = book.text;
		this.modified = book.modified;
		this.visible=book.visible;
	}

	public Book(int id, String title, String text, Date modified, int auther_id,boolean visible) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.modified = modified.toLocalDate();
		this.auther_id = auther_id;
		this.visible=visible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getModified() {
		return Date.valueOf(modified);
	}
	public void setModified(LocalDate modified) {
		this.modified = modified;
	}

	public int getAuther_id() {
		return auther_id;
	}

	public void setAuther_id(int auther_id) {
		this.auther_id = auther_id;
	}

	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}



}
