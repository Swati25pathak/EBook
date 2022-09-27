package com.Ebook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ebook.Entity.BookEntity;
import com.Ebook.Exception.ResourceNotFoundException;
import com.Ebook.Repository.BookRepo;

@Service
public class BookServiceImpl {

	@Autowired
	private BookRepo repo;

	public BookRepo getRepo() {
		return repo;
	}

	public void setRepo(BookRepo repo) {
		this.repo = repo;
	}

	public BookEntity addBook(BookEntity a) {
		return repo.save(a);

	}

	public List<BookEntity> getBooks() {
		List<BookEntity> lf1 = repo.findAll();
		return lf1;
	}

	// Update Books
	public BookEntity updateBook(BookEntity a) throws Throwable {
		Long id = a.getBookId();

		BookEntity a1 = repo.findById(id).orElseThrow();

		a1.setBookName(a.getBookName());
		a1.setBookId(a.getBookId());
		repo.save(a1);
		return a1;
	}

	// getBookById

	public BookEntity getBookById(Long bookId) throws Throwable {

		BookEntity a = repo.findById(bookId).orElseThrow();
		return a;
	}

//	//deleteBookById
//	public String deleteBookById(int bookId)
//	{
//	repo.deleteBookById(bookId);
//	return "Deleted";
//	}
//	
//	

	public BookEntity updateBook(Long id, BookEntity book) throws Throwable {

		BookEntity existingBook = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not found"));
		existingBook.setBookName(book.getBookName());
		// existingBook.setBookId(book.getBookId());
		existingBook.setAuthorName(book.getAuthorName());
		existingBook.setBookPages(book.getBookPages());
		repo.save(existingBook);
		return existingBook;
	}

}
