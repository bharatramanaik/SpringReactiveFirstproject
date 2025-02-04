package com.springreactive.firstproject.services.imple;

import com.springreactive.firstproject.entities.Book;
import com.springreactive.firstproject.repository.BookRepository;
import com.springreactive.firstproject.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImple implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Mono<Book> create(Book book) {
        return bookRepository.save(book).log();
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> get(int bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
        Mono<Book> oldbook = bookRepository.findById(bookId);
        System.out.println(Thread.currentThread().getName()+" before flatmap");
        Mono<Book> newbook = oldbook.flatMap(book1 -> {
            book1.setName(book.getName());
            book1.setAuthor(book.getAuthor());
            book1.setDescription(book.getDescription());
            book1.setPublisher(book.getPublisher());
            System.out.println(Thread.currentThread().getName()+" inside flatmap ");
            return bookRepository.save(book1);
        }).log();
        System.out.println(Thread.currentThread().getName()+" after flatmap");
        return newbook;
    }

    @Override
    public Mono<Void> delete(int bookId) {
        return bookRepository.deleteById(bookId).log();
    }

    @Override
    public Mono<Book> search(String query) {
        return null;
    }
}
