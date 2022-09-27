package com.Ebook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ebook.Entity.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
