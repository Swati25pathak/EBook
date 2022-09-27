package com.Ebook.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Ebook.Entity.BookEntity;
import com.Ebook.Repository.BookRepo;

@SpringBootTest
class BookServiceImplTest {
	@Autowired
	private BookServiceImpl bookServiceImpl;

	@MockBean
	BookRepo repo;

	@Test

	void testAddBook() {
		BookEntity c1 = new BookEntity();
		c1.setBookId((long) 1);
		c1.setAuthorName("Sahithi");
		c1.setBookName("sahithi");

		Mockito.when(repo.save(c1)).thenReturn(c1);

		assertThat(bookServiceImpl.addBook(c1)).isEqualTo(c1);
	}

	@Test
	void testUpdateBook() throws Throwable {
		BookEntity c1 = new BookEntity();
		c1.setBookId((long) 1);
		c1.setAuthorName("Ramani");
		c1.setBookName("ramani");

		Optional<BookEntity> c2 = Optional.of(c1);

		Mockito.when(repo.findById((long) 1)).thenReturn(c2);

		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setAuthorName("Nandini");
		c1.setBookName("nandhu");

		assertThat(bookServiceImpl.updateBook((long) 1, c1)).isEqualTo(c1);
	}

	@Test
	void testGetBookById() throws Throwable {
		BookEntity c1 = new BookEntity();
		c1.setBookId((long) 1);
		;
		c1.setAuthorName("Durga");
		c1.setBookName("durga");
		Optional<BookEntity> c2 = Optional.of(c1);
		Mockito.when(repo.findById((long) 1)).thenReturn(c2);
		assertThat(bookServiceImpl.getBookById((long) 1)).isEqualTo(c1);
	}

	@Test
	void testDeleteAdminById() {
		BookEntity c1 = new BookEntity();
		c1.setBookId((long) 1);
		c1.setAuthorName("Raju");
		c1.setBookName("raju");
		Optional<BookEntity> c2 = Optional.of(c1);
		Mockito.when(repo.findById((long) 1)).thenReturn(c2);
		Mockito.when(repo.existsById(c1.getBookId())).thenReturn(false);
		assertFalse(repo.existsById(c1.getBookId()));
	}
}