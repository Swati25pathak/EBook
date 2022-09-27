package com.Ebook.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Ebook.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query("select e from User e where e.email  = :#{#req. email} ")
	Optional<User> findUser(@Param("req") User req);

	boolean existsByEmail(String email);
}
