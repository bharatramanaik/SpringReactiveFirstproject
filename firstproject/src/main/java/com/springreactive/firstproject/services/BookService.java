package com.springreactive.firstproject.services;

import com.springreactive.firstproject.entities.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {

        public Mono<Book> create(Book book);

        public Flux<Book> getAll();

        public Mono<Book> get(int bookId);

        public Mono<Book> update(Book book, int bookId);

        public Mono<Void> delete(int bookId);

        public Mono<Book> search(String query);
}
