package com.example.bookapi.service;

import com.example.bookapi.model.book;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    List<book> getAllBooks();
    book getBookByIsbn(String isbn);
    book createBook(Book book);

    @CachePut(value = "book", key = "#book.isbn")
    @CacheEvict(value = "books", allEntries = true)
    book createBook(book book);

    book updateBook(String isbn, Book book);
    void deleteBook(String isbn);
}
