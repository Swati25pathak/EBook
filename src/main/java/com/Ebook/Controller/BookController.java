package com.Ebook.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Ebook.Entity.BookEntity;
import com.Ebook.Service.BookServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class BookController {
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	
	@ResponseBody
	@GetMapping(path="/getBook/{bookId}")
	public ResponseEntity <BookEntity> getBookById(@PathVariable("bookId") Long bookId) throws Throwable
	{
	BookEntity a1 = bookServiceImpl.getBookById(bookId);
	ResponseEntity<BookEntity> re = new ResponseEntity<BookEntity>(a1,HttpStatus.OK);
	return re;
	}
	
	@ResponseBody
	@GetMapping(path="/getbooks")
	public ResponseEntity <List<BookEntity>> getbooks()
	{
	List<BookEntity> lf1 = bookServiceImpl.getBooks();
	ResponseEntity<List<BookEntity>> re = new ResponseEntity<List<BookEntity>>(lf1,HttpStatus.OK);
	return re;
	}
	
	@ResponseBody
	@PostMapping(path="/addBook")
	public ResponseEntity <BookEntity> addBook(@RequestBody BookEntity a)
	{
	BookEntity a1 = bookServiceImpl.addBook(a);
	ResponseEntity<BookEntity> re = new ResponseEntity<BookEntity>(a1,HttpStatus.OK);
	return re;
	}
	
	@ResponseBody
	 @PutMapping(path="/updateBook/{id}")
	 public ResponseEntity<BookEntity> updateBook(@PathVariable(value="id")Long userId, @RequestBody BookEntity e) throws Throwable
	 {
	 BookEntity e1=bookServiceImpl.updateBook(userId, e);
	
	 ResponseEntity<BookEntity> re=new ResponseEntity<BookEntity>(e1,HttpStatus.OK);
	 return re;
	 }
	 
	 
//	@DeleteMapping(path="/deleteBookById/{bookId}")
//	public ResponseEntity <String> deleteBookById(@PathVariable int bookId)
//	{
//	bookService.deleteBookById(bookId);
//	ResponseEntity re = new ResponseEntity<String>(HttpStatus.OK);
//	return re;
//	}
	
	
	// update book rest api
//	@PutMapping("book/update/{id}")
//	public ResponseEntity<BookEntity> updateBook(@PathVariable("id") int id, @RequestBody BookEntity book) throws Throwable{
//	return new ResponseEntity<BookEntity>(bookServiceImpl.updateBook(book, id), HttpStatus.OK);
//	}
//	
}



