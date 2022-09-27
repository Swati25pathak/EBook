package com.Ebook.Service;

import java.util.List;

import com.Ebook.Entity.Author;
import com.Ebook.Exception.ResourceNotFoundException;

public interface AutherService {

	public Author AddDetails(Author author);

	public String deleteRegister(Long registernumber) throws ResourceNotFoundException;

	public List<Author> getDetails();

	public Author updateAuthorDetails(Author author, Long authorId) throws ResourceNotFoundException;

	public Author findUserById(Long registrationnumber);


}