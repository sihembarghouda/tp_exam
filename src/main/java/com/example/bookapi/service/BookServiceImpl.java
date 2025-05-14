package com.example.bookapi.service;

import com.example.bookapi.model.book;
import com.example.bookapi.repository.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable(value = "books")
    public List<book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    @Cacheable(value = "book", key = "#isbn")
    public book getBookByIsbn(String isbn) {
        return repository.findById(isbn).orElse(null);
    }

    @Override
    public book createBook(Book book) {
        return null;
    }

    @CachePut(value = "book", key = "#book.isbn")
    @CacheEvict(value = "books", allEntries = true)
    @Override
    public book createBook(book book) {
        return repository.save(book);
    }

    @Override
    @CachePut(value = "book", key = "#isbn")
    @CacheEvict(value = "books", allEntries = true)
    public book updateBook(String isbn, Book updatedBook) {
        Optional<book> bookOptional = repository.findById(isbn);
        if (bookOptional.isPresent()) {
            book book = bookOptional.get();
            book.setTitle(updatedBook());
            book.setAuthor(updatedBook());
            return repository.save(book);
        }
        return null;
    }

    private String updatedBook() {
     return null;}

    @Override
    @Caching(evict = {
            @CacheEvict(value = "book", key = "#isbn"),
            @CacheEvict(value = "books", allEntries = true)
    })
    public void deleteBook(String isbn) {
        repository.deleteById(isbn);
    }
}
