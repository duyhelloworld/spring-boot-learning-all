package com.duyhelloworld.baedungfirstwebapp.controller;

import java.util.TreeMap;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.duyhelloworld.baedungfirstwebapp.exception.BookIdMissmatchException;
import com.duyhelloworld.baedungfirstwebapp.exception.BookNotFoundException;
import com.duyhelloworld.baedungfirstwebapp.model.Book;
import com.duyhelloworld.baedungfirstwebapp.repo.BookRepo;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {
    
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/")
    public Iterable<Book> findAll() {
        return bookRepo.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public TreeMap<String, Book> findByTitle(@PathVariable String bookTitle) {
        return bookRepo.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        Supplier<BookNotFoundException> exception = () -> new BookNotFoundException("Not found this book.",
                new Throwable("Wrong id!"));
        return bookRepo.findById(id).orElseThrow(exception);
    }

    @PostMapping(path = "/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepo.save(book);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepo.findById(id).orElseThrow();
        bookRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable Long id) {
        if (book.getId() != id) {
            try {
                throw new BookIdMissmatchException();
            } catch (BookIdMissmatchException e) {
                e.printStackTrace();
            }
        }
        Supplier<BookNotFoundException> exception = () -> new BookNotFoundException("Not found this book.",
                new Throwable("Wrong id!"));
        bookRepo.findById(id)
                .orElseThrow(exception);
        return bookRepo.save(book);
    }
}
