package com.Ebook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Ebook.Entity.BookEntity;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long>

{
	@Query("Select a from BookEntity a where a.bookName=?1 order by a.bookName")
	BookEntity FindBybookName(String bookName);

}