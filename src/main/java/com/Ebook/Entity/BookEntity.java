package com.Ebook.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class BookEntity {
	
	@GeneratedValue
	@Id
	@Column(name="bookId")
	private Long bookId;
	
	@Column(name="bookName",nullable=false)
	private String bookName;
	
	@Column(name="authorName",nullable=false)
	private  String authorName;
	
	@Column(name="bookPages",nullable=false)
	private int bookPages;
	
	public BookEntity() {
	}

	public BookEntity(Long bookId, String bookName, String authorName, int bookPages) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookPages = bookPages;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getBookPages() {
		return bookPages;
	}

	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}

	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", bookPages="
				+ bookPages + "]";
	}
	
}
	
	