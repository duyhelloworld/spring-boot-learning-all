package com.duyhelloworld.baedungfirstwebapp.repo;

import java.util.TreeMap;

import org.springframework.data.repository.CrudRepository;

import com.duyhelloworld.baedungfirstwebapp.model.Book;

public interface BookRepo extends CrudRepository<Book, Long> {
    TreeMap<String, Book> findByTitle(String title);
}
