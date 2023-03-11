package com.duyhelloworld.baedungfirstwebapp.repo;

import java.util.TreeMap;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.duyhelloworld.baedungfirstwebapp.model.Book;

public interface BookRepo extends CrudRepository<Book, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Book WHERE title = ?")
    TreeMap<String, Book> findByTitle(@Param("title") String title);
}
