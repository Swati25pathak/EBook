package com.Ebook.Service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Ebook.Entity.Author;
import com.Ebook.Entity.UserType;
import com.Ebook.Repository.AuthorRepository;

@SpringBootTest
class AutherServiceTest {

	@Autowired
	private AutherService autherservice;

	@MockBean
	private AuthorRepository authorrepo;

	@Test
	void testAddDetails() {
		Author author = new Author();
		author.setEmail("Sahithi@gmail.com");
		author.setMobileNumber("1234567890");
		author.setUserName("Sahithi");
		author.setPassword("Sahithi@12345");
		author.setRegistrationNumber((long) 423451);
		author.setUsertype(UserType.AUTHOR);
		Mockito.when(authorrepo.save(author)).thenReturn(author);
		assertThat(autherservice.AddDetails(author)).isEqualTo(author);
	}
//
//	@Test
//	void testDeleteRegister() {
//		
//		Author author = new Author();
//		author.setEmail("Sahithi@gmail.com");
//		author.setMobileNumber("1234567890");
//		author.setName("sahithi");
//		author.setPassword("Sahithi@123");
//		author.setRegistrationNumber(123);
//		author.setUsertype(UserType.AUTHOR);
//		Mockito.when(authorrepo.delete(author.getRegistrationNumber() & author.getPassw).thenReturn(author);
//		
//		//
//		
//	}

	@Test
	void testGetDetails() {
		Author author = new Author();
		author.setEmail("Sahithi@gmail.com");
		author.setMobileNumber("1234567890");
		author.setUserName("Sahithi");
		author.setPassword("Sahithi@123");
		author.setRegistrationNumber((long) 423451);
		author.setUsertype(UserType.AUTHOR);

		Author author1 = new Author();
		author1.setEmail("Ramani@gmail.com");
		author1.setMobileNumber("5432156790");
		author1.setUserName("Ramani");
		author1.setPassword("Ramani@123");
		author1.setRegistrationNumber( (long) 423451);
		author1.setUsertype(UserType.USER);

		List<Author> addAuthor = new ArrayList<>();
		addAuthor.add(author1);
		addAuthor.add(author);

		Mockito.when(authorrepo.findAll()).thenReturn(addAuthor);
		assertThat(autherservice.getDetails()).isEqualTo(addAuthor);
	}

	@Test
	void testUpdateAuthorDetails() throws Throwable {
		Author author1 = new Author();
		author1.setEmail("Nandini@gmail.com");
		author1.setMobileNumber("5432156790");
		author1.setUserName("Nandini");
		author1.setPassword("Nandini@123");
		author1.setRegistrationNumber((long) 423451);
		author1.setUsertype(UserType.USER);
		Mockito.when(authorrepo.findByRegistrationNumber(42345l)).thenReturn(author1);
		author1.setEmail("Durga@gmail.com");
		Mockito.when(authorrepo.save(author1)).thenReturn(author1);
		assertThat(autherservice.updateAuthorDetails(author1, 42345l)).isEqualTo(author1);
	}


	
	
	

}
