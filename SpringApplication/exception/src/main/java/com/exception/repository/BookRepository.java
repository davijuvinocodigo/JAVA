package com.exception.repository;

import org.springframework.data.repository.CrudRepository;

import com.exception.model.Book;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}