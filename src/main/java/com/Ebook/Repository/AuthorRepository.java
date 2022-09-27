package com.Ebook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ebook.Entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


	public Author findByRegistrationNumber(Long registernumber);

}
